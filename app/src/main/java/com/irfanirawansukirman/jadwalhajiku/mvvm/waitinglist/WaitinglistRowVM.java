package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.content.Context;
import android.databinding.ObservableField;

import com.irfanirawansukirman.jadwalhajiku.api.dao.WaitinglistDao;
import com.irfanirawansukirman.jadwalhajiku.databinding.WaitinglistRowBinding;

import id.gits.mvvmcore.viewmodel.GitsRowVM;
import rx.Observable;

/**
 * Created by irfan on 07/10/16.
 */

public class WaitinglistRowVM extends GitsRowVM<WaitinglistDao.DataBean, WaitinglistRowBinding> {
    public ObservableField<String> mProvince = new ObservableField<>();
    public WaitinglistRowVM(Context context, WaitinglistRowBinding binding, WaitinglistDao.DataBean data) {
        super(context, binding, data);

        mProvince.set(data.getWilayah());
    }
}
