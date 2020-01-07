package com.example.unlimitedlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
         FirebaseAuth myAuth;
         EditText Email;
         EditText  password;
         int counterVerify;
         Button btn,verify;
         ProgressDialog progressDialog;
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myref=database.getReference();
        FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LoginActivity loginActivity=new LoginActivity();
        counterVerify=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        verify=findViewById(R.id.verify);
        myAuth=FirebaseAuth.getInstance();
        Email =findViewById(R.id.editTextEmail);
        password =findViewById(R.id.editTextPassword);
        btn=findViewById(R.id.buttonSignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String email=Email.getText().toString() +LoginActivity.vitString;
                 Log.i("check",email);
                myAuth.createUserWithEmailAndPassword(
                        email,
                        password.getText().toString()
                ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {  FirebaseUser user = myAuth.getCurrentUser();
                            user.reload();
                        String name=user.getEmail().trim();
                            int posA = name.indexOf("@");
                            String real= name.substring(0, posA);
                        User userlocal=new User(real,user.getEmail(),user.getUid());
                       myref.child(userlocal.getUid()).setValue(userlocal);
                            myAuth.getCurrentUser().sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                              firebaseUser=     myAuth.getCurrentUser();
                                                firebaseUser.reload();

                                                Log.d("check", "Email sent.");
                                            }
                                        }
                                    });


                         //   updateUI(user);
                            Toast.makeText(RegisterActivity.this, "done", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           counterVerify++;

Log.i("check ","verify clicked"+myAuth.getCurrentUser().getEmail());
firebaseUser.reload();
reloaded();

                if (firebaseUser.isEmailVerified())
                {
                    Intent  change = new Intent(RegisterActivity.this,DecideActivity.class);

                    Toast.makeText(RegisterActivity.this,"wohoo",Toast.LENGTH_LONG).show();
                    Log.i("check","verified");
                    startActivity(change);

                }
                if (counterVerify>2)
                verify.setText("dude dont fool us try again ");
                else
                    verify.setText("common dude press me again");

            }
        });



    }
    public  void  reloaded()
    {
        firebaseUser.reload();

    }
//    public  void  verifyit(View view)
//    {
////        FirebaseAuth auth = FirebaseAuth.getInstance();
////        FirebaseUser user = auth.getCurrentUser();
////
////        myAuth.getCurrentUser().sendEmailVerification()
////                .addOnCompleteListener(new OnCompleteListener<Void>() {
////                    @Override
////                    public void onComplete(@NonNull Task<Void> task) {
////                        if (task.isSuccessful()) {
////
////                            Log.d("check", "Email sent.");
////                        }
////                    }
////                });
//        Log.i("check","verified");
//        if (myAuth.getCurrentUser().isEmailVerified())
//        {
//            Toast.makeText(this,"wohoo",Toast.LENGTH_LONG).show();
//            Log.i("check","verified");
//
//        }
//    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
