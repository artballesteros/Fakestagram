package com.example.fakestagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TZoAhieoOZ3a07sg1ddjVicAvwnT9ATwDveNKCZS")
                .clientKey("yLkESLigeSn2fLjEnvZobPU9dBWMjGJSB9E009Z0")
                .server("https://shamstigram.b4a.io")
                .build()
        );
    }
}
