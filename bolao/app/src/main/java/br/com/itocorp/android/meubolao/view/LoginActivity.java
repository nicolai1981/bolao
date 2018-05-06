package br.com.itocorp.android.meubolao.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import br.com.itocorp.android.meubolao.R;
import br.com.itocorp.android.meubolao.viewmodel.AppVM;

import static br.com.itocorp.android.meubolao.model.AppModel.Log;

public class LoginActivity extends AppCompatActivity {
    private CallbackManager mCallbackManager;
    private LoginButton mFbButton;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCallbackManager = CallbackManager.Factory.create();

        mFbButton = findViewById(R.id.fb_button);
        mFbButton.setReadPermissions("public_profile");
        mFbButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log("onSuccess: " + loginResult.getAccessToken().getUserId());
                AppVM.getInstance().loginSuccess(loginResult, LoginActivity.this);
            }

            @Override
            public void onCancel() {
                Log("onCancel");
                mLoginButton.setEnabled(true);
            }

            @Override
            public void onError(FacebookException error) {
                Log("onError: " + error.toString());
                mLoginButton.setEnabled(true);
            }
        });

        mLoginButton = findViewById(R.id.login_button);
        mLoginButton.setOnClickListener((View view) -> {
            mLoginButton.setEnabled(false);
            mFbButton.performClick();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
