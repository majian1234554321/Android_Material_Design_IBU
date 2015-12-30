package com.majian.apple.ibu.netuitls.netutilsimpl;

import android.content.Context;

import java.util.Map;

/**
 * Created by Apple on 15/10/9.
 */
public abstract class FinalData extends RequestAndSubmitData {
    public FinalData(Context context, String url, String tag, String pager) {
        super(context, url, tag, pager);
    }

    @Override
    public  Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public  void processData(String response, String tag, String pager) {

        hh(response);
    }

    protected abstract void hh(String response);
}
