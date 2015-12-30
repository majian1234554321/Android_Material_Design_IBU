package com.majian.apple.ibu.menu.dailyweeklymonthlyreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
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
 */
@SuppressLint("ValidFragment")
public class Fragment_Daily_Weekly_Monthly_Report extends BaseFragment {
    public List<BasePager> lists  = new ArrayList<>();

    public Fragment_Daily_Weekly_Monthly_Report(Context context) {
        super(context);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
       View view = View.inflate(context, R.layout.fragment_daily_weekly_monthly_report,null);
        TextView tv_left = (TextView) view.findViewById(R.id.tv_left);
        TextView tv_middle = (TextView) view.findViewById(R.id.tv_middle);
        TextView tv_right = (TextView) view.findViewById(R.id.tv_right);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tv_left.setText("日报");
        tv_middle.setText("周报");
        tv_right.setText("月报");


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("日、周、月报");
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.syncState();





        lists.add(new DayPager(context));
        lists.add(new WeekPager(context));
        lists.add(new MonthPager(context));

        BasePagerAdapter fragment_daily_weekly_monthly_reportadapter = new BasePagerAdapter(lists);

        viewPager.setAdapter(fragment_daily_weekly_monthly_reportadapter);


        return view;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }


}
