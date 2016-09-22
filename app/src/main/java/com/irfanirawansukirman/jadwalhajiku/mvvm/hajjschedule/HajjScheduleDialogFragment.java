package com.irfanirawansukirman.jadwalhajiku.mvvm.hajjschedule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.irfanirawansukirman.jadwalhajiku.HajjApp;
import com.irfanirawansukirman.jadwalhajiku.R;
import com.irfanirawansukirman.jadwalhajiku.api.core.Observers;
import com.irfanirawansukirman.jadwalhajiku.api.dao.PerkiraanBerangkatDao;
import com.irfanirawansukirman.jadwalhajiku.api.event.PerkiraanBerangkatEvent;
import com.irfanirawansukirman.jadwalhajiku.api.repository.PerkiraanBerangkatRepository;
import com.irfanirawansukirman.jadwalhajiku.base.BaseDao;
import com.irfanirawansukirman.jadwalhajiku.util.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import id.gits.baso.BasoProgressView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by irfan on 21/09/16.
 */
public class HajjScheduleDialogFragment extends DialogFragment {
    private List<Subscription> subscriptions = new ArrayList<>();

    BasoProgressView mProgress;
    Button mBtnClose;
    ScrollView mScrollItemm;
    TextView mNomorPorsiCalon, mNama, mKabKota, mProvinsi, mKuotaProvKabKotKhus, mPorsi, mTahunHijriyah, mTahunMasehi;

    public static HajjScheduleDialogFragment newInstance(String nomor_porsi) {

        Bundle args = new Bundle();

        HajjScheduleDialogFragment fragment = new HajjScheduleDialogFragment();
        args.putString("nomor_porsi", nomor_porsi);
        Log.e("nomor porsi ", nomor_porsi);
        fragment.setArguments(args);
        return fragment;
    }

    public HajjScheduleDialogFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hajj_schedule_dialog_fragment, container, false);
        mBtnClose = (Button) v.findViewById(R.id.btn_dialog_close);
        mScrollItemm = (ScrollView) v.findViewById(R.id.scrollItem);
        mNomorPorsiCalon = (TextView) v.findViewById(R.id.txt_nomor_porsi);
        mNama = (TextView) v.findViewById(R.id.txt_nama);
        mKabKota = (TextView) v.findViewById(R.id.txt_kab_kota);
        mProvinsi = (TextView) v.findViewById(R.id.txt_provinsi);
        mKuotaProvKabKotKhus = (TextView) v.findViewById(R.id.txt_kuota);
        mPorsi = (TextView) v.findViewById(R.id.txt_posisi);
        mTahunHijriyah = (TextView) v.findViewById(R.id.txt_hijriyah);
        mTahunMasehi = (TextView) v.findViewById(R.id.txt_masehi);
        mProgress = (BasoProgressView) v.findViewById(R.id.myprogress);

        mBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HajjScheduleDialogFragment.this.dismiss();
            }
        });

        String nomor_porsi = getArguments().getString("nomor_porsi");
        getDataPerkiraan(nomor_porsi);
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


    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void finishSubscriber() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }

    public void getDataPerkiraan(final String mNomorPorsi) {
        startProgress();
        PerkiraanBerangkatRepository mPerkiraanBerangkatRepository = new PerkiraanBerangkatRepository(HajjApp.getApi());
        addSubscription(mPerkiraanBerangkatRepository.getDataKeberangkatan(
                "keberangkatan",
                mNomorPorsi,
                Constant.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observers<BaseDao<PerkiraanBerangkatDao>>() {
                    @Override
                    public void onApiResultCompleted() {

                    }

                    @Override
                    public void onApiResultError(String message) {
                        Log.e("DUH ERROR ", message);
                        stopProgressAndError("Terjadi kesalahan.\nMohon periksa kembali koneksi jaringan internet anda.", mNomorPorsi);
                    }

                    @Override
                    public void onApiResultOk(BaseDao<PerkiraanBerangkatDao> mData) {
                        Log.wtf("NAMA CALON HAJI ", mData.getData().getNama());
                        if (mData.getData() != null) {
                            mNomorPorsiCalon.setText(": " + mData.getData().getNomor_porsi());
                            mNama.setText(": " + mData.getData().getNama());
                            mKabKota.setText(": " + mData.getData().getKabupaten_kota());
                            mProvinsi.setText(": " + mData.getData().getProvinsi());
                            mKuotaProvKabKotKhus.setText(": " + mData.getData().getKuota_provinsi_kab_kota_khusus());
                            mPorsi.setText(": " + mData.getData().getPosisi_porsi_pada_kuota_provinsi_kab_kota_khusus());
                            mTahunHijriyah.setText(": " + mData.getData().getPerkiraan_berangkat_hijriah());
                            mTahunMasehi.setText(": " + mData.getData().getPerkiraan_berangkat_tahun_masehi());
                            stopProgress();
                        }
                    }
                }));
    }

    public void startProgress() {
        mScrollItemm.setVisibility(View.GONE);
        mProgress.startProgress();
    }

    public void stopProgress() {
        mProgress.stopAndGone();
        mScrollItemm.setVisibility(View.VISIBLE);
    }

    public void stopProgressAndError(String mMessage, final String nomor_porsi) {
        mProgress.stopAndError(mMessage, true);
        mProgress.setOnRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataPerkiraan(nomor_porsi);
            }
        });
    }
}
