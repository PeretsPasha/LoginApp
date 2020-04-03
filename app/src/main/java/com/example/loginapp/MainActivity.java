package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    SharedPreferenceConfig config;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);

        config = new SharedPreferenceConfig(this);

        if(config.readLoginStatus()){
            startActivity(new Intent(this, InnerActivity.class));
            finish();
        }

    }

    public void userLogin(View view) {

        String userName = user.getText().toString();
        String userPassword = password.getText().toString();

        if(userName.equals(getResources().getString(R.string.user_name)) &&
                userPassword.equals(getResources().getString(R.string.user_password))){

            startActivity(new Intent(this, InnerActivity.class));
            config.writeLoginStatus(true);
            finish();

        } else {

            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
            user.setText("");
            password.setText("");
        }

    }
}
