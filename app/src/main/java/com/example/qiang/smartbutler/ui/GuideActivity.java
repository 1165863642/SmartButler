package com.example.qiang.smartbutler.ui;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 18:12
 *  创建人：   Qiang
 *  描述：     引导页
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qiang.smartbutler.MainActivity;
import com.example.qiang.smartbutler.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 16:35
 *  创建人：   Qiang
 *  描述：     引导页
 */

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.mViewPager)
    ViewPager mViewPager;

    //小圆点
    @BindView(R.id.point1)
    ImageView point1;
    @BindView(R.id.point2)
    ImageView point2;
    @BindView(R.id.point3)
    ImageView point3;
    @BindView(R.id.tv_black)
    TextView tv_Black;

    //容器
    private List<View> mlist = new ArrayList<>();
    private View view1, view2, view3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setPointIma(true, false, false);

        view1 = View.inflate(this, R.layout.pager_item_one, null);
        view2 = View.inflate(this, R.layout.pager_item_two, null);
        view3 = View.inflate(this, R.layout.pager_item_three, null);

        view3.findViewById(R.id.btn_start).setOnClickListener(this);
        tv_Black.setOnClickListener(this);

        mlist.add(view1);
        mlist.add(view2);
        mlist.add(view3);
        mViewPager.setAdapter(new GuideAdapter());

        //监听Viewpager滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        setPointIma(true, false, false);
                        tv_Black.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setPointIma(false, true, false);
                        tv_Black.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setPointIma(false, false, true);
                        tv_Black.setVisibility(View.GONE);

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
            case R.id.tv_black:
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ((ViewPager) container).addView(mlist.get(position));
            return mlist.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            ((ViewPager) container).removeView(mlist.get(position));
//            super.destroyItem(container, position, object);
        }
    }

    //设置小圆点参数
    private void setPointIma(boolean isCheck1, boolean isCheck2, boolean isCheck3) {
        if (isCheck1) {
            point1.setImageResource(R.drawable.point_on);
        } else {
            point1.setImageResource(R.drawable.point_off);
        }

        if (isCheck2) {
            point2.setImageResource(R.drawable.point_on);
        } else {
            point2.setImageResource(R.drawable.point_off);
        }

        if (isCheck3) {
            point3.setImageResource(R.drawable.point_on);
        } else {
            point3.setImageResource(R.drawable.point_off);
        }
    }
}
