package br.com.nirm.marciaobet.android.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.nirm.marciaobet.android.BR;

public class BetModel {
    private static final SimpleDateFormat sDateFormatter = new SimpleDateFormat("dd/MMM/YYYY HH:mm");

    public static class Bet extends BaseObservable {
        private String mPlace;
        private Date mDate;
        private Team mTeam1;
        private int mScore1 = 0;
        private int mBetScore1 = 0;
        private Team mTeam2;
        private int mScore2 = 0;
        private int mBetScore2 = 0;
        private int mPoint = 0;

        public Bet(String place) {
            mPlace = place;
        }

        @Bindable
        public String getDetails() {
            return mPlace + " - " + sDateFormatter.format(mDate);
        }

        public String getPlace() {
            return mPlace;
        }

        public void setPlace(String place) {
            mPlace = place;
            notifyPropertyChanged(BR.details);
        }

        public Date getDate() {
            return mDate;
        }

        public void setDate(Date date) {
            mDate = date;
            notifyPropertyChanged(BR.details);
        }

        @Bindable
        public Team getTeam1() {
            return mTeam1;
        }

        public void setTeam1(Team team1) {
            mTeam1 = team1;
            notifyPropertyChanged(BR.team1);
        }

        public int getScore1() {
            return mScore1;
        }

        @Bindable
        public String getScore1Text() {
            return String.format("(%d)", mScore1);
        }

        public void setScore1(int score1) {
            mScore1 = score1;
            notifyPropertyChanged(BR.score1Text);
        }

        @Bindable
        public int getBetScore1() {
            return mBetScore1;
        }

        public void setBetScore1(int betScore1) {
            mBetScore1 = betScore1;
            notifyPropertyChanged(BR.betScore1);
        }

        @Bindable
        public Team getTeam2() {
            return mTeam2;
        }

        public void setTeam2(Team team2) {
            mTeam2 = team2;
            notifyPropertyChanged(BR.team2);
        }

        @Bindable
        public String getScore2Text() {
            return String.format("(%d)", mScore2);
        }

        public void setScore2(int score2) {
            mScore2 = score2;
            notifyPropertyChanged(BR.score2Text);
        }

        @Bindable
        public int getBetScore2() {
            return mBetScore2;
        }

        public void setBetScore2(int betScore2) {
            mBetScore2 = betScore2;
            notifyPropertyChanged(BR.betScore2);
        }

        @Bindable
        public int getPoint() {
            return mPoint;
        }

        public void setPoint(int point) {
            mPoint = point;
            notifyPropertyChanged(BR.point);
        }
    }

    public static class Team extends BaseObservable {
        private String mName;
        private String mFlagURL;

        public Team(String name, String flag) {
            mName = name;
            mFlagURL = flag;
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
        public String getFlagURL() {
            return mFlagURL;
        }

        public void setFlagURL(String flagURL) {
            mFlagURL = flagURL;
            notifyPropertyChanged(BR.flagURL);
        }
    }
}
