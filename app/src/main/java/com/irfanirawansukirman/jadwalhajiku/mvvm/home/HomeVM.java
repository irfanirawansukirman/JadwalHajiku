package com.irfanirawansukirman.jadwalhajiku.mvvm.home;

import android.annotation.TargetApi;
import android.databinding.tool.reflection.SdkUtil;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.databinding.HomeActivityBinding;
import com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule.HajjScheduleFragment;
import com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist.WaitinglistFragment;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 20/09/16.
 */
public class HomeVM extends GitsVM<HomeController, HomeActivityBinding> {
    public HomeVM(AppCompatActivity activity, HomeController controller, HomeActivityBinding binding) {
        super(activity, controller, binding);
        onReplaceFragment();
        onMenuListener();
    }

    public void onReplaceFragment() {
        Fragment mFragment = new HajjScheduleFragment();
        FragmentTransaction mFragmentTransaction = mActivity.getSupportFragmentManager().beginTransaction();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mFragment.setEnterTransition(new Fade(Fade.IN));
            mFragment.setExitTransition(new Fade(Fade.OUT));
            mFragmentTransaction
                    .replace(R.id.container, mFragment).commit();
        } else {
            mFragmentTransaction
                    .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                    .replace(R.id.container, mFragment).commit();
        }
    }

    public void onOpenDrawer(View v) {
        mBinding.drawer.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        mBinding.drawer.closeDrawer(GravityCompat.START);
    }

    public void onMenuListener() {
        mBinding.navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment mFragment = null;
                FragmentManager mFragmentManager = mActivity.getSupportFragmentManager();
                switch (item.getItemId()) {
                    case R.id.home_perkiraan_haji:
                        mFragment = new HajjScheduleFragment();
                        break;
                    case R.id.home_waiting_list:
                        mFragment = new WaitinglistFragment();
                        break;
                    case R.id.home_penyelenggara:
                        break;
                    default:
                        break;
                }

                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                closeDrawer();

                if (mFragment != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        mFragment.setEnterTransition(new Fade(Fade.IN));
                        mFragment.setExitTransition(new Fade(Fade.OUT));
                        mFragmentManager.beginTransaction()
                                .replace(R.id.container, mFragment)
                                .commit();
                    } else {
                        mFragmentManager.beginTransaction()
                                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                                .replace(R.id.container, mFragment)
                                .commit();
                    }
                }

                return true;
            }
        });
    }
}
