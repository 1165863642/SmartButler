package com.example.qiang.smartbutler.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.qiang.smartbutler.R;
import com.example.qiang.smartbutler.entity.MyUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.ui
 *  创建时间： 2019-07-16 16:35
 *  创建人：   Qiang
 *  描述：     注册
 */

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.et_desc)
    EditText etDesc;
    @BindView(R.id.rb_boy)
    RadioButton rbBoy;
    @BindView(R.id.rb_girl)
    RadioButton rbGirl;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.et_pass)
    EditText etPass;
    @BindView(R.id.et_passwd)
    EditText etPasswd;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.btn_register)
    Button btnRegister;

    //性别
    private boolean isGender = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

    }


    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        String name = etUser.getText().toString().trim();
        String age = etAge.getText().toString().trim();
        String desc = etDesc.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        String passwd = etPasswd.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        //判断是否为空
        if (!TextUtils.isEmpty(name) & !TextUtils.isEmpty(age)
                & !TextUtils.isEmpty(pass) & !TextUtils.isEmpty(passwd)
                & !TextUtils.isEmpty(email)) {

            if (pass.equals(passwd)) {
                //先判断性别
                radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (i == R.id.rb_boy) {
                            isGender = true;
                        } else if (i == R.id.rb_girl)
                            isGender = false;
                    }
                });

                if (TextUtils.isEmpty(desc))
                    desc = "这个人很懒，什么都没留下";
                final MyUser user = new MyUser();
                user.setUsername(name);
                user.setPassword(pass);
                user.setEmail(email);
                user.setAge(Integer.parseInt(age));
                user.setDesc(desc);
                user.signUp(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser user, BmobException e) {
                        if (e == null) {
//                            Snackbar.make(this, "注册成功", Snackbar.LENGTH_LONG).show();
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
//                            Snackbar.make(getCurrentFocus(), "尚未失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
                            Toast.makeText(RegisterActivity.this, "注册失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(this, "两次输入都密码都不一样", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
        }
    }
}
