package com.example.thanhtam.nav_bar_bottom;

import android.app.Application;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactInstanceManagerBuilder;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.microsoft.codepush.react.CodePush;

import java.util.Arrays;
import java.util.List;

/**
 * Created by thanhtam on 10/07/2017.
 */

public class BaseApplicationActivityDeprecated extends Application implements ReactApplication {


    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

        @Override
        protected String getJSBundleFile() {
            return CodePush.getJSBundleFile();
        }

        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
            return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new CodePush("iJrB6zqAXoDvSoaRB63FL2ITyqHsa0a54359-d62b-4e63-92bc-c307f1c17628"
                            , getApplicationContext(), BuildConfig.DEBUG)
            );
        }


        @Override
        protected ReactInstanceManager createReactInstanceManager() {
            ReactInstanceManagerBuilder builder = ReactInstanceManager.builder()
                    .setApplication(getApplication())
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
                Log.d("Deprecated", "Cannot get bundle with codepush");
            }
            return builder.build();
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
    }
}
