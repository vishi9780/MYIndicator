package app.com.myprogressbar.customization;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.com.myprogressbar.R;
import app.com.myprogressbar.customization.spinnerloader.SpinnerLoading;
import app.com.myprogressbar.multiIndicators.IndicatorView;
import app.com.myprogressbar.myBall.MyBallCradleLoading;
import app.com.myprogressbar.rotate.RotateLoading;

import static app.com.myprogressbar.customization.SettingIndicatorHere.setIndicatorHere;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class MyProgressBar extends Dialog {
    public static MyBallCradleLoading myBallCradleLoading;
    public static LinearLayout ll_parent;
    public static TextView txt;
    public static ImageView imageView;
    public static SpinnerLoading spinner_loading;
    public static RotateLoading rotateLoading;
    public static boolean isIs_0=false,isIs_1=false,isIs_2=false,isIs_3=false;
    public static MyProgressBar dialog;
    public static IndicatorView myIndicator_vw;
    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, int theme) {
        super(context, theme);
    }

    public static MyProgressBar show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                     OnCancelListener cancelListener,int myLoaderValue) {
         dialog = new MyProgressBar(context, R.style.ProgressHUD);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_hud);
        initViews(dialog);
        if (message == null || message.length() == 0) {
            txt.setVisibility(View.GONE);
        } else {

            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);


        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        setIndicatorHere(context, message, myLoaderValue, spinner);

        dialog.show();
        return dialog;
    }



    private static void initViews(MyProgressBar dialog) {
        ll_parent= (LinearLayout) dialog. findViewById(R.id.ll_parent);
        txt = (TextView) dialog.findViewById(R.id.message);
        myBallCradleLoading=(MyBallCradleLoading)dialog.findViewById(R.id.myBallCradleLoading);
        rotateLoading=(RotateLoading) dialog.findViewById(R.id.rotateLoading);
        imageView = (ImageView)dialog. findViewById(R.id.spinnerImageView);
        spinner_loading = (SpinnerLoading)dialog. findViewById(R.id.spinner_loading);
        myIndicator_vw=(IndicatorView)dialog.findViewById(R.id.myIndicator_vw);
    }

    @Override
    protected void onStop() {
        if (isIs_0==true){
            dialog.dismiss();
            isIs_0=false;
        }else if (isIs_1==true){
            dialog.dismiss();
            isIs_1=false;
        }else if (isIs_2==true){
            myBallCradleLoading.stop();
            isIs_2=false;
        }else if (isIs_3==true){
            rotateLoading.stop();
            isIs_3=false;
        }else {

        }
        super.onStop();
    }

    @Override
    public void show() {
        if (isIs_0==true){
            spinner_loading.setVisibility(View.VISIBLE);
            isIs_0=false;
        }else if (isIs_1==true){
            imageView.setVisibility(View.VISIBLE);
            isIs_1=false;
        }else if (isIs_2==true){
            myBallCradleLoading.start();
            isIs_2=false;
        }else if (isIs_3==true){
            rotateLoading.start();
            isIs_3=false;
        }else {

        }
        super.show();
    }
}
