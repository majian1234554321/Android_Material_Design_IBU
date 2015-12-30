package com.majian.apple.ibu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.majian.apple.ibu.base.BaseActivity;
import com.majian.apple.ibu.menu.attendance.Fragment_attendance;
import com.majian.apple.ibu.menu.commodityinformation.Fragment_Commodity;
import com.majian.apple.ibu.menu.dailyweeklymonthlyreport.Fragment_Daily_Weekly_Monthly_Report;
import com.majian.apple.ibu.menu.dataanalysis.Fragment_DataAnalysis;
import com.majian.apple.ibu.menu.item_home.Fragment_item_home;
import com.majian.apple.ibu.menu.ordercenter.Fragment_OrderCenter;
import com.majian.apple.ibu.menu.salesapproval.Fragment_SalesApproval;

import java.util.Map;


public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Fragment_item_home fragment1 = new Fragment_item_home();
        getSupportFragmentManager().beginTransaction().replace(R.id.rl, fragment1).commit();
    }

    @Override
    public Map<String, String> setParams(String flag) {
        return null;
    }

    @Override
    public void processData(String response, String flag) {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment = null;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.item_home://我不忧
                fragment = new Fragment_item_home();
                break;
            case R.id.attendance://考勤
                fragment = new Fragment_attendance(this);

                break;
            case R.id.dwyreport://工作日程
                fragment = new Fragment_Daily_Weekly_Monthly_Report(this);
                break;

            case R.id.workflow://工作流程

                break;
            case R.id.company_document://公司发文

                break;
            case R.id.enterprise_customer://企业客户

                break;
            case R.id.business_contacts://企业联系人

                break;
            case R.id.team_management://团队管理

                break;
            case R.id.sales_opportunities://销售机会

                break;
            case R.id.data_analysis://数据分析
                fragment = new Fragment_DataAnalysis(this);

                break;
            case R.id.commodity_information://商品信息
                fragment = new Fragment_Commodity(this);
                break;
            case R.id.sales_approval://销售审批
                fragment = new Fragment_SalesApproval(this);
                break;
            case R.id.ordercenter://订单中心
                fragment = new Fragment_OrderCenter(this);
                break;


        }
        fragmentTransaction.replace(R.id.rl, fragment).commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
