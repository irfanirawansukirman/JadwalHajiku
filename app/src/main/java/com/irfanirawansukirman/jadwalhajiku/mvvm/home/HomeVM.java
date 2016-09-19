package com.irfanirawansukirman.jadwalhajiku.mvvm.home;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.databinding.HomeActivityBinding;
import com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule.HajjScheduleFragment;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 20/09/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> {
    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
        onReplaceFragment();
    }

    public void onOpenDrawer(View v){
        mBinding.drawer.openDrawer(GravityCompat.START);
    }

    public void onReplaceFragment(){
        FragmentTransaction mFragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, new HajjScheduleFragment().newInstance()).commit();
    }
}
