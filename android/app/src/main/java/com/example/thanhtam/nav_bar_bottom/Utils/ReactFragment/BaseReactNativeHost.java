package com.example.thanhtam.nav_bar_bottom.Utils.ReactFragment;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.koushikdutta.ion.Ion;

import java.io.File;

/**
 * Created by thanhtam on 05/07/2017.
 */

public abstract class BaseReactNativeHost extends ReactNativeHost {

    private Context context = null;
    private String MainComponentName = null;
    private String BundleFilePath = "/sdcard/index.android.bundle";
    private String JSMainModuleName = "index.android";
    private String ReactBundleUrl = "";
    private ReactInstanceManagerBuilder mReactInstanceManagerBuilder;

    public String getMainComponentName() {
        return MainComponentName;
    }

    public void setMainComponentName(String mainComponentName) {
        MainComponentName = mainComponentName;
    }

    public String getBundleFilePath() {
        return BundleFilePath;
    }

    public void setBundleFilePath(String bundleFilePath) {
        BundleFilePath = bundleFilePath;
    }

    @Override
    public String getJSMainModuleName() {
        return JSMainModuleName;
    }

    public void setJSMainModuleName(String JSMainModuleName) {
        this.JSMainModuleName = JSMainModuleName;
    }

    public String getReactBundleUrl() {
        return ReactBundleUrl;
    }

    public void setReactBundleUrl(String reactBundleUrl) {
        ReactBundleUrl = reactBundleUrl;
    }

    protected BaseReactNativeHost(Application application) {
        super(application);
    }

    protected BaseReactNativeHost(Application application, Context context, String ReactBundleUrl) {
        super(application);
        this.context = context;
        this.ReactBundleUrl = ReactBundleUrl;
    }

    @Override
    protected ReactInstanceManager createReactInstanceManager() {
        if (BundleFilePath == null ||ReactBundleUrl == null || context == null) {
            context = getApplication().getApplicationContext();
//            return null;
        }
        try {
            final Context fcontext = context;
            Ion.with(fcontext)
                    .load(getReactBundleUrl())
                    .write(new File(getBundleFilePath()));

            mReactInstanceManagerBuilder = ReactInstanceManager.builder()
                    .setApplication(getApplication())
                    .setJSBundleFile(getBundleFilePath())
                    .setJSMainModuleName(getJSMainModuleName())
                    .setUseDeveloperSupport(getUseDeveloperSupport())
                    .setInitialLifecycleState(LifecycleState.RESUMED);

            for (ReactPackage reactPackage : getPackages()) {
                mReactInstanceManagerBuilder.addPackage(reactPackage);
            }
            return mReactInstanceManagerBuilder.build();
        } catch (NullPointerException e) {
            Log.d("ReactInstanceManager", "createReactInstanceManager: Null pointer while create react instace manager");
            return null;
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
