package com.irfanirawansukirman.jadwalhajiku.api.service;

import com.irfanirawansukirman.jadwalhajiku.api.dao.PerkiraanBerangkatDao;
import com.irfanirawansukirman.jadwalhajiku.base.BaseDao;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by irfan on 22/09/16.
 */

public interface PerkiraanBerangkatService {
    @GET("/api/info-haji")
    Observable<PerkiraanBerangkatDao> getDataPerkiraan(
            @Query("view") String mView,
            @Query("np") String mNomorPorsi,
            @Query("k") String token
    );
}
