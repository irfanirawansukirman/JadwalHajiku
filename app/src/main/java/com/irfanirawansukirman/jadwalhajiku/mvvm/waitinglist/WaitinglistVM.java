package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistFragmentBinding;
import com.irfanirawansukirman.jadwalhajiku.util.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistVM extends GitsVM<WaitinglistController, WaitinglistFragmentBinding> {
    public List<String> mData = new ArrayList<>();
    public LinearLayoutManager mLinearLayoutManager;
    public WaitinglistAdapter mAdapter;

    public WaitinglistVM(AppCompatActivity activity, WaitinglistController controller, WaitinglistFragmentBinding binding) {
        super(activity, controller, binding);
        setList();

        mBinding.baso.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mController.getWaitingist();
            }
        });
    }

    public void setList() {
        mLinearLayoutManager = new LinearLayoutManager(mActivity);
        mBinding.recWaitinglist.setHasFixedSize(true);
        mAdapter = new WaitinglistAdapter(mController.mData);
        mBinding.recWaitinglist.addItemDecoration(new DividerItemDecoration(mActivity, null));
    }

    public void onNotifyRecycler(){
        mAdapter.notifyDataSetChanged();
    }

    public void startProgress() {
        mBinding.baso.startProgress();
    }

    public void stopProgress() {
        mBinding.baso.stopAndGone();
    }

    public void stopAndRetry() {
        mBinding.baso.stopAndError("erjadi kesalahan. Cek koneksi internet anda.", true);
    }
}
