package com.majian.apple.ibu.menu.attendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.majian.apple.ibu.MainActivity;

/**
 * Created by Apple on 15-9-18.
 */
public class Attendance_AddressActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("hah");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("data","qq");
        setResult(-1,intent);
        finish();
    }
}
