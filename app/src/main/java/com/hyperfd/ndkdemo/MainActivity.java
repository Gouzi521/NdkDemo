package com.hyperfd.ndkdemo;

import android.os.Bundle;

import com.hyperfd.architecture.ui.page.BaseActivity;
import com.kunminx.architecture.ui.page.DataBindingConfig;

public class MainActivity extends BaseActivity {


    @Override
    protected void initViewModel() {

    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }





}
