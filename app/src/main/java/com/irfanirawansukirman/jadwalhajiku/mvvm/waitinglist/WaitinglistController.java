package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.os.Bundle;
import android.util.Log;

import com.irfanirawansukirman.jadwalhajiku.HajjApp;
import com.irfanirawansukirman.jadwalhajiku.api.core.Observers;
import com.irfanirawansukirman.jadwalhajiku.api.dao.WaitinglistDao;
import com.irfanirawansukirman.jadwalhajiku.api.hajjapi.HajjApi;
import com.irfanirawansukirman.jadwalhajiku.api.repository.WaitinglistRepository;
import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistFragmentBinding;
import com.irfanirawansukirman.jadwalhajiku.util.Constant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import id.gits.mvvmcore.controller.GitsController;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistController extends GitsController<WaitinglistVM, WaitinglistFragmentBinding> {
    public List<WaitinglistDao.DataBean> mData = new ArrayList<>();
    @Override
    public void onCreateController(Bundle savedInstanceState) {
        super.onCreateController(savedInstanceState);
        getWaitingist();
    }

    @Override
    public WaitinglistVM createViewModel(WaitinglistFragmentBinding binding) {
        return new WaitinglistVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(WaitinglistFragmentBinding binding, WaitinglistVM viewModel) {
        binding.setVm(viewModel);
    }

    public void getWaitingist(){
        WaitinglistRepository mRepository = new WaitinglistRepository(HajjApp.getApi());
        addSubscription(mRepository.getDataWaitinglist(
                "waiting",
                Constant.API_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observers<WaitinglistDao>() {
            @Override
            public void onApiResultCompleted() {
                mViewModel.onNotifyRecycler();
                mViewModel.stopProgress();
            }

            @Override
            public void onApiResultError(String message) {
                mViewModel.stopAndRetry();
            }

            @Override
            public void onApiResultOk(WaitinglistDao waitinglistDao) {
                mViewModel.startProgress();
                if (waitinglistDao != null){
                    mData.addAll(waitinglistDao.getData());
                }
            }
        }));
    }
}
