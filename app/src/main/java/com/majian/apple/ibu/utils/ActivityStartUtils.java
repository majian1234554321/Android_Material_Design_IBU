package com.majian.apple.ibu.utils;

import android.content.Context;
import android.content.Intent;


public class ActivityStartUtils {

	
	
	public static void jump(Context context,Class clazz){
		Intent intent = new Intent();
		intent.setClass(context, clazz);
		context.startActivity(intent);
	}
	

	public static void jump(Context context,Class clazz,String key,String value){
		Intent intent = new Intent();
		intent.setClass(context, clazz);
		intent.putExtra(key, value);
		context.startActivity(intent);
	}

	public static void jump1(Context context,Class clazz,String key,String value){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		intent.putExtra(key, value);
		context.startActivity(intent);

	}


	public static void jump1(Context context,Class clazz,String key,String value,String key2,String value2){
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setClass(context, clazz);
		intent.putExtra(key, value);
		intent.putExtra(key2, value2);
		context.startActivity(intent);

	}
	
}
