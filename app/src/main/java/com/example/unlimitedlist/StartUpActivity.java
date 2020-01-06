package com.example.unlimitedlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartUpActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
    }
    public void  started(View view)
    {
        if (view.getId()==R.id.card_Register)
        {   Intent RegisterIntent =new Intent(StartUpActivity.this,RegisterActivity.class);
            startActivity(RegisterIntent);
            finish();
        }
        else {
            Intent LoginIntent =new Intent(StartUpActivity.this,LoginActivity.class);
            startActivity(LoginIntent);
            finish();
        }

    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
