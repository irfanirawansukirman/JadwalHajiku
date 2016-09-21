package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.irfanirawansukirman.jadwalhajiku.R;

/**
 * Created by irfan on 21/09/16.
 */
public class HajjScheduleDialogFragment extends DialogFragment {
    public static HajjScheduleDialogFragment newInstance() {

        Bundle args = new Bundle();

        HajjScheduleDialogFragment fragment = new HajjScheduleDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public HajjScheduleDialogFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hajj_schedule_dialog_fragment, container, false);
        Button mBtnClose = (Button) v.findViewById(R.id.btn_dialog_close);
        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HajjScheduleDialogFragment.this.dismiss();
            }
        });
        return v;
    }

    @Override
    public void onResume() {
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        super.onResume();
    }
}
