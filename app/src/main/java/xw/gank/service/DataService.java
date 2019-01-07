package xw.gank.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import xw.gank.info.GirlItemData;
import xw.gank.utils.CallBackUtils;
import xw.gank.utils.ImageLoader;

/**
 * Author: Othershe
 * Time: 2016/8/18 11:48
 */
public class DataService extends IntentService {
    public DataService() {
        super("");
    }

    public static void startService(Context context, List<GirlItemData> datas, String subtype) {
        Intent intent = new Intent(context, DataService.class);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) datas);
        intent.putExtra("subtype", subtype);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            return;
        }

        List<GirlItemData> datas = intent.getParcelableArrayListExtra("data");
        String subtype = intent.getStringExtra("subtype");
        handleGirlItemData(datas, subtype);
    }

    private void handleGirlItemData(List<GirlItemData> datas, String subtype) {
        Log.i("===========DataService",""+datas.size());
        if (datas.size() == 0) {
            CallBackUtils.finActivity("finish",datas);
            return;
        }
        for (GirlItemData data : datas) {
            Bitmap bitmap = ImageLoader.load(this, data.getUrl());
            if (bitmap != null) {
                Log.i("=====bitmap",""+bitmap.getWidth());
                data.setWidth(bitmap.getWidth());
                data.setHeight(bitmap.getHeight());
            }

            data.setSubtype(subtype);
        }
        int width = datas.get(0).getWidth();
        Log.i("=====with",""+width);
        CallBackUtils.finActivity("",datas);
    }
}
