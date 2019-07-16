package com.example.qiang.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qiang.smartbutler.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 16:35
 *  创建人：   Qiang
 *  描述：     登陆
 */

public class LoginActivity extends AppCompatActivity {
    //用户名
    @BindView(R.id.et_user)
    EditText etUser;
    //密码
    @BindView(R.id.et_passwd)
    EditText etPasswd;
    //记住密码
    @BindView(R.id.cb_remember)
    CheckBox cbRemember;
    //登陆
    @BindView(R.id.btn_login)
    Button btnLogin;
    //注册
    @BindView(R.id.btn_register)
    Button btnRegister;
    //忘记密码
    @BindView(R.id.tv_forget_password)
    TextView tvForgetPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_register, R.id.tv_forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                //登陆
                break;
            case R.id.btn_register:
                //注册
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.tv_forget_password:
                //忘记密码
                break;
        }
    }
}
