package com.example.fakestagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TZoAhieoOZ3a07sg1ddjVicAvwnT9ATwDveNKCZS")
                .clientKey("yLkESLigeSn2fLjEnvZobPU9dBWMjGJSB9E009Z0")
                .server("https://fakestragram.b4a.io")
                .build()
        );
    }
}
