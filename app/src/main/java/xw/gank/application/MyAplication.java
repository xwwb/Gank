package xw.gank.application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class MyAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
//        SkinCompatManager.withoutActivity(this).addInflater(new SkinMaterialViewInflater())
//               // ConstraintLayout控件换肤初始化[选选]
//                // CardView v7控件换肤初始化[任选]
//            .setSkinStatusBarColorEnable(false)                  //关闭状态栏换肤，默认打开[可选]
//            .setSkinWindowBackgroundEnable(false)                  //关闭windowBackground换肤，默认打开[任选]
//            .loadSkin();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
//        //播放器日志
//        L.setDebug(BuildConfig.DEBUG);
    }
}
