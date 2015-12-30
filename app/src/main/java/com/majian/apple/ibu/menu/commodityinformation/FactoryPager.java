package com.majian.apple.ibu.menu.commodityinformation;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.majian.apple.ibu.R;
import com.majian.apple.ibu.api.Config;
import com.majian.apple.ibu.base.BasePager;
import com.majian.apple.ibu.model.LoginModel;
import com.majian.apple.ibu.utils.CryptoUtil;
import com.marshalchen.ultimaterecyclerview.SwipeableUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Apple on 15-9-29.
 */
public class FactoryPager extends BasePager implements SwipeRefreshLayout.OnRefreshListener, UltimateRecyclerView.OnLoadMoreListener {

    private SwipeableUltimateRecyclerview recylerview;

    public FactoryPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
      View view =   View.inflate(context, R.layout.factorypager, null);
        recylerview = (SwipeableUltimateRecyclerview) view.findViewById(R.id.recylerview);
        try {
            requestAndSubmitData(Config.COMMODITYINFOR_FACTORY,"COMMODITYINFOR_FACTORY",1,"");
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }

//        FactoryPagerAdapter factoryPagerAdapter = new FactoryPagerAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(context);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recylerview.setLayoutManager(llm);
//        recylerview.setAdapter(factoryPagerAdapter);
//        recylerview.enableLoadmore();
//        recylerview.setDefaultOnRefreshListener(this);
//        recylerview.setOnLoadMoreListener(this);
        return view;
    }

    @Override
    public Map<String, String> setParams(String tag,int pager,String keyword) {
        String map = "";
        map += "username=" + Config.USERNAME;
        map += "&data=" + toJson(pager,keyword);


        Map<String, String> getParams = new HashMap<String, String>();
        getParams.clear();
        getParams.put("pager", 1+"");
        getParams.put("keyword", keyword);
        getParams.put("data", toJson(1,keyword));

        getParams.put("signiture", CryptoUtil.SHA1(map + "&key="
                + Config.KEY));
        return getParams;

    }

    @Override
    public void processData(String response, String flag) {
        Toast.makeText(context,response,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void loadMore(int itemsCount, int maxLastVisiblePosition) {

    }

    public class FactoryPagerAdapter extends UltimateViewAdapter<FactoryPagerAdapter.MyViewHolder>{

        @Override
        public MyViewHolder getViewHolder(View view) {
            return null;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent) {
            return null;
        }

        @Override
        public int getAdapterItemCount() {
            return 0;
        }

        @Override
        public long generateHeaderId(int position) {
            return 0;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

        }

        @Override
        public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
            return null;
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }

    public String toJson(int pager,String keyword) {
        StringBuffer sb = new StringBuffer();
        sb.append("{");

        sb.append("\"currentpage\":\"" + pager + "\",");
        sb.append("\"keyWord\":\"" + keyword + "\"");
        sb.append("}");
        return sb.toString();

    }
}
