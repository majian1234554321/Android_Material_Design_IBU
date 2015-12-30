package com.majian.apple.ibu.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Apple on 15-9-29.
 */
public class BasePagerAdapter extends PagerAdapter {

    public List<BasePager> lists;
    public  BasePagerAdapter(List<BasePager> lists){
        this.lists =lists;

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
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(lists.get(position).getView());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(lists.get(position).getView());

        return lists.get(position).getView();
    }
}
