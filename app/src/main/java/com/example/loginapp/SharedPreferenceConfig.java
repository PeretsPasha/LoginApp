package com.example.loginapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceConfig {

        SharedPreferences preferences;
        Context context;


    public SharedPreferenceConfig(Context context) {
        this.context = context;

        preferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }


    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("status", status);
        editor.commit();
    }
    public boolean readLoginStatus(){
        boolean status = false;
        status = preferences.getBoolean("status", false);
        return status;
    }
}
