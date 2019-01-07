package com.xw.library.utils.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Objects;

/**
 * Created by Administrator on 2015/12/28.
 * <p/>
 * 获取版本号的工具
 */
public class GetVersionUtils {
    /**
     * 获取版本名
     */
    public static String getVersionName(Context context) {
        return Objects.requireNonNull(getPackageInfo(context)).versionName;
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode(Context context) {
        return Objects.requireNonNull(getPackageInfo(context)).versionCode;
    }


    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
