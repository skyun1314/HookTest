package u.aly;

import android.util.Log;

import com.example.hookcheck.Encode;
import com.example.hookcheck.Encode2;

import java.util.HashMap;


public class cz {



    public final class dt{
        private byte[] a;
        private int b;
        private int c;

        public dt() {
            super();
        }

        public dt(byte[] arg1) {
            super();
            this.a(arg1);
        }

        public dt(byte[] arg1, int arg2, int arg3) {
            super();
            this.c(arg1, arg2, arg3);
        }

        public void a(byte[] arg3) {
            this.c(arg3, 0, arg3.length);
        }

        public int a(byte[] arg3, int arg4, int arg5){
            int v0 = this.wget_len();
            if(arg5 > v0) {
                arg5 = v0;
            }

            if(arg5 > 0) {
                System.arraycopy(this.a, this.b, arg3, arg4, arg5);
                this.wget_start_add(arg5);
            }

            return arg5;
        }

        public void wget_start_add(int arg2) {
            this.b += arg2;
        }

        public boolean a() {
            return true;
        }

        public void b()  {
        }

        public void b(byte[] arg3, int arg4, int arg5) {
            throw new UnsupportedOperationException("No writing allowed!");
        }

        public void c(byte[] arg2, int arg3, int arg4) {
            this.a = arg2;
            this.b = arg3;
            this.c = arg3 + arg4;
        }

        public void c() {
        }

        public void e() {
            this.a = null;
        }

        public byte[] wget_return() {
            return this.a;
        }

        public int wget_start() {
            return this.b;
        }

        public int wget_len() {
            return this.c - this.b;
        }
    }




         private byte[] i = new byte[1];
        private byte[] j = new byte[2];
        private byte[] k = new byte[4];
        private byte[] l = new byte[8];
        private byte[] m = new byte[1];
        private byte[] n = new byte[2];
        private byte[] p = new byte[8];

    private byte[] o = new byte[4];
    protected boolean f;
    protected int e;
    dt g=new dt(Encode.hexStringToBytes("080001000000010B000200000007737563636565640C00030D00010B0C0000000A000000066A69747465720B000100000001300A0002000001609BE147EC0B00030000002839633235386461623836646636356264376630306461633538366562643461653965653239323763000000000B6170705F76657273696F6E0B000100000005322E322E350A0002000001609BE147EC0B000300000028396332353864616231346364306437353337366535663262343132343264653161353565663635360000000004756D69640B00010000002036353332613634633464613438356335313934633662646163653738376231330A0002000001609BE147EC0B000300000028396332353864616238343832616232636436623162363235356639313335383365633435653763300000000001760B000100000005352D352D350A0002000001609BE147EC0B00030000002839633235386461623730303864393634663235343537623866326331363731646339363237336132000000000A6F735F76657273696F6E0B000100000005342E342E340A0002000001609BE147EC0B00030000002839633235386461626534646231633832316536633765353933363336303566343836663237373335000000000770726574696D650B00010000000D313531343434333732303638340A0002000001609BE147EC0B0003000000283963323538646162373332663766333166383237633039386566623263613064636432636633326400000000076368616E6E656C0B00010000000E79757A6875616E676365736869320A0002000001609BE147EC0B000300000028396332353864616234316533343331326134306239343462353263643830393332363732323166660000000013696E7374616C6C5F6170705F76657273696F6E0B000100000005322E322E350A0002000001609BE147EC0B00030000002839633235386461626164306236396564353164613135313566393464663364303632373738326163000000000F696E7374616C6C5F6368616E6E656C0B00010000000E79757A6875616E676365736869320A0002000001609BE147EC0B000300000028396332353864616234396633613032383535383138653263313439646664343261333363346635300000000010696E7374616C6C5F6461746574696D650B000100000013323031372D31322D31382031353A34373A31370A0002000001609BE147EC0B0003000000283963323538646162333137383438643031663535613837373236613339333361343738623764636200080002000000010B00030000002064633935346534386332336630616130643237346462333764626433303132360000"));




