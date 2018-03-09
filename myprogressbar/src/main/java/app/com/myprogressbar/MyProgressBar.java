package app.com.myprogressbar;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.com.myprogressbar.spinnerloader.SpinnerLoading;

/***
 * Created by Vishal Yadav :- 131320180803HRS
 */
public class MyProgressBar extends Dialog {
    public MyProgressBar(Context context) {
        super(context);
    }

    public MyProgressBar(Context context, int theme) {
        super(context, theme);
    }

    public static MyProgressBar show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                     OnCancelListener cancelListener,boolean looseLoader) {
        MyProgressBar dialog = new MyProgressBar(context, R.style.ProgressHUD);
        dialog.setTitle("");
        dialog.setContentView(R.layout.progress_hud);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.message).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.message);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        SpinnerLoading view = (SpinnerLoading)dialog. findViewById(R.id.spinner_loading);
        LinearLayout ll_parent= (LinearLayout) dialog. findViewById(R.id.ll_parent);
        TextView txt = (TextView) dialog.findViewById(R.id.message);

        ImageView imageView = (ImageView)dialog. findViewById(R.id.spinnerImageView);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        final int sdk = android.os.Build.VERSION.SDK_INT;

        if (looseLoader==true){
            view.setPaintMode(6);
            view.setCircleRadius(10);
            view.setItemCount(7);
            imageView.setVisibility(View.GONE);
            view.setVisibility(View.VISIBLE);
            txt.setTextColor(SpinnerLoading.DEFAULT_CIRCLE_COLOR_MOVE);
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ll_parent.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.color.transparent) );
            } else {
                ll_parent.setBackground(ContextCompat.getDrawable(context, android.R.color.transparent));
            }
            if (message.length()>0){
                txt.setVisibility(View.VISIBLE);
            }else {
                txt.setVisibility(View.GONE);
            }

        }else {

            imageView.setVisibility(View.VISIBLE);
            if (message.length()>0){
                txt.setVisibility(View.VISIBLE);
            }else {
                txt.setVisibility(View.GONE);
            }
            view.setVisibility(View.GONE);
            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                ll_parent.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg) );
            } else {
                ll_parent.setBackground(ContextCompat.getDrawable(context, R.drawable.progress_hud_bg));
            }
            txt.setText(message);
            txt.invalidate();
            spinner.start();
        }
        dialog.show();
        return dialog;
    }


}
