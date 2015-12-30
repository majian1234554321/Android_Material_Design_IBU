package com.majian.apple.ibu.menu.item_home;

import android.content.Context;
import android.view.View;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BasePager;
import com.majian.apple.ibu.menu.item_home.mine.Setting_Activity;
import com.majian.apple.ibu.menu.item_home.mine.Setting_Activity_;
import com.majian.apple.ibu.menu.item_home.view.MyRelativeLayout;
import com.majian.apple.ibu.utils.ActivityStartUtils;

import java.util.Map;

/**
 * Created by Apple on 15-9-18.
 */
public class IBUMinePager extends BasePager implements View.OnClickListener {
    public IBUMinePager(Context context){
        super(context);
    }

    @Override
    public View initView() {
       View view = View.inflate(context, R.layout.ibuminepager,null);
        assignViews(view);
        initData();
        setting.setOnClickListener(this);
        return view;
    }

    @Override
    public Map<String, String> setParams(String flag, int pager, String keyword) {
        return null;
    }


    @Override
    public void processData(String response, String flag) {

    }

    private void initData() {
        mydetails.setTitle("马剑");
        myshare.setTitle("我的分享圈");
        myshare.setImage(R.mipmap.icon_share);
        mycard.setTitle("电子名片");
        mycard.setImage(R.mipmap.icon_card);
        netdisk.setTitle("网盘");
        netdisk.setImage(R.mipmap.icon_netdisk);
        flowData.setTitle("优惠流量");
        flowData.setImage(R.mipmap.icon_flowdata);
        setting.setTitle("设置");
        setting.setImage(R.mipmap.icon_setting);
        collection.setTitle("收藏");
        collection.setImage(R.mipmap.icon_fav);


    }

    private MyRelativeLayout mydetails;
    private MyRelativeLayout myshare;
    private MyRelativeLayout mycard;
    private MyRelativeLayout netdisk;
    private MyRelativeLayout flowData;
    private MyRelativeLayout setting;
    private MyRelativeLayout collection;

    private void assignViews(View view ) {
        mydetails = (MyRelativeLayout)view. findViewById(R.id.mydetails);
        myshare = (MyRelativeLayout)view. findViewById(R.id.myshare);
        mycard = (MyRelativeLayout) view.findViewById(R.id.mycard);
        netdisk = (MyRelativeLayout) view.findViewById(R.id.netdisk);
        flowData = (MyRelativeLayout) view.findViewById(R.id.flow_data);
        setting = (MyRelativeLayout) view.findViewById(R.id.setting);
        collection = (MyRelativeLayout) view.findViewById(R.id.collection);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting:
                ActivityStartUtils.jump(context, Setting_Activity_.class);
                break;
        }
    }
}
