package com.example.react_native_loading;

/**
 * Created by duanyun on 2017/7/14.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Administrator on 2015/12/14 0014.
 * 自定义Progress
 */
public class ColaProgress extends Dialog {
    public ColaProgress(Context context, int theme) {
        super(context, theme);
    }

    //焦点在window上的时候开始实例化，给图片加入动画效果
    public void onWindowFocusChanged(boolean hasFocus) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    //设置文字
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.message).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setText(message);
            txt.invalidate();
        }
    }


    //展示
    public static ColaProgress show(Context context, CharSequence message, boolean cancelable, boolean cancelableOutsite, OnCancelListener onCancelListener) {
        //设置主题
        ColaProgress colaProgress = new ColaProgress(context, R.style.ColaProgress);
        colaProgress.setTitle("");
        colaProgress.setContentView(R.layout.view_colaprogress);

        if (message.length() == 0 || message == null) {
            colaProgress.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txtMessage = (TextView) colaProgress.findViewById(R.id.message);
            txtMessage.setText(message);
        }
        colaProgress.setCancelable(cancelable);
        colaProgress.setCanceledOnTouchOutside(cancelableOutsite);
        colaProgress.setOnCancelListener(onCancelListener);
        WindowManager.LayoutParams lp = colaProgress.getWindow().getAttributes();
        lp.gravity = Gravity.CENTER;
        lp.dimAmount = 0.2f;
        colaProgress.getWindow().setAttributes(lp);
        colaProgress.show();
        return colaProgress;
    }
}
