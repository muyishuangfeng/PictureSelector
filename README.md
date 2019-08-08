# PictureSelector

[![](https://jitpack.io/v/muyishuangfeng/PictureSelector.svg)](https://jitpack.io/#muyishuangfeng/PictureSelector)





   + 1、创建一个xml文件夹以及资源文件
   
         <paths>
          <external-path
            name="camera_photos"
            path="" />
          </paths>
   
   
   + 2、在清单文件中设置FileProvider
   
    <provider
            android:name="android.support.v4.content.FileProvider"
            android:authorities="${applicationId}.FileProvider"
            android:exported="false"
            android:grantUriPermissions="true">
            <meta-data
                android:name="android.support.FILE_PROVIDER_PATHS"
                android:resource="@xml/file_paths" />
        </provider>
