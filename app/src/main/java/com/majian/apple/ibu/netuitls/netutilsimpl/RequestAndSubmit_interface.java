package com.majian.apple.ibu.netuitls.netutilsimpl;

import com.android.volley.AuthFailureError;

import java.util.Map;

/**
 * Created by Apple on 15-9-22.
 */
public interface RequestAndSubmit_interface {
    public abstract Map<String, String> setParams(String flag);

    public abstract void processData(String response, String flag);
}
