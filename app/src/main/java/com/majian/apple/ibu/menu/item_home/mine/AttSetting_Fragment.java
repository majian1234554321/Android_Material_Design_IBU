package com.majian.apple.ibu.menu.item_home.mine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BaseFragment;

import java.util.Map;

/**
 * Created by Apple on 15/10/9.
 */
@SuppressLint("ValidFragment")
public class AttSetting_Fragment extends BaseFragment {
    public AttSetting_Fragment(Context context) {
        super(context);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View view =  View.inflate(context, R.layout.attsetting_fragment,null);

        return view;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }
}
