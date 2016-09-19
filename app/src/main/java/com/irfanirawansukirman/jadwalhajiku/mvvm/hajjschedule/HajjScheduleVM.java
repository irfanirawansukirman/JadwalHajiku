package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import android.support.v7.app.AppCompatActivity;

import com.irfanirawansukirman.jadwalhajiku.databinding.HajjScheduleFragmentBinding;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 20/09/16.
 */
public class HajjScheduleVM extends GitsVM<HajjScheduleController, HajjScheduleFragmentBinding> {
    public HajjScheduleVM(AppCompatActivity activity, HajjScheduleController controller, HajjScheduleFragmentBinding binding) {
        super(activity, controller, binding);
    }
}
