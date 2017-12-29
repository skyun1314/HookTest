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
    dt g=new dt(Encode.hexStringToBytes("080001000000010b000200000007737563636565640c00030d00010b0c0000000a000000066a69747465720b000100000001300a0002000001609cfaefa40b00030000002864343864393661633061323964616634643131626433313662313365656634373962656639653562000000000b6170705f76657273696f6e0b000100000005322e322e350a0002000001609cfaefa40b000300000028643438643936616363343163353730623464353037333832336236646663323037643839383065340000000004756d69640b00010000002036353332613634633464613438356335313934633662646163653738376231330a0002000001609cfaefa40b000300000028643438643936616364356566393066303037323730663166376463623465346439393636616461630000000001760b000100000005352d352d350a0002000001609cfaefa40b00030000002864343864393661636262336164643138313534333665633437386266636363343664346331346338000000000a6f735f76657273696f6e0b000100000005342e342e340a0002000001609cfaefa40b00030000002864343864393661633430396130363737656433303363383064626431663763376566613566386235000000000770726574696d650b00010000000d313531343436323137393233360a0002000001609cfaefa40b0003000000286434386439366163626266346237346562363536353533323138663063633138356530663634663900000000076368616e6e656c0b00010000000e79757a6875616e676365736869320a0002000001609cfaefa40b000300000028643438643936616366653265616365333562633539653662646663386265386265376562666665350000000013696e7374616c6c5f6170705f76657273696f6e0b000100000005322e322e350a0002000001609cfaefa40b00030000002864343864393661633066353732396233373538656636626362656166393836643266386630373632000000000f696e7374616c6c5f6368616e6e656c0b00010000000e79757a6875616e676365736869320a0002000001609cfaefa40b000300000028643438643936616365353562646431336365336436633364623730613634316336653135306231610000000010696e7374616c6c5f6461746574696d650b000100000013323031372d31322d31382031353a34373a31370a0002000001609cfaefa40b0003000000286434386439366163323363363739366365326662366238633832623366646265646464353562623600080002000000010b00030000002036633238663134663565613335653930346236356331383835373064376538610000"));




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
        public static Encode2.ba c;
        private byte k;



        public void a(cz dgVar, bj bjVar)  {

            Encode2.bn.a.a();;
            Encode2.bn.e=null;
            Encode2.bn.g.add(new Encode2.bl(1514462178883L,1514462230285L,43979,4107));

            while (true) {
                Encode.db l = dgVar.l();
                if (l.b == (byte) 0) {
                    break;
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
            Encode2.bn.h=c;
            Encode2.bn.i.b=null;
        }


    }





}