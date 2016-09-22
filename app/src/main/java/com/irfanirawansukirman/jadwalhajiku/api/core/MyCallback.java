package com.irfanirawansukirman.jadwalhajiku.api.core;

import android.util.Log;

import com.irfanirawansukirman.jadwalhajiku.HajjApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dezan on 17/05/2016.
 */
public class MyCallback<T> implements Callback<T> {
    public ApiCallback<T> apiCallback;
    public static final String TAG = "API";

    public MyCallback(ApiCallback<T> apiCallback) {
        this.apiCallback = apiCallback;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body() == null) {
            apiCallback.onApiError("Internal Server Error");
            return;
        }
        apiCallback.onApiSuccess(response.body(), HajjApp.GSON.toJson(response.body()));
        Log.d(TAG, "API CALL: " + response.raw().request().url().toString());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        apiCallback.onApiError(t.getLocalizedMessage());
    }
}
