package com.irfanirawansukirman.jadwalhajiku.base;

/**
 * Created by irfan on 22/09/16.
 */

public class BaseDao<T> {
    public String status;
    public T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
