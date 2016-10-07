package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.support.v7.app.AppCompatActivity;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.api.dao.WaitinglistDao;
import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistRowBinding;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;

/**
 * Created by irfan on 07/10/16.
 */

public class WaitinglistAdapter extends GitsAdapter<WaitinglistDao.DataBean, WaitinglistRowVM, WaitinglistRowBinding> {

    public WaitinglistAdapter(List<WaitinglistDao.DataBean> collection) {
        super(collection);
    }

    @Override
    public WaitinglistRowVM createViewModel(AppCompatActivity activity, WaitinglistRowBinding binding, WaitinglistDao.DataBean item, int position) {
        return new WaitinglistRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.waitinglist_row;
    }

    @Override
    public void render(WaitinglistRowBinding binding, WaitinglistRowVM viewModel, WaitinglistDao.DataBean item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(WaitinglistDao.DataBean data, int position) {

    }
}
