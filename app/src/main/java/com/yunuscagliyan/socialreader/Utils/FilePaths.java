package com.yunuscagliyan.socialreader.Utils;

import android.content.Context;
import android.os.Environment;


public class FilePaths {

    //"storage/emulated/0"
    public String ROOT_DIR = Environment.getExternalStorageDirectory().getPath();

    public String PICTURES = ROOT_DIR + "/Pictures";
    public String CAMERA = ROOT_DIR + "/DCIM/camera";
    public String DOWNLOAD = ROOT_DIR+ "/document/image";


    public String FIREBASE_IMAGE_STORAGE = "photo/users/";

}
