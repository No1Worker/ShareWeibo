package com.yy.shareweib.application;

import android.app.Application;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.yy.shareweib.constant.Constants;

/**
 * create by yzy on 2021/7/13
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AuthInfo mAuthInfo = new AuthInfo(this, Constants.APP_ID, Constants.REDIRECT_RUI, Constants.SCOPE);
        WbSdk.install(this,mAuthInfo);
    }
}
