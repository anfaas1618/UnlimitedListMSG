package com.example.unlimitedlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText cinColor,cinfruit;
    List<Fruits> fruitsList;
    Button send;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
     DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        List<String> names=new ArrayList<>();
        Fruits fruits=new Fruits("blank","blank");
        List<String> colors=new ArrayList<>();
        names.add("apple");
        names.add("pineapple");
        names.add("mango");
        colors.add("red");
        colors.add("plae yellow");
        colors.add("yellow");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cinfruit=findViewById(R.id.fruit);
        cinColor=findViewById(R.id.color);
        send=findViewById(R.id.send);
        listView=findViewById(R.id.list);
        fruitsList=new ArrayList<>();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              add();
            }
        });
    }

    @Override
    protected void onStart() {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                fruitsList.clear();
                for (DataSnapshot snap:dataSnapshot.getChildren())
                {   Log.i("anfaasssss",snap.getKey());
                    Fruits fruits = snap.getValue(Fruits.class);
                        fruitsList.add(fruits);
                        }
                    FruitsAdapter fruitsAdapter=new FruitsAdapter(MainActivity.this,fruitsList);
                    listView.setAdapter(fruitsAdapter);
                    cinfruit.setText("");
                    cinColor.setText("");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }
    void  add()
    {
        String fruitName=cinfruit.getText().toString();
        String fruitColor=cinColor.getText().toString();
        Fruits fruits=new Fruits(fruitName,fruitColor);
        String value = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            value = bundle.getString("sample_name");
        }
        myRef.child(value).setValue(fruits);

    }
    public static void firebaseREf()
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

    }









}
