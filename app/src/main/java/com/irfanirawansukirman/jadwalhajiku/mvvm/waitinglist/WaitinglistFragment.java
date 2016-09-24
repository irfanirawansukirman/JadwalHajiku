package com.irfanirawansukirman.jadwalhajiku.mvvm.waitinglist;

import android.os.Bundle;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.base.BaseFragment;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistFragment extends BaseFragment<WaitinglistController> {
    public static WaitinglistFragment newInstance() {

        Bundle args = new Bundle();

        WaitinglistFragment fragment = new WaitinglistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected WaitinglistController createController() {
        return new WaitinglistController();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.waitinglist_fragment;
    }
}
