package com.example.sharedpreftest;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class Global extends Application {
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }


    public static Context getContext() {
        return context;
    }

    public static void toast(String s) {
        Toast.makeText(Global.getContext(), s, Toast.LENGTH_SHORT).show();
    }
}
