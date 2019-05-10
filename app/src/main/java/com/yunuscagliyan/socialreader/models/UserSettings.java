package com.yunuscagliyan.socialreader.models;


import android.util.Log;

import static android.support.constraint.Constraints.TAG;

public class UserSettings {

    private User user;
    private UserAccountSettings settings;

    public UserSettings(User user, UserAccountSettings settings) {

        this.user = user;
        this.settings = settings;
        Log.d(TAG, "qqqqqqqqqqqqqqqqqq");
    }

    public UserSettings() {

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserAccountSettings getSettings() {
        return settings;
    }

    public void setSettings(UserAccountSettings settings) {
        this.settings = settings;
    }

    @Override
    public String toString() {
        return "UserSettings{" +
                "user=" + user +
                ", settings=" + settings +
                '}';
    }
}
