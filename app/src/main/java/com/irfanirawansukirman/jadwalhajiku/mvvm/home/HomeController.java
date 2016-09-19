package com.irfanirawansukirman.jadwalhajiku.mvvm.home;

import com.irfanirawansukirman.jadwalhajiku.databinding.HomeActivityBinding;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by irfan on 20/09/16.
 */
public class HomeController extends GitsController<HomeVM, HomeActivityBinding> {
    @Override
    public HomeVM createViewModel(HomeActivityBinding binding) {
        return new HomeVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(HomeActivityBinding binding, HomeVM viewModel) {
        binding.setVm(viewModel);
    }
}
