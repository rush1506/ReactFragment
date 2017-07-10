package com.example.thanhtam.nav_bar_bottom.Utils.ReactFragment;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.thanhtam.nav_bar_bottom.BaseApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

/**
 * Created by thanhtam on 05/07/2017.
 */

public abstract class ReactDialogBaseFragment extends DialogFragment {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    // This method returns the name of our top-level component to show
    public abstract String getMainComponentName();
    public abstract Bundle getInitialBundle();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public ReactRootView onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                   getInitialBundle()
           );
           findViews();
       } catch (NullPointerException e) {
           Log.d("ReactBaseFragment", "mReactRootView or mReactInstanceManager is null");
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