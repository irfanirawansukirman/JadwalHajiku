package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.irfanirawansukirman.jadwalhajiku.api.event.PerkiraanBerangkatEvent;
import com.irfanirawansukirman.jadwalhajiku.databinding.HajjScheduleFragmentBinding;

import org.greenrobot.eventbus.EventBus;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 20/09/16.
 */
public class HajjScheduleVM extends GitsVM<HajjScheduleController, HajjScheduleFragmentBinding> {
    public HajjScheduleVM(AppCompatActivity activity, HajjScheduleController controller, HajjScheduleFragmentBinding binding) {
        super(activity, controller, binding);
//        EventBus.getDefault().register(this);
    }

    public void onShowResult(View v){
        FragmentManager mFragmentManager = mActivity.getSupportFragmentManager();
        HajjScheduleDialogFragment mDialog = new HajjScheduleDialogFragment().newInstance(mBinding.edTxtNomorPorsi.getText().toString());
        mBinding.edTxtNomorPorsi.getText().clear();
        mDialog.show(mFragmentManager, "fragment");
    }
}
