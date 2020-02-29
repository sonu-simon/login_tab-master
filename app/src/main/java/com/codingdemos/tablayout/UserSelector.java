package com.codingdemos.tablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserSelector extends AppCompatActivity {


    private Button select_farm;
    private Button select_officer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selector);

        select_farm =(Button)findViewById(R.id.farmer);
        select_officer =(Button)findViewById(R.id.officer);

        select_farm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSelector.this, farm_log.class);
                startActivity(intent);
            }
        });


        select_officer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSelector.this, login.class);
                startActivity(intent);
            }
        });



    }
}
