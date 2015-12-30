package com.majian.apple.ibu.api;


import com.majian.apple.ibu.utils.CryptoUtil;

/**
 * Created by Apple on 15-8-27.
 */
public class Config {

    public static String IMEI;
    public static String USERNAME;
    public static String PASSWORD;
    public static String SESSIONID;
    public static String APKVERSION ="V3R46A1P1";

    public final static String SEED = CryptoUtil.getSeed();
    public final static String KEY = CryptoUtil.getKey(Config.SEED);


//    public static String IBU_INTERNET_IP = "http://14.215.128.74:9081/client"; //
//    public static String INTERNET_IP = "http://14.215.128.74:9081"; //测试环境

//    	public static String IBU_INTERNET_IP = "http://192.168.1.26:8080/ibuadmin/client";
//        public static String INTERNET_IP = "http://192.168.1.26:8080/ibuadmin"; //调试环境

      public static String IBU_INTERNET_IP = "http://web.ibumobile.com/client";
  public static String INTERNET_IP = "http://web.ibumobile.com"; //正式平台

    public static String IP_ADDRESS = INTERNET_IP + "/client/";

    //登陆
    public static String LOGIN_URL = IP_ADDRESS
            + "head-ClientLogin-getLogin.do";

    //打考勤
    public static String ADD_ATTENDANCE_URL = IP_ADDRESS
            + "attendance-Attendance-addAttendance.do";

    //查看考勤
    public static String QUERY_ATTENDANCE_LIST_URL = IP_ADDRESS
            + "attendance-Attendance-queryAttendanceListNew.do";

    //商品信息中厂家选项的接口
    public static String COMMODITYINFOR_FACTORY = IP_ADDRESS + "productGrant-ProductGrant-getProductGrantList.do";
}
