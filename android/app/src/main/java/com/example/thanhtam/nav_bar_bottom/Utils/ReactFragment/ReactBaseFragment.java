package com.example.thanhtam.nav_bar_bottom.Utils.ReactFragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cboy.rn.splashscreen.SplashScreen;
import com.example.thanhtam.nav_bar_bottom.BaseApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

/**
 * Created by thanhtam on 05/07/2017.
 */

public abstract class ReactBaseFragment  extends Fragment {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    // This method returns the name of our top-level component to show
    public abstract String getMainComponentName();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public ReactRootView onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SplashScreen.show(getActivity());  // Uncomment this if you want every fragment to show loading screen
        //Create ReactRootView the magic component
        mReactRootView = new ReactRootView(((BaseApplication) getActivity().getApplication())
                .getApplicationContext());
        mReactInstanceManager =
                ((BaseApplication) getActivity().getApplication())
                        .getReactNativeHost()
                        .getReactInstanceManager();
        return mReactRootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       try {
           mReactRootView.startReactApplication(
                   mReactInstanceManager,
                   getMainComponentName(),
                   null
           );
           findViews();
       } catch (NullPointerException e) {
           Log.d("ReactBaseFragment", "ReactRootView or ReactInstanceManager is null");
       }
    }

    private void findViews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                        Uri.parse("package:" + getPackageName()));
//                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
//            }
            Log.d("ReactBaseFragment", "Version M");
        }
    }
}