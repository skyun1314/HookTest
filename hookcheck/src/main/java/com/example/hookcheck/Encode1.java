package com.example.hookcheck;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.Deflater;


/**
 * Created by zk on 2017/12/21.
 */

public class Encode1 {


    static class c{

        private static byte[] a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
        private final int b=1;
        private final int c=0;
        private String version="1.0";
        private String address="5836a0ab7f2c746c4b001800";//address  UMENG_APPKEY 默认
        private static byte[] m = ("359125053640852"+"f8:a9:d0:71:6d:07").getBytes();//（（mac+imei）.getbyte（））


        //下面这个是  需要加密的中间值。我hook下来了
        private static byte[] entity_str=Encode.hexStringToBytes("1C150015001500001C18183538333661306162376632633734366334623030313830301805322E322E3515C203180F636F6D2E737A71642E6469616C657215001805352E342E32180E79757A6875616E676365736869323500001C180F33353931323530353336343038353218203635333261363463346461343835633531393463366264616365373837623133181166383A61393A64303A37313A36643A30372812414F5350206F6E2048616D6D657248656164181B41524D76372050726F636573736F72207265762030202876376C291807416E64726F69641805342E342E341C15E01B15F01000380A68616D6D6572686561641807416E64726F696416D0949FB1B95718034C474518064B5455383450180A68616D6D657268656164001C150018027A681802434E38003504001C1684F59DDE9258004C1B058C0A616E64726F69645F69641810653861616566373832616339653232351692F69DDE9258150200036D6163181166383A61393A64303A37313A36643A30371692F69DDE92581502000673657269616C181030366465616232633433613862313465168CF69DDE925815020004696D6569180F3335393132353035333634303835321692F69DDE92581502000569646D6435182036353332613634633464613438356335313934633662646163653738376231331686F69DDE9258150200195C180569646D6435282036353332613634633464613438356335313934633662646163653738376231331686F69DDE925800180673657269616C281030366465616232633433613862313465168CF69DDE92580018036D6163281166383A61393A64303A37313A36643A30371692F69DDE9258001804696D6569280F3335393132353035333634303835321692F69DDE925800180A616E64726F69645F69642810653861616566373832616339653232351692F69DDE9258000000"/*Encode2.bn.b()*/);;

        private int length=entity_str.length;
        private static byte[] entity= a(entity_str);;
        private static int timestamp=/*1514343218; */  ((int)(System.currentTimeMillis() / 1000));//ts_secs;
        private byte[] signature= d()  ;//signature
        private byte[] guid= a(signature,timestamp);;
        private  final  int serial1=1;
        private byte[] checksum=e();
         int codex = 0;



        private boolean n=false;;
     //   public int j=0;//codex


        private byte[] e() {
            StringBuilder v0 = new StringBuilder();
            v0.append(Encode.Byte2HexStr(signature));
            v0.append(serial1);
            v0.append(this.timestamp);
            v0.append(this.length);
            v0.append(Encode.Byte2HexStr(guid));
            return b(v0.toString().getBytes());
        }






        public static byte[] b(byte[] bArr) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bArr);
                return instance.digest();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }




        private static byte[] d() {
            return a(a,/*1514343218*/ timestamp);
        }


        public static byte[] a(byte[] bArr)  {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[8192];
            int a = 0;
            ByteArrayOutputStream byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (!deflater.finished()) {
                    try {
                        int deflate = deflater.deflate(bArr2);
                        a += deflate;
                        byteArrayOutputStream.write(bArr2, 0, deflate);
                    } catch (Throwable th2) {
                    }
                }
                deflater.end();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            return null;
        }


        private static byte[] a(byte[] arg10, int arg11) {

            int v8 = 2;
            int v0 = 0;
            byte[] v2 = b(m);
            byte[] v3 = b(entity);
            int v4 = v2.length;
            byte[] v5 = new byte[v4 * 2];
            int v1;
            for(v1 = 0; v1 < v4; ++v1) {
                v5[v1 * 2] = v3[v1];
                v5[v1 * 2 + 1] = v2[v1];
            }

            for(v1 = 0; v1 < v8; ++v1) {
                v5[v1] = arg10[v1];
                v5[v5.length - v1 - 1] = arg10[arg10.length - v1 - 1];
            }

            byte[] v1_1 = new byte[4];
            v1_1[0] = ((byte)(arg11 & 255));
            v1_1[1] = ((byte)(arg11 >> 8 & 255));
            v1_1[v8] = ((byte)(arg11 >> 16 & 255));
            v1_1[3] = ((byte)(arg11 >>> 24));
            while(v0 < v5.length) {
                v5[v0] = ((byte)(v5[v0] ^ v1_1[v0 % 4]));
                ++v0;
            }

            a=v5;
            return v5;
        }

    }


    static class bp{





        private static byte B=15;//注意这里
        private static final Encode.db m = new Encode.db("version", (byte) 11, (short) 1);
        private static final Encode.db n = new Encode.db("address", (byte) 11, (short) 2);
        private static final Encode.db o = new Encode.db("signature", (byte) 11, (short) 3);
        private static final Encode.db p = new Encode.db("serial_num", (byte) 8, (short) 4);
        private static final Encode.db q = new Encode.db("ts_secs", (byte) 8, (short) 5);
        private static final Encode.db r = new Encode.db("length", (byte) 8, (short) 6);
        private static final Encode.db s = new Encode.db("entity", (byte) 11, (short) 7);
        private static final Encode.db t = new Encode.db("guid", (byte) 11, (short) 8);
        private static final Encode.db u = new Encode.db("checksum", (byte) 11, (short) 9);
        private static final Encode.db v = new Encode.db("codex", (byte) 8, (short) 10);


        public static boolean H() {
            return Encode.ce.a(B, 3);
        }






        public static void b()  {
            c bpVar= new c();

            Encode.a();
            if (bpVar.version != null) {
                Encode.a(m);
                Encode.a(bpVar.version);
            }
            if (bpVar.address != null) {
                Encode.a(n);
                Encode.a(bpVar.address);
            }
            if (bpVar.signature != null) {
                Encode.a(o);
                Encode.a(Encode.parseByte2HexStr(bpVar.signature));
            }
            Encode.a(p);
            Encode. a(bpVar.serial1);
            Encode. a(q);
            Encode. a(bpVar.timestamp);
            Encode.a(r);
            Encode. a(bpVar.length);
            if (bpVar.entity != null) {
                Encode. a(s);
                Encode. a( ByteBuffer.wrap(bpVar.entity));
            }
            if (bpVar.guid != null) {
                Encode. a(t);
                Encode. a(Encode.parseByte2HexStr(bpVar.guid));
            }

            if (bpVar.checksum != null) {
                Encode.  a(u);
                Encode. a(Encode.parseByte2HexStr(bpVar.checksum));
            }
            if (H()) {
                Encode.  a(v);
                Encode. a(bpVar.codex);
            }
            Encode.d();
            Encode. b();
            Log.e("wodelog", "haha1:"+Encode.buffer.toString());
            Encode.buffer.setLength(0);
        }


    }







}
