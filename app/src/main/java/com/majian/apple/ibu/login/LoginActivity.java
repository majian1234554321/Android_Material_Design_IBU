package com.majian.apple.ibu.login;




import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;

import com.majian.apple.ibu.MainActivity;
import com.majian.apple.ibu.R;
import com.majian.apple.ibu.api.Config;
import com.majian.apple.ibu.base.BaseActivity;
import com.majian.apple.ibu.model.LoginModel;
import com.majian.apple.ibu.model.LoginResponseModel;
import com.majian.apple.ibu.utils.ActivityStartUtils;
import com.majian.apple.ibu.utils.CryptoUtil;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners;
import com.umeng.socialize.exception.SocializeException;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Apple on 15-9-21.
 */
@EActivity(R.layout.loginactivity)
public class LoginActivity extends BaseActivity  {
    @ViewById(R.id.et_username)
    EditText et_username;

    @ViewById(R.id.et_password)
    EditText et_password;

    @ViewById(R.id.bt_login)
    Button bt_login;

    @ViewById(R.id.tv_findpassword)
    TextView tv_findpassword;

    @ViewById(R.id.iv_qq)
    ImageView iv_qq;

    @ViewById(R.id.iv_wx)
    ImageView iv_wx;

    @ViewById(R.id.tv_regist)
    TextView tv_regist;


    private String encodeUn;
    private String encodePw;
    private SharedPreferences sharedPreferences;

    private UMSocialService mController = UMServiceFactory
            .getUMSocialService("com.majian.apple.ibu.login");



    @AfterViews
    void updateUi() {


       // addQZoneQQPlatform();
        Toast.makeText(LoginActivity.this, "1", Toast.LENGTH_SHORT).show();
        sharedPreferences = getSharedPreferences("saveData", 0);
        String sp_username = sharedPreferences.getString("username", "");
        String sp_password = sharedPreferences.getString("password", "");
        if (!TextUtils.isEmpty(sp_password) && !TextUtils.isEmpty(sp_username)) {
            Config.USERNAME = sp_username;
            Config.PASSWORD = sp_password;
            login();
        } else {
            login();
        }


    }

    @Click({R.id.bt_login, R.id.tv_findpassword, R.id.tv_regist,R.id.iv_qq,R.id.iv_wx})
    void onClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                Config.USERNAME = et_username.getText().toString();
                Config.PASSWORD = et_password.getText().toString();
                login();
                break;
            case R.id.tv_findpassword:

                break;
            case R.id.tv_regist:
                Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_qq:
                Toast.makeText(LoginActivity.this, "qq", Toast.LENGTH_SHORT).show();

                login(SHARE_MEDIA.QQ);

                break;
            case R.id.iv_wx:
                //微信登录
                //测试时，需要打包签名；sample测试时，用项目里面的demokey.keystore
                //打包签名apk,然后才能产生微信的登录
                Toast.makeText(LoginActivity.this, "wx", Toast.LENGTH_SHORT).show();


                break;
        }
    }

    private void login() {


        if (!TextUtils.isEmpty(Config.USERNAME) || !TextUtils.isEmpty(Config.PASSWORD)) {
            encodeUn = CryptoUtil.AESencode(Config.USERNAME, Config.KEY);
            encodePw = CryptoUtil.AESencode(Config.PASSWORD, Config.KEY);
            try {
                requestAndSubmitData(Config.LOGIN_URL, "LOGIN");
            } catch (AuthFailureError authFailureError) {
                authFailureError.printStackTrace();
            }

        } else {
//

        }

    }




    @Override
    public Map<String, String> setParams(String flag) {
        LoginModel lm = new LoginModel();
        String map = "";
        map += "authcode=" + "1212";//hw
        map = map + "&" + "password=" + encodePw;
        map = map + "&" + "username=" + encodeUn;

        lm.authcode = "12";
        lm.username = encodeUn;
        lm.password = encodePw;
        Map<String, String> getParams = new HashMap<String, String>();
        getParams.clear();
        getParams.put("password", encodePw);
        getParams.put("username", encodeUn);
        getParams.put("authcode", "1212");
        getParams.put("data", gson.toJson(lm));

        getParams.put("signiture", CryptoUtil.SHA1(map + "&key="
                + Config.KEY));
        return getParams;
    }

    @Override
    public void processData(String response, String flag) {
        Log.i("TAG", response);
        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
        LoginResponseModel loginResponseModel = gson.fromJson(response, LoginResponseModel.class);
        Config.SESSIONID = loginResponseModel.sessionId;

        sharedPreferences.edit().putString("username",Config.USERNAME).commit();
        sharedPreferences.edit().putString("password",Config.PASSWORD).commit();
        ActivityStartUtils.jump(LoginActivity.this, MainActivity.class);
        finish();
    }






    /**
     * 授权。如果授权成功，则获取用户信息</br>
     */
    private void login(final SHARE_MEDIA platform) {
        mController.doOauthVerify(LoginActivity.this, platform, new SocializeListeners.UMAuthListener() {

            @Override
            public void onStart(SHARE_MEDIA platform) {
                Toast.makeText(LoginActivity.this, "start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SocializeException e, SHARE_MEDIA platform) {
            }

            @Override
            public void onComplete(Bundle value, SHARE_MEDIA platform) {
                Toast.makeText(LoginActivity.this, "onComplete", Toast.LENGTH_SHORT).show();
                String uid = value.getString("uid");
                if (!TextUtils.isEmpty(uid)) {
                    getUserInfo(platform);
                } else {
                    Toast.makeText(LoginActivity.this, "授权失败...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancel(SHARE_MEDIA platform) {
            }
        });
    }



    private void addQZoneQQPlatform() {
        String appId = "100424468";
        String appKey = "c7394704798a158208a74ab60104f0ba";
        // 添加QQ支持, 并且设置QQ分享内容的target url
        UMQQSsoHandler qqSsoHandler = new UMQQSsoHandler(LoginActivity.this,
                appId, appKey);
        qqSsoHandler.setTargetUrl("http://www.umeng.com");
        qqSsoHandler.addToSocialSDK();

        // 添加QZone平台
        QZoneSsoHandler qZoneSsoHandler = new QZoneSsoHandler(LoginActivity.this, appId, appKey);
        qZoneSsoHandler.addToSocialSDK();
    }

    /**
     * 获取授权平台的用户信息</br>
     */
    private void getUserInfo(SHARE_MEDIA platform) {
        mController.getPlatformInfo(LoginActivity.this, platform, new SocializeListeners.UMDataListener() {

            @Override
            public void onStart() {

            }

            @Override
            public void onComplete(int status, Map<String, Object> info) {
                // String showText = "";
                // if (status == StatusCode.ST_CODE_SUCCESSED) {
                // showText = "用户名：" + info.get("screen_name").toString();
                // Log.d("#########", "##########" + info.toString());
                // } else {
                // showText = "获取用户信息失败";
                // }
                if (info != null) {
                    Toast.makeText(LoginActivity.this, info.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
