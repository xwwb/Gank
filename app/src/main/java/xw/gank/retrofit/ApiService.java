package xw.gank.retrofit;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import xw.gank.info.AboutAndroidBean;
import xw.gank.info.AndroidBannerBean;
import xw.gank.info.FirstVideoBean;
import xw.gank.info.GankModel;
import xw.gank.info.MoviesBean;
import xw.gank.info.RegisterBean;

public interface ApiService {
    @GET("data/{type}/{count}/{page}")
    Observable<GankModel> getData(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    @GET("in_theaters?")
    Observable<MoviesBean> getNewNewsMoveData(
            @Query("start") String start);
    @GET
    Observable<ResponseBody> downloadPicFromNet(@Url String fileUrl);
    @GET("tree/json")
    Observable<AboutAndroidBean> getAboutAndroid();
    @GET("banner/json")
    Observable<AndroidBannerBean> getAndroidBanner();
    @GET("search/query/{type}/category/{types}/count/{count}/page/{page}")
    Observable<GankModel> getAboutAndroid(@Path("type") String type, @Path("types") String types, @Path("count") int count, @Path("page") int page);
    @POST("user/register")
    Observable<RegisterBean> register(@Query("username") String username , @Query("password") String password, @Query("repassword") String repassword);
    @POST("user/login")
    Observable<RegisterBean> login(@Query("username") String username , @Query("password") String password);
    @ GET("satinApi?")
    Observable<FirstVideoBean>getFirstVideo(@Query ("type")String type,@Query("page")String page);
}
