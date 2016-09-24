package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistFragmentBinding;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistController extends GitsController<WaitinglistVM, WaitinglistFragmentBinding> {
    @Override
    public WaitinglistVM createViewModel(WaitinglistFragmentBinding binding) {
        return new WaitinglistVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(WaitinglistFragmentBinding binding, WaitinglistVM viewModel) {
        binding.setVm(viewModel);
    }
}
