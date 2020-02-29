package com.codingdemos.tablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class yojanas extends AppCompatActivity {

    ImageButton imgscheme1;
    ImageButton imgscheme2;
    ImageButton imgscheme3;
    ImageButton imgscheme4;
    ImageButton imgscheme5;
    ImageButton imgscheme6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yojanas);

        imgscheme1 =  findViewById(R.id.scheme1);
        imgscheme2 =  findViewById(R.id.scheme2);
        imgscheme3 =  findViewById(R.id.scheme3);
        imgscheme4 =  findViewById(R.id.scheme4);
        imgscheme5 =  findViewById(R.id.scheme5);
        imgscheme6 =  findViewById(R.id.scheme6);



        imgscheme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme1.class);
                startActivity(intent);
            }
        });

        imgscheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme2.class);
                startActivity(intent);
            }
        });

        imgscheme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme3.class);
                startActivity(intent);
            }
        });

        imgscheme4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme1.class);
                startActivity(intent);
            }
        });

        imgscheme5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme1.class);
                startActivity(intent);
            }
        });

        imgscheme6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yojanas.this, scheme1.class);
                startActivity(intent);
            }
        });

    }
}
