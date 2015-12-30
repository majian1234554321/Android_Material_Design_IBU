package com.majian.apple.ibu.menu.item_home.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BaseFragment;

import java.util.Map;


/**
 * Created by Apple on 15/10/9.
 */
@SuppressLint("ValidFragment")
public class Content_Fragment extends BaseFragment implements View.OnClickListener {
    public Content_Fragment(Context context) {
        super(context);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view = View.inflate(context, R.layout.content_fragment, null);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("设置");
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setOnClickListener(this);

        return view;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv:
                Toast.makeText(context, "sshssss", Toast.LENGTH_SHORT).show();
                AttSetting_Fragment attSetting_fragment = new AttSetting_Fragment(context);
              Setting_Activity_ setting_activity = (Setting_Activity_)  getActivity();
                setting_activity.replaces(attSetting_fragment, "12",Content_Fragment.this);


                break;
        }
    }
}
