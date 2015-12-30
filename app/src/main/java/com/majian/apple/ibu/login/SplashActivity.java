package com.majian.apple.ibu.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.majian.apple.ibu.MainActivity;
import com.majian.apple.ibu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;



/**
 * Created by Apple on 15-9-18.
 */
@EActivity(R.layout.splashactivity)
public class SplashActivity extends AppCompatActivity {
    @AfterViews
    void updateUi(){

        startActivity(new Intent(this, LoginActivity_.class));
        finish();
    }

}
