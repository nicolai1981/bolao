package br.com.itocorp.android.meubolao.model;

import android.content.Context;
import android.util.Log;

public class AppModel {
    private static final boolean DEBUG = true;

    private static AppModel sInstance;
    private Context mContext;

    public static final void init(Context context) {
        sInstance = new AppModel(context);
    }

    public static final AppModel getInstance() {
        return sInstance;
    }

    private AppModel(Context context) {
        mContext = context;
    }

    public static final void Log(String msg) {
        if (DEBUG) {
            Log.e("BetApp", msg);
        }
    }
}
