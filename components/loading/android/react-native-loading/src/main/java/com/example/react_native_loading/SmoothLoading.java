package com.example.react_native_loading;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by duanyun on 2017/7/14.
 */

public class SmoothLoading extends ReactContextBaseJavaModule {

    protected ColaProgress progressDialog;

    public SmoothLoading(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SmoothLoading";
    }

    /**
     * 显示加载框
     */
    @ReactMethod
    public void showLoading() {
        if(progressDialog == null || progressDialog.isShowing() == false) {
          progressDialog = ColaProgress.show(getReactApplicationContext().getCurrentActivity(), "", true, false, null);
        }
    }

    /**
     * 隐藏加载框
     */
    @ReactMethod
    public void hideLoading() {
        if(progressDialog!= null){
            progressDialog.dismiss();
        }
    }

}
