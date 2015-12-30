package com.majian.apple.ibu.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

/**
 * Created by Administrator on 2015/5/28.
 */
public class PhoneInfoUtils {


    private static int versionCode;
    private static String versionName;

    public static String getVersionCode(Context context) {

        try {
            versionCode = context.getPackageManager()
                    .getPackageInfo("com.soarsky.ibu", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode + "";
    }


    public static String getVersionName(Context context) {

        try {
            versionName = context.getPackageManager()
                       .getPackageInfo("com.soarsky.ibu", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName ;
    }

    public static String getIMEI(Context context){
        TelephonyManager telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei=telephonyManager.getDeviceId();
        return imei;
    }
}
