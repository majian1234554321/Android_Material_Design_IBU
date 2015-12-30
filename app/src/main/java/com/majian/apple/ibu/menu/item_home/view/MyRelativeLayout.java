package com.majian.apple.ibu.menu.item_home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.majian.apple.ibu.R;

/**
 * Created by Apple on 15-9-18.
 */
public class MyRelativeLayout extends RelativeLayout {

    private ImageView iv_img;
    private TextView tv_title;

    public MyRelativeLayout(Context context) {
        super(context);
        iniView(context);
    }

    private void iniView(Context context) {
        View view = View.inflate(context, R.layout.itemview_ibu_mine, this);
        iv_img = (ImageView) view.findViewById(R.id.iv_img);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
    }

    public void setTitle(String content) {
        tv_title.setText(content);
    }
    public void setImage(int resoureId){
        iv_img.setImageResource(resoureId);
    }


    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        iniView(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        iniView(context);

    }
}
