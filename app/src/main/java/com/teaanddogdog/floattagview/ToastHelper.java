package com.teaanddogdog.floattagview;

import android.content.Context;
import android.widget.Toast;

/**
 * @author banbury
 * @version v1.0
 * @created 2018/7/18_16:47.
 * @description
 */

public class ToastHelper {
    private static final ToastHelper ourInstance = new ToastHelper();

    public static ToastHelper getInstance() {
        return ourInstance;
    }

    private Toast mToast;

    private ToastHelper() {
    }

    public void showToast(Context context,String msg){
        if (mToast==null) {
            mToast = Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
