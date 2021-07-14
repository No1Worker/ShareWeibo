package com.yy.shareweib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

public class LoginActivity extends AppCompatActivity implements WbAuthListener{

    Button btnLogin;

    /**
     * 注意：SsoHandler 仅当 SDK 支持 SSO 时有效
     */
    private SsoHandler mSsoHandler;

    /**
     * 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
     */
    private Oauth2AccessToken mAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        mSsoHandler = new SsoHandler(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSsoHandler.authorize(LoginActivity.this);
            }
        });
    }

    @Override
    public void onSuccess(Oauth2AccessToken token) {
        mAccessToken = token;
    }

    @Override
    public void cancel() {
        Toast.makeText(LoginActivity.this, "取消登录", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
        Toast.makeText(LoginActivity.this, wbConnectErrorMessage.getErrorMessage(), Toast.LENGTH_LONG).show();
    }
}
