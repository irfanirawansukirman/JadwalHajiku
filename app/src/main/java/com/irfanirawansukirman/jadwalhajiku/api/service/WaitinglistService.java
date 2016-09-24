package com.irfanirawansukirman.jadwalhajiku.api.service;

import com.irfanirawansukirman.jadwalhajiku.api.dao.WaitinglistDao;
import com.irfanirawansukirman.jadwalhajiku.base.BaseDao;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by irfan on 23/09/16.
 */

public interface WaitinglistService {
    @GET("/api/info-haji")
    Observable<WaitinglistDao> getWaitingList(
            @Query("view") String mView,
            @Query("k") String mKey
    );
}
