package com.majian.apple.ibu.menu.item_home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.majian.apple.ibu.MainActivity;
import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BasePager;
import com.majian.apple.ibu.menu.item_home.maillist.IBUMailAddActivity_;
import com.majian.apple.ibu.utils.ActivityStartUtils;

import java.util.Map;

import google.zxing.client.android.CaptureActivity;

/**
 * Created by Apple on 15-9-18.
 */
public class IBUMailListPager extends BasePager implements View.OnClickListener {
    public IBUMailListPager(Context context){
        super(context);
    }

    @Override
    public View initView() {
      View view = View.inflate(context, R.layout.ibumaillistpager,null);
                FloatingActionButton fab = (FloatingActionButton)view. findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityStartUtils.jump(context, IBUMailAddActivity_.class);
            }
        });

        TextView  tv_new = (TextView) view.findViewById(R.id.tv_new);
        TextView  tv_group = (TextView) view.findViewById(R.id.tv_group);

        tv_new.setOnClickListener(this);
        tv_group.setOnClickListener(this);
        return view;
    }

    @Override
    public Map<String, String> setParams(String flag, int pager, String keyword) {
        return null;
    }


    @Override
    public void processData(String response, String flag) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_new:
                ActivityStartUtils.jump(context,IBUMailAddActivity_.class);
                break;
            case R.id.tv_group:
                Intent scanerIntent = new Intent(context,
                        CaptureActivity.class);

                break;
        }
    }




}
