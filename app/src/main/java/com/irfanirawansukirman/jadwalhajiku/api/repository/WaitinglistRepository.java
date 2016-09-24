package com.irfanirawansukirman.jadwalhajiku.api.repository;

import com.irfanirawansukirman.jadwalhajiku.api.dao.WaitinglistDao;
import com.irfanirawansukirman.jadwalhajiku.api.hajjapi.HajjApi;

import rx.Observable;

/**
 * Created by irfan on 23/09/16.
 */

public class WaitinglistRepository {
    private HajjApi mHajjApi;

    public WaitinglistRepository(HajjApi mHajjApi) {
        this.mHajjApi = mHajjApi;
    }

    public Observable<WaitinglistDao> getDataWaitinglist(String mView,
                                                         String mKey){
        return mHajjApi.getWaitinglistService().getWaitingList(mView, mKey);
    }
}
