package com.majian.apple.ibu.menu.ordercenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.majian.apple.ibu.R;

/**
 * Created by Apple on 15-9-30.
 */
public class Add_OrderView extends RelativeLayout {

    private ImageView iv_1;
    private TextView tv_title;
    private EditText et_content;
    private ImageView iv_2;

    public Add_OrderView(Context context) {
        super(context);
        initView(context);
    }

    public Add_OrderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.add_orderview, null);
        iv_1 = (ImageView) view.findViewById(R.id.iv_1);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        et_content = (EditText) view.findViewById(R.id.et_content);
        iv_2 = (ImageView) view.findViewById(R.id.iv_2);
addView(view);
    }

    /**
     *
     * @param flag1 设置第一个ImageView 是否展示
     * @param flag2 设置右边的imageview 是否展示
     */
    public void setivVisible(boolean flag1,boolean flag2 ){
        if (flag1){
            iv_1.setVisibility(View.VISIBLE);
        }else {
            iv_1.setVisibility(View.INVISIBLE);
        }
        if (flag2){

            iv_2.setVisibility(View.VISIBLE);
        }else {
            iv_2.setVisibility(View.INVISIBLE);
        }
    }

    public void setTv_Title(String title){
        tv_title.setText(title);
    }

    /**
     *
     * @param title 显示的数据
     * @param isEdit 是否可以编辑
     */
    public void setEt_Content(String title,boolean isEdit){

        if (isEdit){
            et_content.setEnabled(false);
        }else {
            et_content.setEnabled(false);
        }et_content.setText(title);
    }
}

