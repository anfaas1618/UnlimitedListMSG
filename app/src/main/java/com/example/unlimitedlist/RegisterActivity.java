package com.example.unlimitedlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
         FirebaseAuth myAuth;

         EditText Email;
         EditText  password;
         Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myAuth=FirebaseAuth.getInstance();
        Email =findViewById(R.id.editTextEmail);
        password =findViewById(R.id.editTextPassword);
        btn=findViewById(R.id.buttonSignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAuth.createUserWithEmailAndPassword(
                        Email.getText().toString(),
                        password.getText().toString()
                ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {  FirebaseUser user = myAuth.getCurrentUser();
                         //   updateUI(user);
                            Toast.makeText(RegisterActivity.this, "done", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



    }



































    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}
