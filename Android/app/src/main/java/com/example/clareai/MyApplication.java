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

    }

    static MyApplication getInstance(){
        return  instance;
    }

}
