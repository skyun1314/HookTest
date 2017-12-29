package com.example.hookcheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.nio.ByteBuffer;
import java.util.Locale;

import u.aly.cz;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* Encode1.c c = new Encode1.c();
        Encode1.bp.b(c);;

        c.timestamp=1514452331;
        c.serial1=2;*/

       cz.bj bj = new cz.bj();
        bj.a(new cz(), bj);


        Encode1.c.entity_str=Encode.hexStringToBytes( Encode2.bn.b());

   /*     c.length=Encode1.c.entity_str.length;
        c.entity= Encode1.c.a(Encode1.c.entity_str);;

        c.guid=Encode1.c. a(c.signature,c.timestamp);
        c.checksum=c.e();
        Encode1.bp.b(c);;*/
    }


}
