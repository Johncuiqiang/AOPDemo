package com.example.cuiqiang.aopdemo;

import android.util.Log;

/**
 * @Author : cuiqiang
 * @DATE : 2018/12/14 13:47
 * @Description :
 */
public class Business1 implements BusinessListener {

    @Override
    public void show(String showName) {
        Log.d("Business", "show1 " + showName);
    }

    @Override
    public void click(String clickName) {
        Log.d("Business", "click1 " + clickName);
    }
}
