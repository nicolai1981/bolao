package br.com.itocorp.android.meubolao.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.com.itocorp.android.meubolao.R;
import br.com.itocorp.android.meubolao.model.UserModel;
import br.com.itocorp.android.meubolao.view.LoginActivity;
import br.com.itocorp.android.meubolao.view.MainActivity;

import static br.com.itocorp.android.meubolao.model.AppModel.Log;

public class AppVM {
    private FirebaseAuth mAuth;
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
        mAuth = FirebaseAuth.getInstance();
    }

    public void loginSuccess(LoginResult loginResult, Activity activity) {
        AuthCredential credential = FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken());
        mAuth.signInWithCredential(credential)
             .addOnCompleteListener(activity, (@NonNull Task<AuthResult> task) -> {
                 if (task.isSuccessful()) {
                     Log("SignInWithCredential:success");
                     FirebaseUser user = mAuth.getCurrentUser();
                     Log("User: " + user.getDisplayName()
                       + "\nEmail: " + user.getEmail()
                     );

                     Intent intent = new Intent(mContext, MainActivity.class);
                     intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                     mContext.startActivity(intent);

                     Toast.makeText(mContext,
                                    mContext.getResources().getText(R.string.login_welcome) + user.getDisplayName(),
                                    Toast.LENGTH_LONG).show();

                 } else {
                     Log("SignInWithCredential:failure " + task.getException());
                 }
             });
    }

    public void afterSplashScreen() {
        Intent intent;
        if (mAuth.getCurrentUser() == null) {
            intent = new Intent(mContext, LoginActivity.class);
        } else {
            intent = new Intent(mContext, MainActivity.class);
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public void logout() {
        LoginManager.getInstance().logOut();
        mAuth.signOut();

        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public UserModel.User getUser() {
        UserModel.User user = new UserModel.User();
        FirebaseUser fbUser = mAuth.getCurrentUser();
        if (fbUser != null) {
            user.setName(fbUser.getDisplayName());
            user.setPhotoUrl(fbUser.getPhotoUrl().toString());
        }
        return user;
    }
}
