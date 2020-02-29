package com.codingdemos.tablayout;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button login;
    private int counter=5;
    private TextView wrAtmt;
    private FirebaseAuth firebaseAuth;

    public login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.edUID);
        pass = (EditText)findViewById(R.id.edUPASS);
        login =(Button)findViewById(R.id.USUB);
        wrAtmt=(TextView)findViewById(R.id.WrAttempt);


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

//        if(user!=null){
//            finish();
//            startActivity(new Intent(MainActivity.this,Main2Activity.class));
//        }



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString().trim(),pass.getText().toString().trim());
            }
        });

    }


    private void validate(String userName,String userPass)
    {
        firebaseAuth.signInWithEmailAndPassword(userName,userPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete( Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(login.this,"Login succesfull",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(login.this,MainActivity.class));
                }
                else{
                    Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
                    counter--;
                    wrAtmt.setText("Number of attempts remaining :" + String.valueOf(counter));
                    if(counter==0)
                    {
                        login.setEnabled(false);
                    }
                }

            }
        });
   }


//    private void validate(String userName,String userPass)
//    {
//        if(userName.equals("admin@admin.com") && userPass.equals("adminadmin")){
//            Toast.makeText(login.this,"Login succesfull",Toast.LENGTH_SHORT).show();
//
//            startActivity(new Intent(login.this,MainActivity.class));
//        }
//        else{
//            Toast.makeText(login.this,"Login Failed",Toast.LENGTH_SHORT).show();
//            counter--;
//            wrAtmt.setText("Number of attempts remaining :" + String.valueOf(counter));
//            if(counter==0)
//            {
//                login.setEnabled(false);
//            }
//        }
//
//
//    }

}