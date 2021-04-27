package com.example.clareai;

import android.content.Context;
import android.graphics.Color;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ClareUtils {

//    static String sample_appID = "{appID of your clareWeb}";
//    static String sample_appHost = "{appHost of your clareWeb}";

    static String sample_appID = "59e88a5d6e45840048ea9844";
    static String sample_appHost = "https://api-staging.clare.ai";


    static public void initCareSDK(Settings settings){
        Clare.init(MyApplication.getInstance(), settings, getCallback());
    }

    static  public void clareChatBotInit(Context context){
        final Settings setting = new Settings(sample_appID);
        setting.host= sample_appHost;
        setting.titles = new HashMap<>();
        //setting.titles.put("zh_CN","Clare 聊天机器人");
        setting.titles.put("zh_HK","Clare 聊天機械人");
        setting.titles.put("en_US","Clare Assistant");
        setting.disclaimers = new HashMap<>();

        setting.disclaimers.put("zh_HK",new ArrayList<>(Arrays.asList(context.getApplicationContext().getString(R.string.clare_chatbot_disclaimer_zh))));
        setting.disclaimers.put("en_US",new ArrayList<>(Arrays.asList(context.getApplicationContext().getString(R.string.clare_chatbot_disclaimer_en))));
        setting.setLanguages(new ArrayList<>(Arrays.asList("en_US","zh_HK")));

        setting.themeColor = Color.parseColor("#36b449");

        setting.isMicrophoneAllowed = false;
        setting.isReplyButtonInOneRow = false;

        setting.loadHistory = false;
        setting.properties = new HashMap<>();
        setting.properties.put("language","en_US");
        setting.languageDetection = true;
        setting.allowUploadFile = true;
        setting.sendGreetingAgain = true;
        setting.autoStart = false;

        initCareSDK(setting);

        StyleSettings styleSettings = new StyleSettings();
        styleSettings.chatBgColor = Color.WHITE;
        styleSettings.linkColor = Color.BLUE;
        styleSettings.waterMarkColor = Color.RED;

        styleSettings.quickReplyButtonBgColor = Color.WHITE;
        styleSettings.quickReplyButtonFontColor = Color.parseColor("#36B449");
        styleSettings.quickReplyButtonBorderColor = Color.parseColor("#36B449");

        styleSettings.bubbleBgColor =  Color.parseColor("#F4F4F4");
        styleSettings.bubbleBorder = false;
        styleSettings.bubbleFontColor = Color.BLACK;

        styleSettings.headerBarBgColor = Color.parseColor("#36B449");

        styleSettings.userBubbleBgColor = Color.parseColor("#36B449");
        styleSettings.userBubbleBorder = false;
        styleSettings.userBubbleFontColor = Color.WHITE;

        styleSettings.postbackBgColor = Color.parseColor("#36B449");
        styleSettings.postbackBorder = false;
        styleSettings.postbackFontColor = Color.WHITE;

        styleSettings.searchResultFontColor = Color.BLACK;

        Clare.setStyleSettings(styleSettings);

        LogoSetting logoSetting = new LogoSetting();
        logoSetting.defaultLogo = context.getApplicationContext().getResources().getDrawable(R.drawable.avata_api);
        logoSetting.apiLogo = context.getApplicationContext().getResources().getDrawable(R.drawable.avata_api);
        logoSetting.salesforceLogo = context.getApplicationContext().getResources().getDrawable(R.drawable.salesforce);
        logoSetting.livechatLogo = context.getApplicationContext().getResources().getDrawable(R.drawable.liveagent);
        Clare.setLogo(logoSetting);
    }

    static public ClareCallBack getCallback() {
        return  new ClareCallBack() {
            @Override
            public void onConnected(boolean ignored, boolean success, @Nullable Exception exception) {
                if(success){
                    if(Clare.getSettings().autoStart == true) {
                        Log.i("Clare", "reinit");
                        HashMap<String, String> userNewProperties = new HashMap<>();
                        userNewProperties.put("us", "er1");
                        userNewProperties.put("ps", "wd2");
                        Clare.updateUser(userNewProperties, new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {

                            }
                        });
                    }
                }else {
                    Log.i("fail","init fail");
                }
            }

            @Override
            public void onChotBotClosed() {
                Log.d("Destroy=","Close Chat Page");
            }
        };
    }

}

