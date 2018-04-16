package br.com.nirm.marciaobet.android.model;

import android.content.Context;

/**
 * Created by vntnait on 02/04/2018.
 */

public class AppModel {
    private static AppModel sInstance;
    private String mFBToken;
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

    public void setFBToken(String token) {
        mFBToken = token;
    }

    public String getFBToken() {
        return mFBToken;
    }

    public boolean isLogged() {
        return mFBToken != null;
    }

    public void logout() {
        mFBToken = null;
    }
}
