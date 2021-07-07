package com.example.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vQKiMqJUWobOMwzcDgr4K4JFJtjGe7xMrSlV1jyz")
                .clientKey("DcmpUzxnIoxVLqPliJW8YVyQqVdngN1ujFG4JgMk")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
