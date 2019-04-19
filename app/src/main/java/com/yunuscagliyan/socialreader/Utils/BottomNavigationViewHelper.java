package com.yunuscagliyan.socialreader.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.yunuscagliyan.socialreader.Home.HomeActivity;
import com.yunuscagliyan.socialreader.Likes.LikesActivity;
import com.yunuscagliyan.socialreader.Profile.ProfileActivity;
import com.yunuscagliyan.socialreader.R;
import com.yunuscagliyan.socialreader.Search.SearchActivity;
import com.yunuscagliyan.socialreader.Share.ShareActivity;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavBarViewEx){
        Log.d(TAG,"setupBottomNavigationView:Setting up BottomNavigationView");
        bottomNavBarViewEx.enableAnimation(false);
        bottomNavBarViewEx.enableItemShiftingMode(false);
        bottomNavBarViewEx.enableShiftingMode(false);
        bottomNavBarViewEx.setTextVisibility(false);
    }
    public static void enableNavigation(final Context context,BottomNavigationViewEx viewEx){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_house:
                        Intent intent1=new Intent(context, HomeActivity.class);//ACTIVITY_NUMBER=0
                        context.startActivity(intent1);

                        break;
                    case R.id.ic_search:
                        Intent intent2=new Intent(context, SearchActivity.class);//ACTIVITY_NUMBER=1
                        context.startActivity(intent2);

                        break;
                    case R.id.ic_circle:
                        Intent intent3=new Intent(context, ShareActivity.class);//ACTIVITY_NUMBER=2
                        context.startActivity(intent3);

                        break;

                    case R.id.ic_alert:
                        Intent intent4=new Intent(context, LikesActivity.class);//ACTIVITY_NUMBER=3
                        context.startActivity(intent4);

                        break;
                    case R.id.ic_android:
                        Intent intent5=new Intent(context, ProfileActivity.class);//ACTIVITY_NUMBER=4
                        context.startActivity(intent5);

                        break;
                }
                return false;
            }
        });
    }
}
