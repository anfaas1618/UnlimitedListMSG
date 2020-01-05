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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.utilities.Utilities;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    Intent change;

    EditText editTextUsername;
    FirebaseDatabase database= FirebaseDatabase.getInstance();
   public  String GotUsername,keyCheckglobal;

      DatabaseReference myRef=database.getReference("Users");
      boolean click,check=false;
    DataSnapshot usernames;

    @Override
    protected void onStart() {

        super.onStart();

    }
   
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
                Query queryRef = myRef.orderByKey();
                queryRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        click=false;
                        for (DataSnapshot snap:dataSnapshot.getChildren())
                        {
                            final   String keyCheck = snap.getKey();
                            keyCheckglobal=keyCheck;

                            if (keyCheck.equals(GotUsername))
                            {   keyCheckglobal=keyCheck;
                                click=true;

                            }
                        }
                        if (!click)
                        {
                            myRef.child(GotUsername);
                            Fruits fruits=new Fruits("default","default");
                            myRef.child(GotUsername).setValue(fruits);
                            change= new Intent(LoginActivity.this,MainActivity.class);
                            change.putExtra("sample_name", GotUsername);
                            startActivity(change);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                    if (click)
                    {
                        Toast.makeText(LoginActivity.this, "oops name is taken", Toast.LENGTH_SHORT).show();
                        Log.i("amaan",keyCheckglobal);
                    }



            }
            
        });

    }
}
