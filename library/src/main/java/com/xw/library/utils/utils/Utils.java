package com.xw.library.utils.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.content.FileProvider;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class Utils {
    /*
    获取时间戳
    */
    public static String gettimeStamp(){

        return String.valueOf(System.currentTimeMillis()/1000);
    }
    /*
    判断字符串是否为空
     */
    public static boolean isEmpty(CharSequence string){
        return TextUtils.isEmpty(string);
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime_Today() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new java.util.Date());
    }
    public static String getCurrentTime_Today2() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new java.util.Date());
    }
    public static void makeStatusBarTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static boolean isAvilible(Context context, String packageName) {
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }

    /**
     *
     * @param context 上下文
     * @return
     */
    @SuppressWarnings("JavaDoc")

    public static boolean getCurrentNetWork(Context context) {
        boolean NET_STATUS = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activityNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        // Constant.isConnection = true;

        NET_STATUS = !(activityNetworkInfo == null || !activityNetworkInfo.isAvailable());
        return NET_STATUS;
    }

    /**
     * 判断网络情况
     *
     * @param context 上下文
     * @return false 表示没有网络 true 表示有网络
     */
    public static boolean isNetworkAvalible(Context context) {
        // 获得网络状态管理器
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            return false;
        } else {
            // 建立网络数组
            NetworkInfo[] net_info = connectivityManager.getAllNetworkInfo();

            if (net_info != null) {
                for (int i = 0; i < net_info.length; i++) {
                    // 判断获得的网络状态是否是处于连接状态
                    if (NetworkInfo.State.CONNECTED == net_info[i].getState()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 生成指定长度的随机字符串
     *
     * @param length 随机字符串长度
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String RandomStr(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 将字符串plainText换算成32为MD5
     *
     * @param plainText 要转换的字符串
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String encryption(String plainText) {
        String re_md5 = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuilder buf = new StringBuilder("");
            for (byte aB : b) {
                i = aB;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        re_md5 = re_md5.toUpperCase();
        return re_md5;
    }

    /**
     * 获取文件的MD5值
     *
     * @param file
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        String value = null;
        FileInputStream in = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
//            MappedByteBuffer byteBuffer = in.getChannel().map(
//                    FileChannel.MapMode.READ_ONLY, 0, file.length());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                md5.update(buffer, 0, length);
            }
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
//            byte[] b = md5.digest();
//            int i;
//            StringBuffer buf = new StringBuffer("");
//            for (int offset = 0; offset < b.length; offset++) {
//                i = b[offset];
//                if (i < 0)
//                    i += 256;
//                if (i < 16)
//                    buf.append("0");
//                buf.append(Integer.toHexString(i));
//            }
//            value = buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (value.length() < 32) {
            StringBuilder builder = new StringBuilder("");
            for (int i = 0; i < 32 - value.length(); i++) {
                builder.append("0");
            }
            value = builder.toString() + value;
        }
        return value.toUpperCase();
    }


    /**
     * 获取文件夹中文件的MD5值
     *
     * @param file      欲获取的文件
     * @param listChild ;true递归子目录中的文件
     * @return MD5数组
     */
    private static Map<String, String> getDirMD5(File file, boolean listChild) {
        if (!file.isDirectory()) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        String md5;
        File files[] = file.listFiles();
        for (File f : files) {
            if (f.isDirectory() && listChild) {
                map.putAll(getDirMD5(f, listChild));
            } else {
                md5 = getFileMD5(f);
                if (md5 != null) {
                    map.put(f.getPath(), md5);
                }
            }
        }
        return map;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 字符串转URLEncoded
     *
     * @param paramString
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String toURLEncoded(String paramString) {
        if (paramString == null || paramString.equals("")) {
            Log.d("URLEncode", "toURLEncoded error:" + paramString);
            return "";
        }

        try {
            String str = new String(paramString.getBytes(), "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        } catch (Exception localException) {
            Log.e("URLEncode", "toURLEncoded error:" + paramString,
                    localException);
        }

        return "";
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void setTitleStates(Activity cx) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = cx.getWindow();
            //透明状态栏
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            win.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            if (true) {
//                winParams.flags |= bits;
//            } else {
//                winParams.flags &= ~bits;
//            }
            winParams.flags |= bits;

            win.setAttributes(winParams);
        }
    }

    /**
     * 获取屏幕高度(px)
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 获取屏幕宽度(px)
     */
    public static int getScreenWidth(Context context) {

        return context.getResources().getDisplayMetrics().widthPixels;
    }


    public static String getPath(Activity cx, Uri uri) {
        return uri.getPath();
    }

    /**
     * 设置屏幕是否显示状态栏
     *
     * @param enable true为显示/false为不显示
     */
    public static void FullScreen(Activity cx, boolean enable) {
        if (enable) { //显示状态栏
            WindowManager.LayoutParams lp = cx.getWindow().getAttributes();
            lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            cx.getWindow().setAttributes(lp);
            cx.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        } else { //隐藏状态栏
            WindowManager.LayoutParams lp = cx.getWindow().getAttributes();
            lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            cx.getWindow().setAttributes(lp);
            cx.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Activity cx) {
        try {
            PackageManager manager = cx.getPackageManager();
            PackageInfo info = manager.getPackageInfo(cx.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getVersionCode(Activity cx) {
        try {
            PackageManager manager = cx.getPackageManager();
            PackageInfo info = manager.getPackageInfo(cx.getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Long getVersionNum(Activity cx) {
        try {
            String version = getVersion(cx);
            String[] ver = version.split("[.]");
            return Long.parseLong(ver[0]) * 1000000L + Long
                    .parseLong(ver[1]) * 10000L + Long.parseLong
                    (ver[2]);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }


    /**
     * 获取视频文件的缩略图，第一个参数为视频文件的位置，比如/sdcard/android123.3gp，
     * 而第二个参数可以为MINI_KIND或 MICRO_KIND最终和分辨率有关
     *
     * @param filePath 视频文件的路径
     * @param kind     与分辩率有关
     * @return 图像资源
     */

    public static Bitmap createVideoThumbnail(String filePath, int kind) {
        return null;
    }

    /**
     * 直接对Bitmap进行缩略操作，最后一个参数定义为OPTIONS_RECYCLE_INPUT ，来回收资源
     *
     * @param source  欲创建的源Bitmap
     * @param width   创建的图像宽度
     * @param height  创建的图像高度
     * @param options 图像设置
     * @return 创建后的图像
     */
    public static Bitmap extractThumbnail(Bitmap source, int width, int height, int options) {

        return null;
    }

    /**
     * 这个和上面的方法一样，无options选项
     *
     * @param source
     * @param width
     * @param height
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static Bitmap extractThumbnail(Bitmap source, int width, int height) {
        return null;
    }


    /**
     * 获取视频缩略图
     *
     * @param filePath 视频文件路径
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static Bitmap getVideoThumb(String filePath) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            retriever.setDataSource(filePath);
            bitmap = retriever.getFrameAtTime(1000L, MediaMetadataRetriever.OPTION_PREVIOUS_SYNC);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
        //saveVideoThumb(bitmap,"/");
        return bitmap;
    }

    /**
     * 保存视频缩略图到本地
     *
     * @param thumb    缩略图的bitmap
     * @param savepath 保存缩略图的文件夹的绝对路径
     */
    public static void saveVideoThumb(Bitmap thumb, String savepath) {
        String Suffix = "Thumb.jpg";

        String thumbPath = savepath + System.currentTimeMillis() + Suffix;
        File img = new File(thumbPath);
        if (!img.exists()) {
            try {
                img.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(thumbPath);
            thumb.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 计算出来的位置，y方向就在anchorView的上面和下面对齐显示，x方向就是与屏幕右边对齐显示
     * 如果anchorView的位置有变化，就可以适当自己额外加入偏移来修正
     *
     * @param anchorView  呼出window的view
     * @param contentView window的内容布局
     * @return window显示的左上角的xOff, yOff坐标
     */
    private static int[] calculatePopWindowPos(final View anchorView, final View contentView) {
        final int windowPos[] = new int[2];
        final int anchorLoc[] = new int[2];
        // 获取锚点View在屏幕上的左上角坐标位置
        anchorView.getLocationOnScreen(anchorLoc);
        final int anchorHeight = anchorView.getHeight();
        // 获取屏幕的高宽
        final int screenHeight = getScreenHeight(anchorView.getContext());
        final int screenWidth = getScreenWidth(anchorView.getContext());
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 计算contentView的高宽
        final int windowHeight = contentView.getMeasuredHeight();
        final int windowWidth = contentView.getMeasuredWidth();
        // 判断需要向上弹出还是向下弹出显示
        final boolean isNeedShowUp = (screenHeight - anchorLoc[1] - anchorHeight < windowHeight);
        if (isNeedShowUp) {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] - windowHeight;
        } else {
            windowPos[0] = screenWidth - windowWidth;
            windowPos[1] = anchorLoc[1] + anchorHeight;
        }
        return windowPos;
    }

    /**
     * 刷新媒体库
     *
     * @param cx
     */

    /**
     * 获取手机IMEI
     *
     * @param context
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String GetIMEI(Context context) {
        TelephonyManager mTm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        return mTm.getDeviceId();
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String GetModel() {
        return Build.MODEL;
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String GetDevice() {
        return Build.BRAND;
    }

    /**
     * 获取手机版本
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String GetOsVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取SDK版本
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static int GetSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机CPU信息
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String[] GetCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2;
        String[] cpuInfo = {"", ""};  //CourseIntroduceBean-cpu型号  //b-cpu频率
        String[] arrayOfString;
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            for (int i = 2; i < arrayOfString.length; i++) {
                cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
            }
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            cpuInfo[1] += arrayOfString[2];
            localBufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cpuInfo;
    }

    /**
     * 获取手机MAC地址
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    private String GetMacAddress(Context context) {
        String result;
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        result = wifiInfo.getMacAddress();
        return result;
    }

    /**
     * 获取手机总内存
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String GetTotalMemory(Context context) {
        String str1 = "/proc/meminfo";// 系统内存信息文件
        String str2;
        String[] arrayOfString;
        long initial_memory = 0;
        String resultSize;
        DecimalFormat df = new DecimalFormat("#.00");
        try {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(
                    localFileReader, 8192);
            str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小

            arrayOfString = str2.split("\\s+");
            for (String num : arrayOfString) {
                Log.i(str2, num + "\t");
            }
            initial_memory = Integer.valueOf(arrayOfString[1]);// 获得系统总内存，单位是KB，乘以1024转换为Byte
            localBufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (initial_memory < 1024) {
            resultSize = df.format((double) initial_memory) + "K";
        } else if (initial_memory < 1048576) {
            resultSize = df.format((double) initial_memory / 1024) + "M";
        } else if (initial_memory < 1073741824) {
            resultSize = df.format((double) initial_memory / 1048576) + "G";
        } else {
            resultSize = df.format((double) initial_memory / 1073741824) + "T";
        }
        return resultSize;// Byte转换为KB或者MB，内存大小规格化
    }

    //CPU个数
    public static int getNumCores() {
        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by CourseIntroduceBean single digit number
//                if (Pattern.matches("cpu[0-9]", pathname.getName())) {
//                    return true;
//                }
                return Pattern.matches("cpu[0-9]", pathname.getName());
            }
        }
        try {
            File dir = new File("/sys/devices/system/cpu/");
            File[] files = dir.listFiles(new CpuFilter());
            return files.length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * 获取最大频率(MHz)
     *
     * @return
     */
    // "/system/bin/cat" 命令行
    // "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq" 存储最大频率的文件的路径
    @SuppressWarnings("JavaDoc")
    public static String getMaxCpuFreq() {
        String result = "";
        ProcessBuilder cmd;
        try {
            String[] args = {"/system/bin/cat",
                    "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"};
            cmd = new ProcessBuilder(args);
            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[24];
            while (in.read(re) != -1) {
                result = String.format("%s%s", result, new String(re));
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            result = "N/A";
        }
        if (result.trim().equals("")) {
            result = "0";
        }
        return String.valueOf(Double.parseDouble(result.trim()) / 1000000);
    }

    /*
    (如果输入法在窗口上已经显示，则隐藏，反之则显示)
     */
    public static void HideKeyBord(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    //强制隐藏键盘
    public static void ConstraintHideKeyBord(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);   //强制隐藏键盘
    }

    // 获取CPU最小频率（单位MHZ）
    public static String getMinCpuFreq() {
        String result = "";
        ProcessBuilder cmd;
        try {
            String[] args = {"/system/bin/cat",
                    "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"};
            cmd = new ProcessBuilder(args);
            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[24];
            while (in.read(re) != -1) {
                result = String.format("%s%s", result, new String(re));
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            result = "N/A";
        }
        if (result.trim().equals("")) {
            result = "0";
        }
        return String.valueOf(Double.parseDouble(result.trim()) / 1000000);
    }

    /**
     * 联系我们弹框
     */
//    public static void createDialog(final Context context, final String phone) {
//        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_contact, null);
//        TextView teacherPhone = (TextView) view.findViewById(R.id.txt_teacherphone);
//        teacherPhone.setText(phone);
//        TextView txtClose = (TextView) view.findViewById(R.id.txt_close_dialog);
//        TextView txtCallPhone = (TextView) view.findViewById(R.id.txt_call_phone);
//        final AlertDialog builder = new AlertDialog.Builder(context).create();
//        builder.setView(view);
//        builder.show();
//        txtClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder.dismiss();
//            }
//        });
//        txtCallPhone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder.dismiss();
//                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // 没有获得授权，申请授权
//                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CALL_PHONE)) {
//                        Toast.makeText(context, "请授权！", Toast.LENGTH_LONG).show();
//                        // 帮跳转到该应用的设置界面，让用户手动授权
//                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri1 = Uri.fromParts("package", getPackageName(), null);
//                        intent.setData(uri1);
//                        context.startActivity(intent);
//                    } else {
//                        // 不需要解释为何需要该权限，直接请求授权
//                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
//                    }
//                } else {
//                    // 已经获得授权，可以打电话
//                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
//                    context.startActivity(intent);
//                }
//            }
//        });
//    }

    //图片加载
    public static void setPicassoImage(Context context, String url, ImageView imageView, int id) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url).placeholder(id).into(imageView);
        } else {
            Picasso.with(context).load(id).placeholder(id).into(imageView);
        }

    }
    //图片加载
    public static void PicassoImage(Context context, String url, ImageView imageView) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url).into(imageView);
        } else {

        }

    }
    //图片加载
    public static void setPicassoImage2(Context context, String url, ImageView imageView, int id) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url).placeholder(id).into(imageView);
        } else {
            Picasso.with(context).load(id).placeholder(id).into(imageView);
        }

    }
//    //
//    //图片加载遇到大图是放弃memory cache
//    public static void setPicassoImageSize(Context context, String url, ImageView imageView,int id) {
//        Picasso.with(context).load(url).placeholder(id).memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE).into(imageView);
//    }
//    //图片加载是裁剪
//    public static void setPicassoImageCrop(Context context, String url, ImageView imageView,int id) {
//        Picasso.with(context).load(url).placeholder(id).resize(Utils.dip2px(context,250),Utils.dip2px(context,250)).into(imageView);
//    }
    //

    /**
     * 获取sdcard的大小(B)
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static long[] getSDCardMemory() {
        long[] sdCardInfo = new long[2];
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            File sdcardDir = Environment.getExternalStorageDirectory();
            StatFs sf = new StatFs(sdcardDir.getPath());
            long bSize = sf.getBlockSize();
            long bCount = sf.getBlockCount();
            long availBlocks = sf.getAvailableBlocks();

            sdCardInfo[0] = bSize * bCount;//总大小
            sdCardInfo[1] = bSize * availBlocks;//可用大小
        }
        return sdCardInfo;
    }

    /**
     * 获取手机自身内存路径
     */
    public static String getPhoneCardPath() {
        return Environment.getDataDirectory().getPath();
    }

    /**
     * 获取sd卡路径
     * 双sd卡时，根据”设置“里面的数据存储位置选择，获得的是内置sd卡或外置sd卡
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static String getNormalSDCardPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * 获取外置SD卡路径
     *
     * @return 应该就一条记录或空
     */
    public static List<String> getExtSDCardPath() {
        List<String> lResult = new ArrayList<>();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("mount");
            InputStream is = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("extSdCard")) {
                    String[] arr = line.split(" ");
                    String path = arr[1];
                    File file = new File(path);
                    if (file.isDirectory()) {
                        lResult.add(path);
                    }
                }
            }
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lResult;
    }

    /**
     * 安装APK文件解决Android7.0适配的问题
     */
    public static void installApk(Context mContext, String apkpath, String DOWNLOAD_NAME) {
        File file = new File(
                Environment.getExternalStorageDirectory()
                , DOWNLOAD_NAME);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
        if (Build.VERSION.SDK_INT >= 24) { //判读版本是否在7.0以上
            //参数1 上下文, 参数2 Provider主机地址 和配置文件中保持一致   参数3  共享的文件
            Uri apkUri = FileProvider.getUriForFile(mContext, "com.gstb.ylm.fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(file),
                    "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        mContext.startActivity(intent);
    }

    /**
     * 获取设备屏幕大小尺寸
     */
    public static Double getScreenSizeOfDevice(Activity tv) {
        DisplayMetrics dm = tv.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        double x = Math.pow(width, 2);
        double y = Math.pow(height, 2);
        double diagonal = Math.sqrt(x + y);

        int dens = dm.densityDpi;
        double screenInches = diagonal / (double) dens;
        Log.d("屏幕尺寸", "The screenInches " + screenInches);
        return screenInches;
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * 获取Activity的父布局(RootView)
     *
     * @param context
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }

    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0)
            return "00:00";
        else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99)
                    return "99:59:59";
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }
        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10)
            retStr = "0" + Integer.toString(i);
        else
            retStr = "" + i;
        return retStr;
    }

    /*
截取字符串后几位
*/
    public static String CutLastIndex(String string, int index) {
        return string.substring(string.length() - index);
    }

    /*
    截取字符串前几位
     */
    public static String CutPrevious(String string, int index) {
        return string.substring(0, string.length() - index);
    }
    /*
    转换时间为yyyy年MM月dd日
    yyyy-MM-dd HH:mm:ss
     */
    public static String times(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        return sdr.format(new Date(i * 1000L));

    }
}