package com.example.qiang.smartbutler.utils;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.utils
 *  创建时间： 2019-07-16 16:42
 *  创建人：   Qiang
 *  描述：     Log封装类
 */

import android.util.Log;

public class L {
    //开关
    public static final boolean DEBUG = true;

    //TAG
    public static final String TAG = "SmartButler";

    //5个等级

    public static void d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }
}
