package com.irfanirawansukirman.jadwalhajiku.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.irfanirawansukirman.jadwalhajiku.R;

import id.gits.mvvmcore.controller.GitsController;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by irfan on 20/09/16.
 */
public abstract class BaseActivity<C extends GitsController> extends AppCompatActivity {
    protected C mController;
    ViewDataBinding mBinding;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout(), getToolbarId());
        mController = createController();
        mController.initController(this, mBinding, savedInstanceState);

        /**
         * init calligraphy font setup
         */
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Muli.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void setContentView(@LayoutRes int idLayout, @IdRes int idToolbar) {
        mBinding = DataBindingUtil.setContentView(this, getResLayout());

        mToolbar = (Toolbar) findViewById(getToolbarId());
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    protected abstract
    @IdRes
    int getToolbarId();

    protected abstract
    @LayoutRes
    int getResLayout();

    protected abstract C createController();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mController.destroyController();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mController.pauseController();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mController.resumeController();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mController.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
