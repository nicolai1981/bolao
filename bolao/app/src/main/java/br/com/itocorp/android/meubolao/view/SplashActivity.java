package br.com.itocorp.android.meubolao.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.itocorp.android.meubolao.R;
import br.com.itocorp.android.meubolao.model.AppModel;
import br.com.itocorp.android.meubolao.viewmodel.AppVM;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppModel.init(getApplicationContext());

        AppVM.init(getApplicationContext());

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            AppVM.getInstance().afterSplashScreen();
        }, 3000);
    }
}
