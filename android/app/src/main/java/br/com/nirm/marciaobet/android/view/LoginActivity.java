package br.com.nirm.marciaobet.android.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.nirm.marciaobet.android.R;
import br.com.nirm.marciaobet.android.viewmodel.AppVM;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginAction(View view) {
        AppVM.getInstance().afterLoginScreen();
    }
}
