package app.com.myprogressbar.customization;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import app.com.myprogressbar.R;


/**
 * Created by think360user on 3/12/2018.
 */

public class SettingIndicatorHere {
    public static void setIndicatorHere(Context context, CharSequence message, int myLoaderValue, AnimationDrawable spinner) {
        final int sdk = android.os.Build.VERSION.SDK_INT;

        switch (myLoaderValue){
            case 0:
                MyProgressBar.isIs_0=true;
                MyProgressBar.isIs_1=false;
                MyProgressBar.isIs_2=false;
                MyProgressBar.isIs_3=false;
                MyProgressBar.spinner_loading.setPaintMode(6);
                MyProgressBar.spinner_loading.setCircleRadius(10);
                MyProgressBar.spinner_loading.setItemCount(7);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.spinner_loading.setVisibility(View.VISIBLE);
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    MyProgressBar.ll_parent.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg) );
                } else {
                    MyProgressBar.ll_parent.setBackground(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg));
                }
                if (message.length()>0){
                    MyProgressBar.txt.setVisibility(View.VISIBLE);
                }else {
                    MyProgressBar.txt.setVisibility(View.GONE);
                }
                break;
            case 1:
                MyProgressBar.isIs_0=false;
                MyProgressBar.isIs_1=true;
                MyProgressBar.isIs_2=false;
                MyProgressBar.isIs_3=false;
                MyProgressBar.imageView.setVisibility(View.VISIBLE);
                if (message.length()>0){
                    MyProgressBar.txt.setVisibility(View.VISIBLE);
                }else {
                    MyProgressBar.txt.setVisibility(View.GONE);
                }
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    MyProgressBar.ll_parent.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg) );
                } else {
                    MyProgressBar.ll_parent.setBackground(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg));
                }
                MyProgressBar.txt.setText(message);
                MyProgressBar.txt.invalidate();
                spinner.start();
                break;
            case 2:
                MyProgressBar.isIs_0=false;
                MyProgressBar.isIs_1=false;
                MyProgressBar.isIs_2=true;
                MyProgressBar.isIs_3=false;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.VISIBLE);
                MyProgressBar.myBallCradleLoading.start();
                break;
            case 3:
                MyProgressBar.isIs_0=false;
                MyProgressBar.isIs_1=false;
                MyProgressBar.isIs_2=false;
                MyProgressBar.isIs_3=true;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.VISIBLE);
                MyProgressBar.rotateLoading.start();
                break;
            default:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.VISIBLE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                spinner.start();
                break;
        }
    }
}
