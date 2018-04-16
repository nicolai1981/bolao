package br.com.nirm.marciaobet.android.viewmodel;

import android.content.Context;
import android.content.Intent;

import br.com.nirm.marciaobet.android.model.AppModel;
import br.com.nirm.marciaobet.android.view.LoginActivity;
import br.com.nirm.marciaobet.android.view.MainActivity;

/**
 * Created by vntnait on 02/04/2018.
 */

public class AppVM {
    private static AppVM sInstance;
    private Context mContext;

    public static final void init(Context context) {
        sInstance = new AppVM(context);
    }

    public static final AppVM getInstance() {
        return sInstance;
    }

    private AppVM(Context context) {
        mContext = context;
    }

    public void afterSplashScreen() {
        Intent intent;
        if (AppModel.getInstance().isLogged()) {
            intent = new Intent(mContext, MainActivity.class);
        } else {
            intent = new Intent(mContext, LoginActivity.class);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public void afterLoginScreen() {
        AppModel model = AppModel.getInstance();
        model.setFBToken("fhdsjkafhlas");

        Intent intent = new Intent(mContext, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public void logout() {
        AppModel model = AppModel.getInstance();
        model.setFBToken(null);
        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }
}
