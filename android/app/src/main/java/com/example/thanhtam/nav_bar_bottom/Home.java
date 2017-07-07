package com.example.thanhtam.nav_bar_bottom;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.cboy.rn.splashscreen.SplashScreen;
import com.example.thanhtam.nav_bar_bottom.views.fragments.Customers;
import com.example.thanhtam.nav_bar_bottom.views.fragments.Management;
import com.example.thanhtam.nav_bar_bottom.views.fragments.Promotion;
import com.example.thanhtam.nav_bar_bottom.views.fragments.Receipt;
import com.example.thanhtam.nav_bar_bottom.views.fragments.Summary;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class Home extends BaseActivity
        implements DefaultHardwareBackBtnHandler {

    /*
    * Get the ReactInstanceManager, AKA the bridge between JS and Android
    * We use a singleton here so we can reuse the instance throughout our app
    * instead of constantly re-instantiating and re-downloading the bundle
    */
    private ReactInstanceManager mReactInstanceManager;
    private ViewHolder viewHolder;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.receit:
                    Fragment receiptFragment = new Receipt();
                    getFragmentManager().beginTransaction()
                            .add(R.id.content, receiptFragment).commit();
                    return true;
                case R.id.promotion:
                    Fragment promotionFragment = new Promotion();
                    getFragmentManager().beginTransaction()
                            .add(R.id.content, promotionFragment).commit();
                    return true;
                case R.id.cutomers:
                    Fragment customersFragment = new Customers();
                    getFragmentManager().beginTransaction()
                            .add(R.id.content, customersFragment).commit();
                    return true;
                case R.id.summary:
                    Fragment summaryFragment = new Summary();
                    getFragmentManager().beginTransaction()
                            .add(R.id.content, summaryFragment).commit();
                    return true;
                case R.id.management:
                    Fragment managementFragment = new Management();
                    getFragmentManager().beginTransaction()
                            .add(R.id.content, managementFragment).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViews();
        initViews();
    }

    private void initViews() {
        createHomeFragment();
        viewHolder.content = (FrameLayout) findViewById(R.id.content);
        viewHolder.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void createHomeFragment() {
        /*This function is used on first start up,
        for some reason it takes a couple of second for react to load into a fragment,
        we would not want users thinking that they're experiencing bugs*/
        SplashScreen.show((Activity) Home.this);
        Fragment receiptFragment = new Receipt();
        getFragmentManager().beginTransaction()
                .add(R.id.content, receiptFragment).commit();
    }

    private void findViews() {
        viewHolder = new ViewHolder();
        mReactInstanceManager =
                ((BaseApplication) getApplication()).getReactNativeHost().getReactInstanceManager();
        viewHolder.navigation = (BottomNavigationView) findViewById(R.id.navigation);
    }

    private class ViewHolder {
        private FrameLayout content;
        private BottomNavigationView navigation;
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    /*
     * Any activity that uses the ReactFragment or ReactActivty
     * Needs to call onHostPause() on the ReactInstanceManager
     */
    @Override
    protected void onPause() {
        super.onPause();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostPause(this);
        }
    }

    /*
     * Same as onPause - need to call onHostResume
     * on our ReactInstanceManager
     */
    @Override
    protected void onResume() {
        super.onResume();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostResume(this, this);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mReactInstanceManager != null) {
            mReactInstanceManager.onHostDestroy(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }
}
