package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InnerActivity extends AppCompatActivity {

    SharedPreferenceConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner);

        config = new SharedPreferenceConfig(getApplicationContext());
    }

    public void userLogout(View view) {

        config.writeLoginStatus(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();


    }
}
