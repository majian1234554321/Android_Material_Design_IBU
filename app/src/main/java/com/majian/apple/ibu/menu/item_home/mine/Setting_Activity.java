package com.majian.apple.ibu.menu.item_home.mine;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.majian.apple.ibu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * 流程：
 */

@EActivity(R.layout.activity_setting)
public class Setting_Activity extends AppCompatActivity {



    @AfterViews
    void updateView() {
        Content_Fragment content_fragment = new Content_Fragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.rl, content_fragment).commit();

    }


    public void replaces(Fragment fragment ,String title,Fragment fragmenthide){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.hide(fragmenthide);
        transaction.add(R.id.rl, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
