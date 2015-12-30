package com.majian.apple.ibu.menu.commodityinformation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BaseFragment;
import com.majian.apple.ibu.base.BasePager;
import com.majian.apple.ibu.base.BasePagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Apple on 15-9-29.
 * 商品信息
 */
@SuppressLint("ValidFragment")
public class Fragment_Commodity extends BaseFragment {

    private ViewPager viewpager;

    public List<BasePager> list = new ArrayList<>();

    public Fragment_Commodity(Context context) {
        super(context);
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
      View view  =   View.inflate(context, R.layout.fragment_commodity,null);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("商品信息");
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        TextView tv_left = (TextView) view.findViewById(R.id.tv_left);
        TextView tv_right = (TextView) view.findViewById(R.id.tv_right);
        tv_left.setText("公司");
        tv_right.setText("厂家");

        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        list.clear();
        list.add(new CompanyPager(context));
        list.add(new FactoryPager(context));
        BasePagerAdapter basePagerAdapter = new BasePagerAdapter(list);
        viewpager.setAdapter(basePagerAdapter);

        return view ;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }



}
