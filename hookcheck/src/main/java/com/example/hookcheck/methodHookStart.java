package com.example.hookcheck;


import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class methodHookStart implements IXposedHookLoadPackage {


    private static final String TAG = "wodelog";

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

        if (lpparam.packageName.equals("com.szqd.dialer")) {
            XposedBridge.log("开始hook....360加固");
            //hook加固后的包，首先hook getNewAppInstance这个方法来获取context对象
            XposedHelpers.findAndHookMethod("com.stub.StubApp", lpparam.classLoader,
                    "getNewAppInstance", Context.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            //获取到360的Context对象，通过这个对象来获取classloader
                            Context context = (Context) param.args[0];
                            //获取360的classloader，之后hook加固后的就使用这个classloader
                            final ClassLoader classLoader = context.getClassLoader();
                            //下面就是强classloader修改成360的classloader就可以成功的hook了


                            Class<?> db = XposedHelpers.findClass("u.aly.db", classLoader);
                            Class<?> dg = XposedHelpers.findClass("u.aly.dg", classLoader);
                            Class<?> bp = XposedHelpers.findClass("u.aly.bp", classLoader);
                            Class<?> ap = XposedHelpers.findClass("u.aly.ap", classLoader);
                            final Class<?> bn = XposedHelpers.findClass("u.aly.bn", classLoader);
                            final Class<?> ao = XposedHelpers.findClass("u.aly.ao", classLoader);
                            final Class<?> ar = XposedHelpers.findClass("u.aly.ar", classLoader);
                            final Class<?> bf = XposedHelpers.findClass("u.aly.bf", classLoader);
                            final Class<?> az = XposedHelpers.findClass("u.aly.az", classLoader);
                            final Class<?> ax = XposedHelpers.findClass("u.aly.ax", classLoader);
                            final Class<?> bb = XposedHelpers.findClass("u.aly.bb", classLoader);


                            XposedHelpers.findAndHookMethod("u.aly.t", classLoader, "a", byte[].class, new XC_MethodHook() {//hook http調用的地方（傳參）
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log("加密后： " + parseByte2HexStr((byte[]) param.args[0]));
                                    // new Throwable("wodelog").printStackTrace();
                                }
                            });

                            XposedHelpers.findAndHookConstructor("u.aly.c", classLoader, byte[].class, String.class, byte[].class, new XC_MethodHook() {//hook http調用的地方（傳參）
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log("加密后中间的加密参数： " + parseByte2HexStr((byte[]) param.args[0]));

                                }
                            });




                     /*       XposedHelpers.findAndHookMethod("u.aly.y", classLoader, "b", bn,new XC_MethodHook() {//hook 參數生成的地方

                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    byte[] bp= (byte[]) param.getResult();

                                    XposedBridge.log( "加密后的参数为："+parseByte2HexStr(bp) );
                                    super.afterHookedMethod(param);


                                }
                            });*/


                            XposedHelpers.findAndHookMethod("u.aly.c", classLoader, "e", new XC_MethodHook() {//hook 參數生成的地方
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);


                                    Object bn_this = param.thisObject;
                                    Field[] declaredFields = bn_this.getClass().getDeclaredFields();

                                    XposedBridge.log("e_return:" + parseByte2HexStr((byte[]) param.getResult()).toString());

                                    for (int i = 0; i < declaredFields.length; i++) {
                                        Field declaredField = declaredFields[i];
                                        declaredField.setAccessible(true);

                                        Object o = declaredField.get(bn_this);

                                        if (declaredField == null || o == null) {

                                        } else {
                                            if (declaredField.getName().equals("f") || declaredField.getName().equals("g") || declaredField.getName().equals("h")) {
                                                XposedBridge.log(declaredField.getName() + ":" + o.getClass().getName() + ":" + parseByte2HexStr((byte[]) o).toString() + " (file_len=" + o.toString().length() + ")");
                                            } else {
                                                XposedBridge.log(declaredField.getName() + ":" + o.getClass().getName() + ":" + o.toString() + " (file_len=" + o.toString().length() + ")");
                                            }


                                        }

                                    }


                                }
                            });

                            XposedHelpers.findAndHookMethod("u.aly.c", classLoader, "a", byte[].class, int.class, new XC_MethodHook() {//hook 參數生成的地方

                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);

                                    XposedBridge.log("c类里面 d函数  的第一个参数:" + parseByte2HexStr((byte[]) param.args[0]));
                                    XposedBridge.log("c类里面 d函数  的时间戳:" + param.args[1]);

                                    Field j_int = param.thisObject.getClass().getDeclaredField("j");
                                    j_int.setAccessible(true);
                                    Object j = j_int.get(param.thisObject);
                                    XposedBridge.log("c类里面 j变量  的时间戳:" + j);

                                    Field m_int = param.thisObject.getClass().getDeclaredField("m");
                                    m_int.setAccessible(true);
                                    Object m = m_int.get(param.thisObject);
                                    XposedBridge.log("c类里面 m:" + parseByte2HexStr((byte[]) m));

                                    Field l_int = param.thisObject.getClass().getDeclaredField("l");
                                    l_int.setAccessible(true);
                                    Object l = l_int.get(param.thisObject);
                                    XposedBridge.log("c类里面 l:" + parseByte2HexStr((byte[]) l));


                                    XposedBridge.log("c类里面 signature:" + parseByte2HexStr((byte[]) param.getResult()));

                                }
                            });

                            //  final String class_name[]={"ap","ao","bi","ar","bf","am","at","cr","av","bc","bg","be","bm","bl","bb","ba","ax","ay","az","an","bd","aq","bn"};
                            final String class_name[] = {"at", "cr", "av", "bc", "bg", "be", "bm", "bl", "ba", "an", "bd", "aq", "bn"};
                            for (int i = 0; i < class_name.length; i++) {
                                final int finalI = i;
                                XposedHelpers.findAndHookMethod("u.aly." + class_name[i], classLoader, "b", dg, new XC_MethodHook() {//hook 參數生成的地方
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        XposedBridge.log(class_name[finalI] + "------：" + param.thisObject.toString());
                                    }
                                });
                            }

                            XposedHelpers.findAndHookMethod("u.aly.bp$a", classLoader, "b", dg, bp, new XC_MethodHook() {//hook 參數生成的地方
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    Object bn_this = param.args[1];
                                    Field[] declaredFields = bn_this.getClass().getDeclaredFields();
                                    for (int i = 0; i < declaredFields.length; i++) {
                                        Field declaredField = declaredFields[i];
                                        declaredField.setAccessible(true);

                                        Object o = declaredField.get(bn_this);

                                        if (declaredField == null || o == null) {

                                        } else {

                                            if (declaredField.getName().equals("i")) {
                                                XposedBridge.log(declaredField.getName() + ":" + o.getClass().getName() + ":" + o.toString() + " (file_len=" + o.toString().length() + ")");

                                            }

                                        }

                                    }


                                }
                            });

                           /* XposedHelpers.findAndHookMethod("u.aly.cz", classLoader,"z", new XC_MethodHook() {
                                @Override
                                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                                    super.afterHookedMethod(param);

                                    Field f_boolean = param.thisObject.getClass().getDeclaredField("f");
                                    Field e_int = param.thisObject.getClass().getDeclaredField("e");
                                    f_boolean.setAccessible(true);
                                    e_int.setAccessible(true);
                                    Object f =f_boolean.get( param.thisObject);
                                    Object e =e_int.get( param.thisObject);


                                    XposedBridge.log( "string："+param.getResult() +";f:"+f+";e:"+e);
                                }
                            });*/






  /*


        //    final String class_name[]={"ap","ao","bi","ar","bf","am","at","cr","av","bc","bg","be","bm","bl","bb","ba","ax","ay","az","an","bd","aq","bn"};
                            final String class_name[]={"at","cr","av","bc","bg","be","bm","bl","ba","an","bd","aq","bn"};
                            for (int i = 0; i < class_name.length; i++) {
                                 final int finalI = i;
                                XposedHelpers.findAndHookMethod("u.aly."+class_name[i], classLoader, "b", dg,new XC_MethodHook() {//hook 參數生成的地方
                                    @Override
                                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                        super.beforeHookedMethod(param);
                                        XposedBridge.log( class_name[finalI]+"------："+param.thisObject.toString() );
                                    }
                                });
                            }



                            XposedHelpers.findAndHookMethod("u.aly.da", classLoader, "a", db,new XC_MethodHook() {//hook 參數生成的地方
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    Class<?> da = param.thisObject.getClass();
                                    final Field declaredField = da.getDeclaredField("n");
                                    declaredField.setAccessible(true);
                                    short n= (short) declaredField.get(param.thisObject);
                                //    XposedBridge.log( "我找到了n:"+n  );
                                }
                            });






                        XposedHelpers.findAndHookMethod("u.aly.t", classLoader, "aaaaaa", byte[].class, new XC_MethodHook() {//hook http調用的地方（傳參）
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log("加密后： " +parseByte2HexStr((byte[]) param.args[0]));
                                    new Throwable("wodelog").printStackTrace();
                                }
                            });


                            XposedHelpers.findAndHookMethod("u.aly.c", classLoader, "c", new XC_MethodHook() {//hook 參數生成的地方
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log( "參數生成的地方1："+   param.thisObject.toString());

                                }
                            });
                            XposedHelpers.findAndHookMethod("u.aly.bp", classLoader, "e",String.class, new XC_MethodHook() {//hook 參數生成的地方
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log(  "參數生成的地方2："+   param.thisObject.toString());


                                    XposedHelpers.findAndHookMethod("u.aly.ds", classLoader, "b",byte[].class,int.class,int.class, new XC_MethodHook() {//hook aes
                                        @Override
                                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                            super.beforeHookedMethod(param);
                                    *//*XposedBridge.log( "u.aly.ds.write(byte[],int,int):pamer1: "+parseByte2HexStr((byte[]) param.args[0]));
                                    XposedBridge.log( "u.aly.ds.write(byte[],int,int):pamer2: "+ param.args[1]);
                                    XposedBridge.log( "u.aly.ds.write(byte[],int,int):pamer3: "+ param.args[2]);*//*

                                            XposedBridge.log( "u.aly.ds.write(byte[],int,int):pamer: "+  getArrByLen((byte[]) param.args[0],(int)param.args[2]));

                                          *//*StackTraceElement[] wodelogs = new Throwable("wodelog").getStackTrace();
                                            for (int i = 0; i <wodelogs.length ; i++) {
                                                XposedBridge.log( wodelogs[i].toString());
                                            }*//*


                                            Class<?> aClass1 = XposedHelpers.findClass("u.aly.ds", classLoader);
                                            Field b = aClass1.getDeclaredField("b");
                                            b.setAccessible(true);

                                            ByteArrayOutputStream outputStream= (ByteArrayOutputStream) b.get(param.thisObject);
                                            XposedBridge.log("监控是不是结果 "+  parseByte2HexStr(outputStream.toByteArray()));

                                        }
                                    });


                                }
                            });
 XposedHelpers.findAndHookMethod("com.umeng.analytics.b", classLoader, "aaaaaa",byte[].class,byte[].class, new XC_MethodHook() {//hook aes
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log("aes1:"+ parseByte2HexStr((byte[]) param.args[1]));

                                }
                            });
                            XposedHelpers.findAndHookMethod("com.umeng.analytics.b", classLoader, "b",byte[].class,byte[].class, new XC_MethodHook() {//hook aes
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log( "aes2:"+parseByte2HexStr((byte[]) param.args[1]));
                                }
                            });
                            XposedHelpers.findAndHookMethod("com.umeng.analytics.b", classLoader, "aaaaaa",String.class, new XC_MethodHook() {//hook aes
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log( "aes3:"+param.args[0]);
                                }
                            });
                            XposedHelpers.findAndHookMethod("com.umeng.analytics.b", classLoader, "aaaaaa",byte[].class, new XC_MethodHook() {//hook aes
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log( "com.umeng.analytics.b.aaaaaa(byte[]):参数："+parseByte2HexStr((byte[]) param.args[0]));
                                }
                            });







                            XposedHelpers.findAndHookMethod("com.umeng.analytics.b", classLoader, "b",byte[].class, new XC_MethodHook() {//hook aes
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                                    super.beforeHookedMethod(param);
                                    XposedBridge.log( "com.umeng.analytics.b.b(byte[]):参数："+parseByte2HexStr((byte[]) param.args[0]));

                                    StackTraceElement[] wodelogs = new Throwable("wodelog").getStackTrace();
                                    for (int i = 0; i <wodelogs.length ; i++) {
                                        XposedBridge.log( wodelogs[i].toString());
                                    }

                                    if(param.getResult()!=null){
                                        XposedBridge.log( "com.umeng.analytics.b.b(byte[]):返回值:"+parseByte2HexStr((byte[]) param.getResult()));
                                    }
                                }
                            });
*/
                        }
                    });
        }

    }

    public static String getArrByLen(byte[] bArr, int len) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < len; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }


    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

}
