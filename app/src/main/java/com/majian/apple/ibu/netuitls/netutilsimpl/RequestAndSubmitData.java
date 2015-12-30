package com.majian.apple.ibu.netuitls.netutilsimpl;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.majian.apple.ibu.api.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Apple on 15-9-22.
 */
public abstract class RequestAndSubmitData   {

    private static RequestQueue mQueue=null;

    public static RequestQueue getmQueue(Context ct) {
        if (mQueue == null) {
            mQueue = Volley.newRequestQueue(ct);

        }
        return mQueue;
    }

    public Context context; public  String url; public  String tag;public  String pager;

    public RequestAndSubmitData( Context context, final String url, final String tag,final String pager){
        this.context =context;
        this.url =url;
        this.tag =tag;
        this.pager =pager;
    }

    public  void requestAndSubmitData() throws AuthFailureError {
        StringRequest stringrequest = new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                processData(response, tag,pager);
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
                return setParams(tag,pager);
            }
        };
        mQueue.add(stringrequest);
    }

    protected abstract Map<String,String> setParams(String tag, String pager);

    protected abstract void processData(String response, String tag, String pager);


}
