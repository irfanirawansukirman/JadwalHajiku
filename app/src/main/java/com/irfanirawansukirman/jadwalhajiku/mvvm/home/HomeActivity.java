package com.irfanirawansukirman.jadwalhajiku.mvvm.home;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.base.BaseActivity;
import com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule.HajjScheduleFragment;
import com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist.WaitinglistFragment;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
