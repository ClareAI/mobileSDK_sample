package com.example.clareai;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import ai.clare.clarelib.Clare;
import ai.clare.clarelib.ClareCallBack;
import ai.clare.clarelib.LogoSetting;
import ai.clare.clarelib.Settings;
import ai.clare.clarelib.StyleSettings;
import ai.clare.clarelib.ui.ClareBubble;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MyApplication extends Application {
    static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        ClareUtils.clareChatBotInit(getApplicationContext());
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.i("app","onActivityStarted");
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.i("app","onActivityStarted");
            }

            @Override
            public void onActivityResumed(Activity activity) {
                //Log.i("app","onActivityResumed");
//                ClareBubble.getInstance(MyApplication.this).show(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
                //ClareBubble.getInstance(App.this).remove();
                Log.i("app","onActivityPaused");
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.i("app","onActivityStopped");
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.i("app","onActivitySaveInstanceState");
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.i("app","onActivityDestroyed");
            }
        });
    }

    static MyApplication getInstance(){
        return  instance;
    }

}
