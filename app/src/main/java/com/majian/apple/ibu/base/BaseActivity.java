package com.majian.apple.ibu.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.majian.apple.ibu.api.Config;
import com.majian.apple.ibu.netuitls.netutilsimpl.RequestAndSubmit_interface;
import com.majian.apple.ibu.netuitls.netutilsimpl.RequestAndSubmitData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Apple on 15-9-21.
 */
public abstract class BaseActivity extends AppCompatActivity implements RequestAndSubmit_interface {

    public Gson gson;
    public  RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(this);



//        requestQueue = Volley.newRequestQueue(getContext(), new OkHttpStack());

//        requestQueue.start();

        gson = new Gson();

    }

    public void requestAndSubmitData(String url, final String flag) throws AuthFailureError {
        StringRequest stringrequest = new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                processData(response, flag);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(BaseActivity.this, "解析数据失败", Toast.LENGTH_SHORT).show();
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
                return setParams(flag);
            }
        };
        mQueue.add(stringrequest);
    }


    public abstract Map<String, String> setParams(String flag);

    public abstract void processData(String response, String flag);


}
