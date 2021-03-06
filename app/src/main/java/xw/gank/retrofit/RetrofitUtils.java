package xw.gank.retrofit;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weihuajian on 16/6/22.
 */
public class RetrofitUtils {
    private static Context mContext;
    public static Retrofit retrofit = null;

    public static Retrofit getInstance(Context context, String url) {
        mContext = context;
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //  builder.addInterceptor(addQueryParameterInterceptor());
            //   builder.addInterceptor(addHeaderInterceptor());
            // 设置缓存
            File cacheFile = new File(mContext.getExternalCacheDir(), "RetrofitCache");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            builder.cache(cache).addInterceptor(addCacheInterceptor());

            //设置超时
            builder.connectTimeout(1, TimeUnit.SECONDS);
            builder.readTimeout(6, TimeUnit.SECONDS);
            builder.writeTimeout(6, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }


    /**
     * 设置公共参数
     */
    private static Interceptor addQueryParameterInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("platform", "android")
                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
    }

    /**
     * 设置头
     */
    private static Interceptor addHeaderInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder requestBuilder = originalRequest.newBuilder()
                        // Provide your custom header here
                        .header("AppType", "TPOS")
                        .header("Accept", "application/json")
                        .method(originalRequest.method(), originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!isNetworkAvailable(mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (isNetworkAvailable(mContext)) {
                    int maxAge = 0;
                    // 有网络时 设置缓存超时时间0个小时
                    String cacheControl = request.cacheControl().toString();
                    response.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
    }

    public static Retrofit getAboutAndroidInstance(Context context, String url) {
           mContext = context;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            //  builder.addInterceptor(addQueryParameterInterceptor());
            //   builder.addInterceptor(addHeaderInterceptor());
            // 设置缓存
            File cacheFile = new File(mContext.getExternalCacheDir(), "AboutAndroidCache");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            builder.cache(cache).addInterceptor(addCacheInterceptor());

            //设置超时
            builder.connectTimeout(1, TimeUnit.SECONDS);
            builder.readTimeout(6, TimeUnit.SECONDS);
            builder.writeTimeout(6, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            OkHttpClient client = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
        return retrofit;
    }

    /**
     * 判断网络
     */
    public static boolean isNetworkAvailable(Context ct) {
        Context context = ct.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0) {
                for (NetworkInfo aNetworkInfo : networkInfo) {
                    if (NetworkInfo.State.CONNECTED == aNetworkInfo.getState()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Gson getGson() {

        return new GsonBuilder().excludeFieldsWithModifiers().create();
    }

    public static Retrofit getDouBanMoiveInstance(Context context, String url) {
        mContext = context;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //  builder.addInterceptor(addQueryParameterInterceptor());
        //   builder.addInterceptor(addHeaderInterceptor());
        // 设置缓存
        File cacheFile = new File(mContext.getExternalCacheDir(), "DouBanMoiveCache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        builder.cache(cache).addInterceptor(addCacheInterceptor());

        //设置超时
        builder.connectTimeout(1, TimeUnit.SECONDS);
        builder.readTimeout(6, TimeUnit.SECONDS);
        builder.writeTimeout(6, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
    public static Retrofit getFirstVideoInstance(Context context) {
        mContext = context;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //  builder.addInterceptor(addQueryParameterInterceptor());
        //   builder.addInterceptor(addHeaderInterceptor());
        // 设置缓存
        File cacheFile = new File(mContext.getExternalCacheDir(), "FirstVideo");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
       // builder.cache(cache).addInterceptor(addCacheInterceptor());

        //设置超时
        builder.connectTimeout(1, TimeUnit.SECONDS);
        builder.readTimeout(6, TimeUnit.SECONDS);
        builder.writeTimeout(6, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);

        OkHttpClient client = builder.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantApi.FirstVideo)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }
}
