package com.example.qiang.smartbutler.utils;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.utils
 *  创建时间： 2019-07-16 16:46
 *  创建人：   Qiang
 *  描述：     TODO
 */

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUtils {
    public static final String NAME = "config";

    //键 值
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    //键 默认值
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    //删除单个
    public static void delShare(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().remove(key).apply();
    }

    //删除 全部
    public static void delAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
        sp.edit().clear().apply();
    }
}

