package com.example.qiang.smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qiang.smartbutler.R;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.fragment
 *  创建时间： 2019-07-16 16:35
 *  创建人：   Qiang
 *  描述：     服务管家
 */
public class ButlerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_butler, null);
        return view;

    }
}
