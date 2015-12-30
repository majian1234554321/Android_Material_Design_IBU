package com.majian.apple.ibu.menu.item_home;

import android.content.Context;
import android.view.View;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BasePager;
import com.majian.apple.ibu.menu.item_home.view.MyRelativeLayout;

import java.util.Map;

/**
 * Created by Apple on 15-9-18.
 */
public class IBUFindPager extends BasePager {
    public IBUFindPager(Context context){
        super(context);
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.ibufindpager,null);
        assignViews(view);
        initData();
        return view;

    }

    @Override
    public Map<String, String> setParams(String flag, int pager, String keyword) {
        return null;
    }


    @Override
    public void processData(String response, String flag) {

    }

    private MyRelativeLayout share;
    private MyRelativeLayout message;
    private MyRelativeLayout scan;
    private MyRelativeLayout aliance;
    private MyRelativeLayout nav;

    private void assignViews(View view) {
        share = (MyRelativeLayout) view.findViewById(R.id.share);
        message = (MyRelativeLayout) view.findViewById(R.id.message);
        scan = (MyRelativeLayout) view.findViewById(R.id.scan);
        aliance = (MyRelativeLayout) view.findViewById(R.id.aliance);
        nav = (MyRelativeLayout) view.findViewById(R.id.nav);
    }


    private void initData() {
        share.setTitle("分享圈");
        share.setImage(R.mipmap.icon_share);
        message.setTitle("我的消息");
        message.setImage(R.mipmap.icon_message);
        scan.setTitle("商企联盟 扫一扫");
        scan.setImage(R.mipmap.icon_scan);
        aliance.setTitle("商业联盟");
        aliance.setImage(R.mipmap.icon_aliance);
        nav.setTitle("商务导航");
        nav.setImage(R.mipmap.icon_nav);

    }
}
