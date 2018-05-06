package br.com.itocorp.android.meubolao.model;

import android.app.Application;

import static br.com.itocorp.android.meubolao.model.AppModel.Log;

public class BetApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        Log("App:Init");
        AppModel.init(getApplicationContext());
    }
}
