package com.majian.apple.ibu.menu.salesopportunities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.majian.apple.ibu.base.BaseFragment;

import java.util.Map;

/**
 * Created by Apple on 15-9-29.
 * 销售机会
 */
@SuppressLint("ValidFragment")
public class SalesOpportunities extends BaseFragment {
    public SalesOpportunities(Context context) {
        super(context);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        return null;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }
}
