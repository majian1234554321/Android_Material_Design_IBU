package com.majian.apple.ibu.menu.ordercenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.majian.apple.ibu.R;
import com.majian.apple.ibu.base.BaseFragment;

import java.util.Map;

/**
 * Created by Apple on 15-9-29.
 * 订单中心
 */
@SuppressLint("ValidFragment")
public class Fragment_OrderCenter extends BaseFragment {
    public Fragment_OrderCenter(Context context) {
        super(context);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View  view =  View.inflate(context, R.layout.fragment_ordercenter,null);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("订单中心");
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                switch (item.getItemId()){
                    case R.id.addorder:
                        Toast.makeText(context,"新增订单",Toast.LENGTH_SHORT).show();
                        getActivity().startActivityForResult(new Intent(context,AddOrder_Activity_.class),10086);
                        break;
                    case R.id.selectorder:
                        Toast.makeText(context,"查询订单",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.helper:
                        break;

                }
                return true;
            }
        });

        // 手工把 菜单 添加到 Toolbar 中
        toolbar.inflateMenu(R.menu.menu_ordercenter);

        return view;
    }

    @Override
    public Map<String, String> setParams(String tag, String pager) {
        return null;
    }

    @Override
    public void processData(String response, String tag, String pager) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
