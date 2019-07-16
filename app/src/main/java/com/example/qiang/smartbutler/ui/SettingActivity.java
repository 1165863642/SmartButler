package com.example.qiang.smartbutler.ui;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 16:35
 *  创建人：   Qiang
 *  描述：     设置
 */

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.qiang.smartbutler.R;

public class SettingActivity extends BaseActivity{
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_setting);
    }
}
