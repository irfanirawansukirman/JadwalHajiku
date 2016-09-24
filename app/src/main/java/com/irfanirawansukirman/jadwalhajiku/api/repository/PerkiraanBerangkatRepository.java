package com.irfanirawansukirman.jadwalhajiku.api.repository;

import com.irfanirawansukirman.jadwalhajiku.api.dao.PerkiraanBerangkatDao;
import com.irfanirawansukirman.jadwalhajiku.api.hajjapi.HajjApi;
import com.irfanirawansukirman.jadwalhajiku.base.BaseDao;

import rx.Observable;

/**
 * Created by irfan on 22/09/16.
 */

public class PerkiraanBerangkatRepository {
    private HajjApi mHajjApi;

    public PerkiraanBerangkatRepository(HajjApi mHajjApi) {
        this.mHajjApi = mHajjApi;
    }

    public Observable<PerkiraanBerangkatDao> getDataKeberangkatan(String mView,
                                                                           String mNomorPorsi,
                                                                           String mToken) {
        return mHajjApi.getPerkiraanBerangkatService().getDataPerkiraan(mView, mNomorPorsi, mToken);
    }
}
