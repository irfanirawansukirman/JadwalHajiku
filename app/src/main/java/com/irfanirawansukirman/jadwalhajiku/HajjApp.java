package com.irfanirawansukirman.jadwalhajiku;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.irfanirawansukirman.jadwalhajiku.api.hajjapi.HajjApi;


/**
 * Created by Dezan on 17/05/2016.
 *
 */
public class HajjApp extends Application {
    public static Gson GSON = new Gson();
    static HajjApi mHajjApi = new HajjApi();

    @Override
    public void onCreate() {
        super.onCreate();

        GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    public static HajjApi getApi() {
        return mHajjApi;
    }
}
