package com.irfanirawansukirman.jadwalhajiku.mvvm.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.base.BaseActivity;

public class HomeActivity extends BaseActivity<HomeController> {

    @Override
    protected int getToolbarId() {
        return 0;
    }

    @Override
    protected int getResLayout() {
        return R.layout.home_activity;
    }

    @Override
    protected HomeController createController() {
        return new HomeController();
    }
}
