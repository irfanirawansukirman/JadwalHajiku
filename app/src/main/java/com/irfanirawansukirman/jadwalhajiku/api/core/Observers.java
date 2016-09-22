package com.irfanirawansukirman.jadwalhajiku.api.core;

import rx.Observer;

/**
 * Created by Dezan on 18/05/2016.
 *
 */

public abstract class Observers<T> implements Observer<T> {

    @Override
    public final void onCompleted() {
        onApiResultCompleted();
    }

    @Override
    public final void onError(Throwable e) {
        onApiResultError(e.getMessage());
        onApiResultCompleted();
    }

    @Override
    public final void onNext(T t) {
        onApiResultOk(t);
    }

    public abstract void onApiResultCompleted();

    public abstract void onApiResultError(String message);

    public abstract void onApiResultOk(T t);
}