    protected void d(int arg4) {
        if (arg4 < 0) {
            Log.e("wodelog", "报错");
        }

        if (this.f) {
            this.e -= arg4;
            if (this.e < 0) {
                Log.e("wodelog", "报错");
            }
        }
    }


    public int d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                Log.e("wodelog", "报错");
            }
            i3 += a;
        }
        return i3;
    }


    private int a(byte[] arg2, int arg3, int arg4) {
        this.d(arg4);
        return this.d(arg2, arg3, arg4);
    }


    public int w() {
        int v0 = 0;
        int v3 = 4;
        byte[] v1 = this.o;
        if (this.g.wget_len() >= v3) {
            v1 = this.g.wget_return();
            v0 = this.g.wget_start();
            this.g.wget_start_add(v3);
        } else {
            this.a(this.o, 0, v3);
        }

        return v1[v0 + 3] & 255 | ((v1[v0] & 255) << 24 | (v1[v0 + 1] & 255) << 16 | (v1[v0 + 2] & 255) << 8);
    }

    public String b(int arg4) {
        try {
            this.d(arg4);
            byte[] v0_1 = new byte[arg4];
            this.d(v0_1, 0, arg4);
            return new String(v0_1, "UTF-8");
        } catch (Exception v0) {
            Log.e("wodelog", "报错");
        }

        return null;
    }


    public short v()  {
        int i = 0;
        byte[] bArr = this.n;
        if (this.g.wget_len() >= 2) {
            bArr = this.g.wget_return();
            i = this.g.wget_start();
            this.g.wget_start_add(2);
        }
       /* else {
            a(this.n, 0, 2);
        }*/
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }



    public byte u() {
        if (this.g.wget_len() >= 1) {
            byte b = this.g.wget_return()[this.g.wget_start()];
            this.g.wget_start_add(1);
            return b;
        }
        /*a(this.m, 0, 1);
        return this.m[0];*/

        return 0;
    }

    public Encode.db l() {
        byte u = u();
        return new Encode.db("", u, u == (byte) 0 ? (short) 0 : v());
    }


    public String z() {
        String v0_1 = null;
        int v1 = this.w();
        if (this.g.wget_len() >= v1) {
            try {
                v0_1 = new String(this.g.wget_return(), this.g.wget_start(), v1, "UTF-8");
                this.g.wget_start_add(v1);
            } catch (Exception v0) {
            }
        } else {
            v0_1 = this.b(v1);
        }

        return v0_1;
    }



    public long x() {
        int i = 0;
        byte[] bArr = this.p;
        if (this.g.wget_len() >= 8) {
            bArr = this.g.wget_return();
            i = this.g.wget_start();
            this.g.wget_start_add(8);
        }
       /* else {
            a(this.p, 0, 8);
        }*/
        return ((long) (bArr[i + 7] & 255)) | (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8));
    }



    public Encode.dd n()  {
        return new Encode.dd(u(), u(), w());
    }



   public static class bj  {
        private static final Encode.dl e = new Encode.dl("Response");
        private static final Encode.db f = new Encode.db("resp_code", (byte) 8, (short) 1);
        private static final Encode.db g = new Encode.db("msg", (byte) 11, (short) 2);
        private static final Encode.db h = new Encode.db("imprint", (byte) 12, (short) 3);

        public int a;
        public String b;
        public Encode2.ba c;
        private byte k;



        public void a(cz dgVar, bj bjVar)  {
            while (true) {
                Encode.db l = dgVar.l();
                if (l.b == (byte) 0) {
                    return;
                }
                switch (l.c) {
                    case (short) 1:
                        bjVar.a = dgVar.w();
                        break;
                    case (short) 2:
                        bjVar.b = dgVar.z();
                        break;
                    case (short) 3:
                        bjVar.c = new Encode2.ba();
                        bjVar.c.a(dgVar,bjVar.c);
                        break;
                }
            }
        }


    }





}