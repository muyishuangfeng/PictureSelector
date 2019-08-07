package com.yk.silence.photoselector.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.widget.Toast;


public class FileUtils {
    public final static String FILE_EXTENSION_SEPARATOR = ".";
    /**
     * URI类型：file
     */
    public static final String URI_TYPE_FILE = "file";
    private final static String PATTERN = "yyyyMMddHHmmss";    // 时间戳命名

    private FileUtils() {
        throw new AssertionError();
    }


    /**
     * 创建文件
     *
     * @param context  context
     * @param filePath 文件路径
     * @return file
     */
    public static File createTmpFile(Context context, String filePath) {

        String timeStamp = new SimpleDateFormat(PATTERN, Locale.CHINA).format(new Date());

        String externalStorageState = Environment.getExternalStorageState();

        File dir = new File(Environment.getExternalStorageDirectory() + filePath);

        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return new File(dir, timeStamp + ".jpg");
        } else {
            File cacheDir = context.getCacheDir();
            return new File(cacheDir, timeStamp + ".jpg");
        }

    }


    public static String getFilePath(Context context) {
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().getPath();
        } else {
            return context.getCacheDir().getAbsolutePath();
        }
    }


    /**
     * @param filePath 文件夹路径
     * @return 截图完成的 file
     */
    public static File getCorpFile(String filePath) {
        String timeStamp = new SimpleDateFormat(PATTERN, Locale.CHINA).format(new Date());
        return new File(Environment.getExternalStorageDirectory() + filePath + "/crop/" + timeStamp + ".jpg");
    }


}
