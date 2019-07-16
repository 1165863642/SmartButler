package com.example.qiang.smartbutler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.qiang.smartbutler.fragment.ButlerFragment;
import com.example.qiang.smartbutler.fragment.GirlFragment;
import com.example.qiang.smartbutler.fragment.UserFragment;
import com.example.qiang.smartbutler.fragment.WechatFragment;
import com.example.qiang.smartbutler.ui.SettingActivity;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.mTabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    @BindView(R.id.fab_setting)
    FloatingActionButton fabSetting;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
        initView();

//        CrashReport.testJavaCrash();
    }

    //初始化数据
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add(getResourcesString(R.string.butler));
        mTitle.add(getResourcesString(R.string.wechat));
        mTitle.add(getResourcesString(R.string.girl));
        mTitle.add(getResourcesString(R.string.user));

        mFragment = new ArrayList<>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }


    private String getResourcesString(int resourcesId) {
        return getResources().getString(resourcesId);
    }

    //初始化View
    @SuppressLint("RestrictedApi")
    private void initView() {
        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());
        //默认隐藏
        fabSetting.setVisibility(View.GONE);

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return mFragment.get(i);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.i("TAG", "position:" + i);
                if (i == 0) {
                    fabSetting.setVisibility(View.GONE);
                } else {
                    fabSetting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mTabLayout.setupWithViewPager(mViewPager);

        fabSetting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
