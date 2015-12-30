package com.majian.apple.ibu.menu.commodityinformation;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.majian.apple.ibu.base.BasePager;

import java.util.Map;

/**
 * Created by Apple on 15-9-29.
 */
public class CompanyPager extends BasePager {
    public CompanyPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("CompanyPager");
        return textView;
    }

    @Override
    public Map<String, String> setParams(String flag, int pager, String keyword) {
        return null;
    }

    @Override
    public void processData(String response, String flag) {

    }


}
