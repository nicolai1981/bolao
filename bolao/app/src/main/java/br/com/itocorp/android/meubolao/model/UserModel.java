package br.com.itocorp.android.meubolao.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class UserModel {

    public static class User extends BaseObservable {
        private String mName;
        private String mPhotoUrl;

        @Bindable
        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        @Bindable
        public String getPhotoUrl() {
            return mPhotoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            mPhotoUrl = photoUrl;
        }
    }
}
