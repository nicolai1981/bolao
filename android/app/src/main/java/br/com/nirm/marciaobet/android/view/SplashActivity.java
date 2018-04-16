package br.com.nirm.marciaobet.android.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.nirm.marciaobet.android.R;
import br.com.nirm.marciaobet.android.model.AppModel;
import br.com.nirm.marciaobet.android.viewmodel.AppVM;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initEnv();
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_translate);
        AppVM.getInstance().afterSplashScreen();
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.activity_open_translate,R.anim.activity_close_translate);
    }

    private void initEnv() {
        Context context = getApplicationContext();
        AppVM.init(context);
        AppModel.init(context);
    }
}
