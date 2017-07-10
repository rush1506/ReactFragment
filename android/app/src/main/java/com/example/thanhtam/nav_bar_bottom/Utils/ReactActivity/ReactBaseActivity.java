package com.example.thanhtam.nav_bar_bottom.Utils.ReactActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.thanhtam.nav_bar_bottom.BaseActivity;
import com.example.thanhtam.nav_bar_bottom.BaseApplicationFragment;
import com.example.thanhtam.nav_bar_bottom.BuildConfig;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import java.util.List;

import static com.microsoft.codepush.react.CodePush.getJSBundleFile;

/**
 * Created by thanhtam on 10/07/2017.
 */

public abstract class ReactBaseActivity extends BaseActivity
        implements DefaultHardwareBackBtnHandler {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    // This method returns the name of our top-level component to show
    public abstract String getMainComponentName();
    public abstract Bundle getInitialBundle();
    public abstract List<ReactPackage> getPackages();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        ReactInstanceManagerBuilder builder = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName(getBundleAssetName())
                .setJSMainModuleName(getJSMainModuleName())
                .setUseDeveloperSupport(getUseDeveloperSupport())
                .setInitialLifecycleState(LifecycleState.RESUMED);

        for (ReactPackage reactPackage : getPackages()) {
            builder.addPackage(reactPackage);
        }

        String jsBundleFile = getJSBundleFile();
        if (jsBundleFile != null) {
            builder.setJSBundleFile(jsBundleFile);
        } else {
            Log.d("ReactBaseActivity", "Cannot get bundle with codepush");
        }
        mReactInstanceManager = builder.build();
        mReactRootView.startReactApplication(mReactInstanceManager, getMainComponentName(), getInitialBundle());

        setContentView(mReactRootView);
    }

    public String getJSMainModuleName() {
        return "index.android";
    }

    public boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    public String getBundleAssetName() {
        return "index.android.bundle";
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }
}
