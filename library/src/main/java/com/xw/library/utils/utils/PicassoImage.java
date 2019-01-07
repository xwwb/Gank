package com.xw.library.utils.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by Administrator on 2017\8\30 0030.
 */

public class PicassoImage extends ImageLoader {

    public PicassoImage(int id) {
        int id1 = id;
    }

    public PicassoImage() {
    }

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        String s = String.valueOf(path);

        if (!TextUtils.isEmpty(s)){
            Picasso.with(context).load(String.valueOf(path)).into(imageView);
        }

    }
}
