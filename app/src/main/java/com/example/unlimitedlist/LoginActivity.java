package com.example.unlimitedlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionProvider;
import android.view.View;
import android.widget.AlphabetIndexer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.Utilities;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    EditText editTextUsername;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    String GotUsername;
    DatabaseReference myRef=database.getReference("gf");
    DataSnapshot usernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginBtn=findViewById(R.id.loginBtn);
        editTextUsername=findViewById(R.id.username);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    GotUsername=editTextUsername.getText().toString();
                    myRef.child(GotUsername);
                Intent change= new Intent(LoginActivity.this,MainActivity.class);
                startActivity(change);
            }
        });
       myRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//               for (DataSnapshot usernames:dataSnapshot.getChildren())
//               {if (usernames.getKey()==GotUsername)
//                   usernames.getRef().child("");
//               }
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });
    }
}
