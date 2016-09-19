package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import android.os.Bundle;

import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.base.BaseFragment;

/**
 * Created by irfan on 20/09/16.
 */
public class HajjScheduleFragment extends BaseFragment<HajjScheduleController> {
    public static HajjScheduleFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HajjScheduleFragment fragment = new HajjScheduleFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    protected HajjScheduleController createController() {
        return new HajjScheduleController();
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.hajj_schedule_fragment;
    }
}
