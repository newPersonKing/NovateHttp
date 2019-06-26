package com.temp.nohttpmodel;

import android.app.Application;

import com.temp.nohttpmodel.http.HttpRequestUtils;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpRequestUtils.init(this);
    }
}
