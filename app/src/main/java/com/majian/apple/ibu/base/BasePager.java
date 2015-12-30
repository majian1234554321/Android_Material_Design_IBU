package com.majian.apple.ibu.base;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.majian.apple.ibu.api.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Apple on 15-9-18.
 */
public abstract class BasePager {
    public Context context;
    private View view;
    public RequestQueue mQueue;
    public Gson gson;

    public BasePager(Context context){
        this.context = context;
        mQueue = Volley.newRequestQueue(context);
        gson = new Gson();
        view = initView();
    }
    public abstract View initView();
    public View getView(){return view;}


    /**
     *
     * @param url 地址
     * @param tag 标志
     * @param pager 分页
     * @param KeyWord 查询关键字
     * @throws AuthFailureError
     */
    public void requestAndSubmitData(String url, final String tag,final int pager,final String KeyWord) throws AuthFailureError {
        StringRequest stringrequest = new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                processData(response, tag);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "解析数据失败", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("imei", "121212121212");
                params.put("version", Config.APKVERSION);
                params.put("SEED", Config.SEED);
                params.put("SessionId", Config.SESSIONID);

                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return setParams(tag,pager,KeyWord);
            }
        };
        mQueue.add(stringrequest);
    }


    public abstract Map<String, String> setParams(String flag,int pager ,String keyword);

    public abstract void processData(String response, String flag);


}
