package com.example.qiang.smartbutler.entity;
/*
 *  项目名：  SmartButler
 *  包名  ：  com.example.qiang.smartbutler.entity
 *  创建时间： 2019-07-16 22:15
 *  创建人：   Qiang
 *  描述：     用户属性
 */

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser {
    private int age;
    private boolean sex;
    private String desc;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
