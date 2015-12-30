package com.majian.apple.ibu.menu.ordercenter;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BaseActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Map;

/**
 * Created by Apple on 15-9-29.
 */


@EActivity(R.layout.addorder_activity)
public class AddOrder_Activity extends BaseActivity {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;
    @ViewById(R.id.aov1)
    Add_OrderView aov1;
    @ViewById(R.id.aov2)
    Add_OrderView aov2;
    @ViewById(R.id.aov3)
    Add_OrderView aov3;
    @ViewById(R.id.aov4)
    Add_OrderView aov4;


    @AfterViews
    void updateUi() {
        toolbar.setTitle("新增订单");
        toolbar.setNavigationIcon(R.mipmap.ibu_arrow_left_48);

        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        aov1.setTv_Title("订单名称：");
        aov1.setivVisible(true, false);
        aov2.setTv_Title("公司名称：");
        aov2.setivVisible(false, true);

        aov3.setTv_Title("商品列表：");
        aov3.setivVisible(true, true);
        aov4.setTv_Title("订单金额：");
        aov4.setivVisible(false,false);

    }

    @Override
    public Map<String, String> setParams(String flag) {
        return null;
    }

    @Override
    public void processData(String response, String flag) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_addorder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this,  "点击事件查询订单", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
