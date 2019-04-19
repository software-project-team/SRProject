package com.yunuscagliyan.socialreader.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.yunuscagliyan.socialreader.R;
import com.yunuscagliyan.socialreader.Utils.BottomNavigationViewHelper;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private final Context mContext=ProfileActivity.this;
    private static final int ACTIVITY_NUMBER=4;

    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG,"onCreate:started");
        mProgressBar=findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        setupBottomNavigationView();
        setupToolbar();
    }


    public void setupToolbar(){
        Toolbar mToolbar=findViewById(R.id.profileToolBar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        ImageView profileMenu=findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: navigating to AccountSettingActivity");
                Intent intent=new Intent(mContext,AccountSettingActivity.class);
                startActivity(intent);
            }
        });
    }
    /**
     * BottomNavigationView set up
     */
    private void setupBottomNavigationView(){
        Log.d(TAG,"setupBottomNavigationView:setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavViewBar=findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(mContext,bottomNavViewBar);

        Menu menu=bottomNavViewBar.getMenu();
        MenuItem menuItem=menu.getItem(ACTIVITY_NUMBER);
        menuItem.setChecked(true);

    }
}
