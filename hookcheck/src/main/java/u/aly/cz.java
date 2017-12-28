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





    private byte[] o = new byte[4];
    protected boolean f;
    protected int e;
    dt g=new dt(Encode.hexStringToBytes("080001000000010B000200000007737563636565640C00030D00010B0C0000000A000000066A69747465720B000100000001300A000200000160978FA4680B00030000002831386336653361373764393038663936663033373932313734333361363839636636343964396131000000000B6170705F76657273696F6E0B000100000005322E322E350A000200000160978FA4680B000300000028313863366533613739343831646532366639346331363132353738313033656131336561376465390000000004756D69640B00010000002036353332613634633464613438356335313934633662646163653738376231330A000200000160978FA4680B000300000028313863366533613765626538633031323839613935643964363638316264333537353631653438620000000001760B000100000005352D352D350A000200000160978FA4680B00030000002831386336653361376363333835383235616464383131623061356130323535343463663463383239000000000A6F735F76657273696F6E0B000100000005342E342E340A000200000160978FA4680B00030000002831386336653361376539636337643430653031663063303339396434393233656537313265356330000000000770726574696D650B00010000000D313531343337313236313534340A000200000160978FA4680B0003000000283138633665336137613131663936353861346237366338643533306164653336383862623531643500000000076368616E6E656C0B00010000000E79757A6875616E676365736869320A000200000160978FA4680B000300000028313863366533613761343435623264623961633436666639633138366461613366343062386533300000000013696E7374616C6C5F6170705F76657273696F6E0B000100000005322E322E350A000200000160978FA4680B00030000002831386336653361373861656165373561386339373337666133623837616239376562363137313237000000000F696E7374616C6C5F6368616E6E656C0B00010000000E79757A6875616E676365736869320A000200000160978FA4680B000300000028313863366533613737636563636637316436323539626339353234656663633330383434376338390000000010696E7374616C6C5F6461746574696D650B000100000013323031372D31322D31382031353A34373A31370A000200000160978FA4680B0003000000283138633665336137616661306663383434626630323031616630623638646337336636656639616400080002000000010B00030000002038656466643262383135653431383464366361663533303465333137353135360000"));




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



    static class bj  {
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
                        bjVar.c.a(dgVar);
                        break;
                }
            }
        }


    }





}