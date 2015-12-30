package com.majian.apple.ibu.menu.item_home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BasePager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apple on 15-9-17.
 */
public class Fragment_item_home extends Fragment implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpager;
    public List<BasePager> pagerList = new ArrayList<>();
    private Toolbar toolbar;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private int selectposition;
    private View view;
    private IBUBasePager ibuBasePager;
    private IBUMailListPager ibu_mail_list_pager;
    private IBUFindPager ibuFindPager;
    private IBUMinePager ibuMinePager;
    private RadioGroup rg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment_item_home, null);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);


        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_ordercenter);
        rg = (RadioGroup) view.findViewById(R.id.rg);
        rb1 = (RadioButton) view.findViewById(R.id.rb1);
        rb2 = (RadioButton) view.findViewById(R.id.rb2);
        rb3 = (RadioButton) view.findViewById(R.id.rb3);
        rb4 = (RadioButton) view.findViewById(R.id.rb4);



        rg.setOnCheckedChangeListener(this);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);


        ibuBasePager = new IBUBasePager(getActivity());
        ibu_mail_list_pager = new IBUMailListPager(getActivity());
        ibuFindPager = new IBUFindPager(getActivity());
        ibuMinePager = new IBUMinePager(getActivity());

        pagerList.clear();
        pagerList.add(ibuBasePager);
        pagerList.add(ibu_mail_list_pager);
        pagerList.add(ibuFindPager);
        pagerList.add(ibuMinePager);

        Fragment_item_home_BasePagerAdapter fba = new Fragment_item_home_BasePagerAdapter(pagerList);
        viewpager.setAdapter(fba);
        viewpager.addOnPageChangeListener(this);
        toolbar.setTitle("主页");
        rb1.setChecked(true);

        return view;
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb1:

                viewpager.setCurrentItem(0);

                break;
            case R.id.rb2:

                viewpager.setCurrentItem(1);
                toolbar.inflateMenu(R.menu.main);
                break;
            case R.id.rb3:

                viewpager.setCurrentItem(2);
                toolbar.inflateMenu(R.menu.activity_addorder);

                break;
            case R.id.rb4:

                viewpager.setCurrentItem(3);
                break;


        }

        rg.check(checkedId);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        selectposition = position;

        if (selectposition == 0) {
            toolbar.setTitle("主页");
            rb1.setChecked(true);

        } else if (selectposition == 1) {
            toolbar.setTitle("通讯录");
            rb2.setChecked(true);
        } else if (selectposition == 2) {
            toolbar.setTitle("发现");
            rb3.setChecked(true);
        } else  if (selectposition ==3){
            toolbar.setTitle("我");
            rb4.setChecked(true);
        }else {
            toolbar.setTitle("主页");
            rb1.setChecked(true);
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class Fragment_item_home_BasePagerAdapter extends PagerAdapter {
        public List<BasePager> lists;

        public Fragment_item_home_BasePagerAdapter(List<BasePager> lists) {
            this.lists = lists;
        }

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(lists.get(position).getView());

            return lists.get(position).getView();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(lists.get(position).getView());
        }
    }
}
