package com.example.thanhtam.nav_bar_bottom.views.fragments;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.thanhtam.nav_bar_bottom.BaseApplication;
import com.facebook.react.BuildConfig;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.File;

import static android.content.ContentValues.TAG;

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
//        mReactRootView = new ReactRootView(context);
//        mReactInstanceManager =
//                ((BaseApplication) getActivity().getApplication())
//                        .getReactNativeHost()
//                        .getReactInstanceManager();

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

//         if (mReactRootView == null) {
//             mReactRootView = new ReactRootView(((BaseApplication) getActivity().getApplication()).getBaseContext());
//         }
//         if (mReactRootView == null) {
//             Log.d("ReactBaseFragment", "ReactRootView: null");
//         }
//         mReactInstanceManager =
//                 ((BaseApplication) getActivity().getApplication())
//                         .getReactNativeHost()
//                         .getReactInstanceManager();
//
//         if (mReactInstanceManager == null) {
//             Log.d("ReactBaseFragment", "ReactInstanceManager: null");
//         }
         mReactRootView.startReactApplication(
                 mReactInstanceManager,
                 getMainComponentName(),
                 null
         );
//         findViews();
//       try {
//           mReactRootView.startReactApplication(
//                   mReactInstanceManager,
//                   getMainComponentName(),
//                   null
//           );
//           findViews();
//       } catch (Exception e) {
//           Log.d("mReactRootView", "onActivityCreated: Cannot start react application");
//       }
    }

    private void findViews() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (!Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                        Uri.parse("package:" + getPackageName()));
//                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
//            }
            //cry
        }
    }
}