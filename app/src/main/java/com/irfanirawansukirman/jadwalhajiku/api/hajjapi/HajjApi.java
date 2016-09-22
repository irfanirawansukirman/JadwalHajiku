package com.irfanirawansukirman.jadwalhajiku.api.hajjapi;

import com.irfanirawansukirman.jadwalhajiku.api.service.PerkiraanBerangkatService;
import com.irfanirawansukirman.jadwalhajiku.util.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by irfan on 22/09/16.
 */

public class HajjApi {
    private Retrofit mRetrofit;
    private PerkiraanBerangkatService mPerkiraanBerangkatService;

    public HajjApi(){
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(Constant.BASE_URL)
                .build();

    }

    public PerkiraanBerangkatService getPerkiraanBerangkatService(){
        mPerkiraanBerangkatService = mRetrofit.create(PerkiraanBerangkatService.class);
        return mPerkiraanBerangkatService;
    }
}
