package com.example.cuiqiang.aopdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mBtnTest = findViewById(R.id.btn_test);
    }

    private void initData() {
        BusinessManager.getInstance().init();
        BusinessManager.getInstance().register(BusinessConstant.CLASS_TWO);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusinessManager.getInstance().show(BusinessConstant.CLASS_ONE);
                BusinessManager.getInstance().show(BusinessConstant.CLASS_TWO);
            }
        });
    }
}
