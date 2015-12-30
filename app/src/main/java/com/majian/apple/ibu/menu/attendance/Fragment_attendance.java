package com.majian.apple.ibu.menu.attendance;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.majian.apple.ibu.MainActivity;
import com.majian.apple.ibu.R;
import com.majian.apple.ibu.api.Config;
import com.majian.apple.ibu.base.BaseActivity;
import com.majian.apple.ibu.base.BaseFragment;
import com.majian.apple.ibu.utils.CryptoUtil;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Apple on 15-9-17.
 * 考勤管理
 */
@SuppressLint("ValidFragment")
public class Fragment_attendance extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, UltimateRecyclerView.OnLoadMoreListener {

    private UltimateRecyclerView recyclerView;

    public Fragment_attendance(Context context) {
        super(context);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_attendance, null);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("移动考勤");
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivityForResult(new Intent(getActivity(), Attendance_AddressActivity.class), 10086);


            }
        });

        recyclerView = (UltimateRecyclerView) view.findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.enableLoadmore();
        recyclerView.setDefaultOnRefreshListener(this);
        recyclerView.setOnLoadMoreListener(this);

        return view;
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        try {
            //查询考勤
            requestAndSubmitData(Config.QUERY_ATTENDANCE_LIST_URL, "QUERY_ATTENDANCE_LIST_URL","1");

        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
    }

    @Override
    public View initView(LayoutInflater inflater) {
        return null;
    }

    @Override
    public Map<String, String> setParams(String tag,String pager) {
        String map = "";
        map += "username=" + Config.USERNAME;//hw
        map = map + "&" + "data=" + "";
        map = map + "&" + "currentpage=" + pager;

        Map<String,String> getParams = new HashMap<String,String>();

        //getParams.put("data", getADDdata());
        getParams.put("username","18565789697");

        getParams.put("signiture", CryptoUtil.SHA1(map + "&key="
                + Config.KEY));

        return getParams;

    }

    @Override
    public void processData(String response, String tag,String paget) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10086 && resultCode == -1) {
            Toast.makeText(getActivity(), data.getStringExtra("data"), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRefresh() {
        Toast.makeText(context, "下拉刷新", Toast.LENGTH_SHORT).show();

        //recyclerView.setRefreshing(false);
    }

    @Override
    public void loadMore(int itemsCount, int maxLastVisiblePosition) {

    }
}
