package com.example.qiang.smartbutler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qiang.smartbutler.R;
import com.example.qiang.smartbutler.entity.MyUser;
import com.example.qiang.smartbutler.utils.L;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
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
                String name = etUser.getText().toString().trim();
                String pass = etPasswd.getText().toString().trim();
                if (!TextUtils.isEmpty(name) & !TextUtils.isEmpty(pass)) {
                    loginByAccount(getCurrentFocus(), name, pass);
                } else {
                    Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_register:
                //注册
                startActivity(new Intent(this, RegisterActivity.class));
//                if (BmobUser.isLogin()) {
//                    MyUser user= BmobUser.getCurrentUser(MyUser.class);
//                    Snackbar.make(view, "已经登录：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
//                } else {
//                    Snackbar.make(view, "尚未登录", Snackbar.LENGTH_LONG).show();
//                }
                break;
            case R.id.tv_forget_password:
                //忘记密码
                break;
        }
    }

    private void loginByAccount(final View view, String name, String pass) {
        //此处替换为你的用户名密码
        BmobUser.loginByAccount(name, pass, new LogInListener<MyUser>() {
            @Override
            public void done(MyUser user, BmobException e) {
                if (e == null) {
                    Snackbar.make(view, "登录成功：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(view, "登录失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                    L.i(e.getMessage() + e.getErrorCode());

                }
            }
        });
    }
}
