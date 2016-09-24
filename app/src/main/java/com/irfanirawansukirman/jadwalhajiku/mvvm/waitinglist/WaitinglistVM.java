package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.support.v7.app.AppCompatActivity;

import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistFragmentBinding;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistVM extends GitsVM<WaitinglistController, WaitinglistFragmentBinding> {

    public WaitinglistVM(AppCompatActivity activity, WaitinglistController controller, WaitinglistFragmentBinding binding) {
        super(activity, controller, binding);
    }
}
