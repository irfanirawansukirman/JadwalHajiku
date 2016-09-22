package com.irfanirawansukirman.jadwalhajiku.api.core;

/**
 * Created by Dezan on 17/05/2016.
 *
 */
public interface ApiCallback<T> {
    void onApiSuccess(T result, String rawJson);
    void onApiError(String errorMessage);
}
