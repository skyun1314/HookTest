#include <jni.h>
#include <string>
#include <string.h>
#include<android/log.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include "substrate.h"
#include <iostream>
#include <iomanip>
#include <sstream>
#include <unwind.h>
#include <dlfcn.h>

#define LOGDD(...)  __android_log_print(ANDROID_LOG_DEBUG,"wodelog", __VA_ARGS__)
char *IP = "192.168.10.143";
short PORT = 10222;
typedef struct sockaddr SA;


struct BacktraceState
{
    intptr_t* current;
    intptr_t* end;
};


static _Unwind_Reason_Code unwindCallback(struct _Unwind_Context* context, void* arg)
{
    BacktraceState* state = static_cast<BacktraceState*>(arg);
    intptr_t ip = (intptr_t)_Unwind_GetIP(context);
    if (ip) {
        if (state->current == state->end) {
            return _URC_END_OF_STACK;
        } else {
            state->current[0] = ip;
            state->current++;
        }
    }
    return _URC_NO_REASON;
}

size_t captureBacktrace(intptr_t* buffer, size_t maxStackDeep)
{
    BacktraceState state = {buffer, buffer + maxStackDeep};
    _Unwind_Backtrace(unwindCallback, &state);
    return state.current - buffer;
}

void dumpBacktraceIndex(char *out, intptr_t* buffer, size_t count)
{
    for (size_t idx = 0; idx < count; ++idx) {
        intptr_t addr = buffer[idx];
        const char* symbol = "      ";
        const char* dlfile="      ";

        Dl_info info;
        if (dladdr((void*)addr, &info)) {
            if(info.dli_sname){
                symbol = info.dli_sname;
            }
            if(info.dli_fname){
                dlfile = info.dli_fname;
            }
        }else{
            strcat(out,"#                               \n");
            continue;
        }
        char temp[50];
        memset(temp,0,sizeof(temp));
        sprintf(temp,"%zu",idx);
        strcat(out,"#");
        strcat(out,temp);
        strcat(out, ": ");
        memset(temp,0,sizeof(temp));
        sprintf(temp,"0x%x",addr);
        strcat(out,temp);
        strcat(out, "  " );
        strcat(out, symbol);
        strcat(out, "      ");
        strcat(out, dlfile);
        strcat(out, "\n" );
    }
}

void backtraceToLogcat()
{

    const size_t maxStackDeep = 40;
    intptr_t stackBuf[maxStackDeep];
    char outBuf[2048];
    memset(outBuf,0,sizeof(outBuf));
    dumpBacktraceIndex(outBuf, stackBuf, captureBacktrace(stackBuf, maxStackDeep));
    LOGDD(" %s\n", outBuf);
}



extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_zk_ndktest_MainActivity_stringFromJNI(
    JNIEnv *env,
        jobject /* this */) {
    backtraceToLogcat();

    std::string hello = "Hello from C++";

    int sockfd = socket(PF_INET, SOCK_STREAM, 0);
    struct sockaddr_in addr;
    addr.sin_family = PF_INET;
    addr.sin_port = htons(PORT);
    addr.sin_addr.s_addr = inet_addr(IP);
    if (connect(sockfd, (SA *) &addr, sizeof(addr)) == -1) {
        LOGDD("无法连接到服务器");
    } else {
        LOGDD("客户端启动成功\n");
    }
    return env->NewStringUTF(hello.c_str());
}


int (*old_connect)(int sockfd, const struct sockaddr *addr, socklen_t addrlen);


int new_connect(int sockfd, const struct sockaddr *addr, socklen_t addrlen) {
    LOGDD("HOOK ====>new connect****************");
    char ip[128] = {0};
    int port = -1;
    if (addr->sa_family == AF_INET) {
        struct sockaddr_in *sa4 = (struct sockaddr_in *) addr;
        inet_ntop(AF_INET, (void *) (struct sockaddr *) &sa4->sin_addr, ip, 128);
        port = ntohs(sa4->sin_port);
        LOGDD("AF_INET  IP===>%s:%d", ip, port);
    } else if (addr->sa_family == AF_INET6) {
        struct sockaddr_in6 *sa6 = (struct sockaddr_in6 *) addr;
        char *ipv6 = NULL;
        inet_ntop(AF_INET6, (void *) (struct sockaddr *) &sa6->sin6_addr, ip, 128);
        ipv6 = strstr(ip, "f:");
        if (NULL != ipv6) {
            strcpy(ip, ipv6 + 2);
        }
        port = ntohs(sa6->sin6_port);
        LOGDD("af_inet6 IP===>%s:%d", ip, port);

        if (strcmp(ip, "42.96.248.220") == 0) {
            backtraceToLogcat();
            backtraceToLogcat();
        }


    } else {
        LOGDD("ip 端口未知");
        return old_connect(sockfd, addr, addrlen);
    }


    if (strcmp(ip, "115.23.20.178") == 0) {

        LOGDD("%s ==>127.0.0.1", ip);
        struct sockaddr_in my_addr;
        int my_len = sizeof(struct sockaddr_in);
        bzero(&my_addr, sizeof(my_addr));
        my_addr.sin_family = AF_INET;
        my_addr.sin_port = htons(80);
        my_addr.sin_addr.s_addr = inet_addr("127.0.0.1");

        return old_connect(sockfd, (const sockaddr *) &my_addr, sizeof(my_addr));
    } else {
        return old_connect(sockfd, addr, addrlen);
    }
    LOGDD("hook 成功");
    return old_connect(sockfd, addr, addrlen);
}

MSConfig(MSFilterLibrary, "libc.so");


//初始化时进行hook
MSInitialize {
    LOGDD("Substrate initialized.");
    MSImageRef image;
    image = MSGetImageByName("libc.so");

    if (image != NULL) {

        void *hookzlib = MSFindSymbol(image, "connect");

        if (hookzlib == NULL) {
            LOGDD("error find connect");
        } else {
            LOGDD("find connect ok");
            MSHookFunction(hookzlib, (void *) &new_connect, (void **) &old_connect);
        }

    } else {
        LOGDD("ERROR FIND LIBC");
    }
}
