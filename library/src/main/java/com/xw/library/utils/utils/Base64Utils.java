package com.xw.library.utils.utils;


import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2017\11\10 0010.
 */

public class Base64Utils {
    public static String encodeBase64File(String path) throws Exception {
        File file = new File(path);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        inputFile.read(buffer);
        inputFile.close();
        //  String encodedString = Base64.encodeToString("whoislcj".getBytes(), Base64.DEFAULT);
        //  String s = Base64.encodeToString(buffer, true);
        return android.util.Base64.encodeToString(buffer, android.util.Base64.DEFAULT);
    }

}
