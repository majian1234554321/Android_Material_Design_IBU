package com.majian.apple.ibu.menu.item_home.maillist;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.majian.apple.ibu.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_ibumail_add)

public class IBUMailAddActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.sv_search)
    SearchView sv_search;


    @ViewById(R.id.qr_show)
    ImageView qr_show;

    @AfterViews
    void updateUi(){
        toolbar.setTitle("添加好友");
        toolbar.setNavigationIcon(R.mipmap.ibu_arrow_left_48);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        sv_search.requestFocus();
        sv_search.setOnQueryTextListener(this);


        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        int w = outMetrics.widthPixels * 8 / 11;//设置宽度
        ViewGroup.LayoutParams layoutParams = qr_show.getLayoutParams();
        layoutParams.height = layoutParams.width = w;//设置高度
        qr_show.setLayoutParams(layoutParams);

        try {
            Bitmap bitmap = QRUtils.encodeToQRWidth("majian", w);//要生成二维码的内容，我这就是一个网址
            qr_show.setImageBitmap(bitmap);
        }
        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "生成二维码失败", Toast.LENGTH_SHORT);
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this,query,Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Toast.makeText(this,newText,Toast.LENGTH_SHORT).show();
        return false;
    }
}
