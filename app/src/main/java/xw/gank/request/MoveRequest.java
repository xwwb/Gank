package xw.gank.request;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.xw.library.utils.utils.Utils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by Administrator on 2017\9\30 0030.
 *
 */

public class MoveRequest extends BaseRequest {
    
    public void requestBestData (Activity activity,String tag,String start,final RequestListern listen){
     String url=UrlBase+"/search?"+"tag="+tag+"&start="+start;
        Log.i("====url",""+url);
        if (Utils.isNetworkAvalible(activity)){
            OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    listen.OnError(e);
                }

                @Override
                public void onResponse(String response, int id) {
                    listen.OnSucess(response);

                }
            });

        }else {
            Toast.makeText(activity, "亲,请检查你的网络......", Toast.LENGTH_SHORT).show();
         //IsNetworkConnected.checkNetwork(com.xw.gank.activity);
        }
     
        }
}
