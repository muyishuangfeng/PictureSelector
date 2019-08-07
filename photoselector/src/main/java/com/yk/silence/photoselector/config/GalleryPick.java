package com.yk.silence.photoselector.config;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.yk.silence.photoselector.GalleryPickActivity;

import java.io.File;
import java.io.IOException;


/**
 * GalleryPick 启动类 (单例)
 */
public class GalleryPick {

    private final static String TAG = "GalleryPick";

    private static GalleryPick galleryPick;

    private GalleryConfig galleryConfig;

    public static GalleryPick getInstance() {
        if (galleryPick == null) {
            galleryPick = new GalleryPick();
        }
        return galleryPick;
    }


    public void open(Activity mActivity) {
        if (galleryPick.galleryConfig == null) {
            Log.e(TAG, "请配置 GalleryConfig");
            return;
        }
        if (galleryPick.galleryConfig.getImageLoader() == null) {
            Log.e(TAG, "请配置 ImageLoader");
            return;
        }
        if (galleryPick.galleryConfig.getIHandlerCallBack() == null) {
            Log.e(TAG, "请配置 IHandlerCallBack");
            return;
        }
        if (TextUtils.isEmpty(galleryPick.galleryConfig.getProvider())) {
            Log.e(TAG, "请配置 Provider");
            return;
        }
        createFile(galleryPick.galleryConfig.getFilePath());

        Intent intent = new Intent(mActivity, GalleryPickActivity.class);
        mActivity.startActivity(intent);
    }

    public void openCamera(Activity mActivity) {
        if (galleryPick.galleryConfig == null) {
            Log.e(TAG, "请配置 GalleryConfig");
            return;
        }
        if (galleryPick.galleryConfig.getImageLoader() == null) {
            Log.e(TAG, "请配置 ImageLoader");
            return;
        }
        if (galleryPick.galleryConfig.getIHandlerCallBack() == null) {
            Log.e(TAG, "请配置 IHandlerCallBack");
            return;
        }
        if (TextUtils.isEmpty(galleryPick.galleryConfig.getProvider())) {
            Log.e(TAG, "请配置 Provider");
            return;
        }

        createFile(galleryPick.galleryConfig.getFilePath());

        Intent intent = new Intent(mActivity, GalleryPickActivity.class);
        intent.putExtra("isOpenCamera", true);
        mActivity.startActivity(intent);
    }


    public GalleryPick setGalleryConfig(GalleryConfig galleryConfig) {
        this.galleryConfig = galleryConfig;
        return this;
    }

    public GalleryConfig getGalleryConfig() {
        return galleryConfig;
    }

    public void clearHandlerCallBack() {
        galleryConfig.getBuilder().iHandlerCallBack(null).build();
    }

    /**
     * 创建初始文件夹。保存拍摄图片和裁剪后的图片
     *
     * @param filePath 文件夹路径
     */
    private void createFile(String filePath) {
        String externalStorageState = Environment.getExternalStorageState();

        File dir = new File(Environment.getExternalStorageDirectory() + filePath);
        File cropFile = new File(Environment.getExternalStorageDirectory() + filePath + "/crop");

        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            if (!cropFile.exists()) {
                cropFile.mkdirs();
            }

            File file = new File(cropFile, ".nomedia");    // 创建忽视文件。   有该文件，系统将检索不到此文件夹下的图片。
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
/*
 *   ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 *     ┃　　　┃
 *     ┃　　　┃
 *     ┃　　　┗━━━┓
 *     ┃　　　　　　　┣┓
 *     ┃　　　　　　　┏┛
 *     ┗┓┓┏━┳┓┏┛
 *       ┃┫┫　┃┫┫
 *       ┗┻┛　┗┻┛
 *        神兽保佑
 *        代码无BUG!
 */