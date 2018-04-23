package br.com.nirm.marciaobet.android.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import java.util.ArrayList;
import java.util.List;

import br.com.nirm.marciaobet.android.BR;

public class UserModel {
    public static class User extends BaseObservable {
        private String mName;
        private String mPhotoURL;
        private ObservableArrayList<BetModel.Bet> mBetList;

        public User(String name, String photo) {
            mName = name;
            mPhotoURL = photo;
            mBetList = new ObservableArrayList<>();
        }

        @Bindable
        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getPhotoURL() {
            return mPhotoURL;
        }

        public void setPhotoURL(String photoURL) {
            mPhotoURL = photoURL;
            notifyPropertyChanged(BR.photoURL);
        }

        @Bindable
        public ObservableArrayList<BetModel.Bet> getBetList() {
            return mBetList;
        }

        public void addBet(BetModel.Bet bet) {
            mBetList.add(bet);
            notifyPropertyChanged(BR.betList);
        }
    }
}
