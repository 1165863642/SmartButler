package com.example.qiang.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.example.qiang.smartbutler.R;
import com.example.qiang.smartbutler.utils.ShareUtils;
import com.example.qiang.smartbutler.utils.StaticClass;
import com.example.qiang.smartbutler.utils.UtilTools;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 16:56
 *  创建人：   Qiang
 *  描述：     分页导航
 */

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.tv_splash)
    TextView tvSplash;

    /**
     * 1.延迟2000毫秒
     * 2.判断程序是否第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLER_SPLASH:
                    //判断程序是否是第一次运行
                    if (isFirst()) {
                        ShareUtils.putBoolean(SplashActivity.this, StaticClass.SHARE_IS_FIRST, false);
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                    break;
            }
        }
    };

    /**
     * 判断程序是否第一次运行
     *
     * @return
     */
    private boolean isFirst() {
        return ShareUtils.getBoolean(this, StaticClass.SHARE_IS_FIRST, true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        initView();

    }

    private void initView() {
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH, 2000);
        //设置字体
        UtilTools.setFont(this, tvSplash);
    }

    //禁止返回键
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
