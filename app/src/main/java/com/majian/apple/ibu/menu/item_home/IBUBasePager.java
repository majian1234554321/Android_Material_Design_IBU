package com.majian.apple.ibu.menu.item_home;

import android.content.Context;
import android.view.View;


import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BasePager;

import java.util.Map;


/**
 * Created by Apple on 15-9-18.
 */
public class IBUBasePager extends BasePager {
    public IBUBasePager(Context context){
        super(context);
    }

    @Override
    public View initView() {
      View view =  View.inflate(context, R.layout.ibubasepager,null);
        return view;
    }

    @Override
    public Map<String, String> setParams(String flag, int pager, String keyword) {
        return null;
    }

    @Override
    public void processData(String response, String flag) {

    }


}
