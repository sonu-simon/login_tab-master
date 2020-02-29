package com.codingdemos.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


public class registerScreen extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText password;
    EditText areaCode;
    EditText phoneNo;
    EditText vegetables;
    EditText coconut;
    EditText paddy;
    EditText cat;
    Button regButton;

    private FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.email);
        email.toString();
        password = (EditText) findViewById(R.id.password);
        areaCode = (EditText) findViewById(R.id.areaCode);
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        vegetables = (EditText) findViewById(R.id.vegetables);
        coconut = (EditText) findViewById(R.id.coconut);
        paddy = (EditText) findViewById(R.id.paddy);
        cat = (EditText) findViewById(R.id.cat);
        regButton = (Button) findViewById(R.id.button);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Upload data to the database
                String user_email = email.getText().toString().trim();
                String user_password = password.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //sendEmailVerification();
                            sendUserData();
                            firebaseAuth.signOut();
                            Toast.makeText(registerScreen.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();
                            finish();

                            startActivity(new Intent(registerScreen.this, farm_main.class));
                        } else {
                            Toast.makeText(registerScreen.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }


            private void sendUserData() {
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());

                String sname = name.getText().toString();
                String semail = email.getText().toString();
                String spassword = password.getText().toString();
                String sareacode = areaCode.getText().toString();
                String sphoneNo = phoneNo.getText().toString();
                String spaddy = paddy.getText().toString();
                String scoconut = coconut.getText().toString();
                String svegetables = vegetables.getText().toString();
                String scat = cat.getText().toString();

              //  String mn={"name1","name2"};
                userProfile userProfile = new userProfile(sname, semail, spassword, sareacode, sphoneNo, spaddy, scoconut, svegetables, scat);
                myRef.setValue(userProfile);
            }

        });
    }
}
