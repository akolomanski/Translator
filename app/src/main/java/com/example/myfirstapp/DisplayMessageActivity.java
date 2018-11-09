package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.ClipboardManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(CoKurwa(message));
    }

    public String CoKurwa(String tekst){
        if(tekst.startsWith("co kurwa co")||tekst.startsWith("co kurwa kurwa")||tekst.startsWith("co co")
                ||tekst.startsWith("kurwa co co")||tekst.startsWith("kurwa co kurwa")||tekst.startsWith("kurwa kurwa")){

            String[] kod;
            kod = tekst.split(" ");
            ArrayList code = new ArrayList();
            StringBuilder co = new StringBuilder();


            for(int i=0;i<kod.length;i++){
                if(kod[i].compareTo("kurwa")==0){
                    co.append("0");
                }if(kod[i].compareTo("co")==0){
                    co.append("1");
                }
            }
            String str = "";
            String[] codestr = co.toString().split("\\s");

            StringBuilder sb = new StringBuilder();

            for(int i=0;i<codestr[0].length();i+=8) {
                StringBuilder co2 = new StringBuilder();
                for(int j=0;j<8;j++){
                    Character a = codestr[0].charAt(i+j);
                    co2.append(a);
                }
                String[] codestr2 = co2.toString().split("\\s");
                for (String string : codestr2) {
                    Character c = (char) Integer.parseInt(string, 2);
                    str += c.toString();
                }
            }

            return str;

        }


        byte[] bytes = tekst.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }

        }

        StringBuilder kurwa = new StringBuilder();
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1')
                kurwa.append("co ");
            if(binary.charAt(i)=='0')
                kurwa.append("kurwa ");
        }

        return kurwa.toString();
    }









    }
