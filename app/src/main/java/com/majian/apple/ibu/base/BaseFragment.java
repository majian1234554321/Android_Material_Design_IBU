package com.majian.apple.ibu.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.majian.apple.ibu.api.Config;
import com.majian.apple.ibu.netuitls.netutilsimpl.RequestAndSubmitData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Apple on 15-9-21.
 */
public abstract class BaseFragment extends Fragment {

    public Context context;
    public RequestQueue mQueue;

    public BaseFragment(Context context){
        this.context = context;
        mQueue =RequestAndSubmitData.getmQueue(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return initView(inflater);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    protected abstract void initData(Bundle savedInstanceState);

    public abstract View initView(LayoutInflater inflater);

    public void requestAndSubmitData(String url, final String tag,final String pager) throws AuthFailureError {
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

    /**
     *
     * @param tag 处理不同请求的标志
     * @param pager 处理分页请求的标志
     * @return
     */
    public abstract Map<String, String> setParams(String tag,String pager);

    public abstract void processData(String response, String tag,String pager);

}
