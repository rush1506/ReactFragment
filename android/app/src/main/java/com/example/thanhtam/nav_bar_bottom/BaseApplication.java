package com.example.thanhtam.nav_bar_bottom;

import android.app.Application;
import android.content.Context;

import com.example.thanhtam.nav_bar_bottom.Utils.ReactFragment.BaseReactNativeHost;
import com.example.thanhtam.nav_bar_bottom.Utils.ReactFragment.ReactBaseApplication;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by thanhtam on 05/07/2017.
 */

public class BaseApplication extends Application implements ReactBaseApplication {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        BaseApplication.context = getApplicationContext();
        mBaseReactNativeHost = new BaseReactNativeHost(this, context, url) {
            @Override
            public boolean getUseDeveloperSupport() {
                return BuildConfig.DEBUG;
            }

            @Override
            public List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                        new MainReactPackage()
                );
            }
        };
    }

    public static Context getAppContext() {
        return BaseApplication.context;
    }
//    private Context context = getApplicationContext();
    private String url = "https://drive.google.com/uc?export=download&id=0Bzu2ulcPXMYmallzTjFqV0VvcUk";
    private BaseReactNativeHost mBaseReactNativeHost = null;
    @Override
    public BaseReactNativeHost getBaseReactNativeHost() {
        return mBaseReactNativeHost;
    }
}
