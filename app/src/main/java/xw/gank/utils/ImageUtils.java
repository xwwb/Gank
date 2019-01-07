package xw.gank.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import xw.gank.config.Config;


public class ImageUtils {
    //保存图片到SD卡
    public static void saveFile(Bitmap bm, Context context, String photoId) throws IOException {
        String fileName = Environment.getExternalStorageDirectory() + "/美女/";
        String imgName = photoId + ".jpg";
        File jia = new File(fileName);              //新创的文件夹的名字
        if (!jia.exists()) {   //判断文件夹是否存在，不存在则创建
            jia.mkdirs();
        }
        File file = new File(jia + "/" + imgName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);

        bos.flush();
        bos.close();
        Toast.makeText(context, "下载完成", Toast.LENGTH_SHORT).show();

    }

    public static void setWallpaper(String photoId, Activity context) {
        String fileName = Environment.getExternalStorageDirectory() + "/美女/" + photoId + ".jpg";
        File file = new File(fileName);
        if (!file.exists()) {
            Toast.makeText(context, "请先下载图片", Toast.LENGTH_SHORT).show();
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra("mimeType", "image/*");
        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, null, null));
        intent.setData(uri);
        context.startActivityForResult(intent, Config.SET_THE_WALLPAPER);
        //从相册选取照片设置为壁纸
//        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
//        startActivity(Intent.createChooser(intent, "选择壁纸"));


        //利用WallpaparManager,添加权限set_wallpaper
//        WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
//        try {
//            wallpaperManager.setBitmap(bitmap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
