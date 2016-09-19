package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import com.irfanirawansukirman.jadwalhajiku.databinding.HajjScheduleFragmentBinding;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by irfan on 20/09/16.
 */
public class HajjScheduleController extends GitsController<HajjScheduleVM, HajjScheduleFragmentBinding> {
    @Override
    public HajjScheduleVM createViewModel(HajjScheduleFragmentBinding binding) {
        return new HajjScheduleVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(HajjScheduleFragmentBinding binding, HajjScheduleVM viewModel) {
        binding.setVm(viewModel);
    }
}
