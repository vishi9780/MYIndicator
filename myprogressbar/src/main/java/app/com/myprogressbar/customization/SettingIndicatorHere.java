package app.com.myprogressbar.customization;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.content.ContextCompat;
import android.view.View;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class SettingIndicatorHere {
    //in loader generator class 1-7 values are there
    public static int myStaticValue = 0;

    public static void setIndicatorHere(Context context, CharSequence message, int myLoaderValue, AnimationDrawable spinner) {
        getSdk(context);

        if (message.length() > 0 && myLoaderValue == 1) {
            MyProgressBar.txt.setVisibility(View.VISIBLE);
        } else {
            MyProgressBar.txt.setVisibility(View.GONE);
        }

        switch (myLoaderValue) {
            case 0:
                MyProgressBar.isIs_0 = true;
                MyProgressBar.isIs_1 = false;
                MyProgressBar.isIs_2 = false;
                MyProgressBar.isIs_3 = false;
                MyProgressBar.spinner_loading.setPaintMode(6);
                MyProgressBar.spinner_loading.setCircleRadius(10);
                MyProgressBar.spinner_loading.setItemCount(7);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.spinner_loading.setVisibility(View.VISIBLE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                break;
            case 1:
                MyProgressBar.isIs_0 = false;
                MyProgressBar.isIs_1 = true;
                MyProgressBar.isIs_2 = false;
                MyProgressBar.isIs_3 = false;
                MyProgressBar.imageView.setVisibility(View.VISIBLE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.txt.setText(message);
                MyProgressBar.txt.invalidate();

                spinner.start();
                break;
            case 2:
                myStaticValue = 7;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);


                break;
            case 3:
                MyProgressBar.isIs_0 = false;
                MyProgressBar.isIs_1 = false;
                MyProgressBar.isIs_2 = false;
                MyProgressBar.isIs_3 = true;
                MyProgressBar.txt.setVisibility(View.GONE);
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.rotateLoading.setVisibility(View.VISIBLE);
                MyProgressBar.rotateLoading.start();
                break;
            case 4:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(4);
                break;
            case 5:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(5);
                break;
            case 6:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(6);
                break;
            case 7:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(7);
                break;
            case 8:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(8);
                break;
            case 9:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(9);
                break;
            case 10:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(10);
                break;
            case 11:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(11);
                break;
            case 12:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(12);
                break;
            case 13:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(13);
                break;
            case 14:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(14);
                break;
            case 15:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(15);
                break;
            case 16:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(16);
                break;
            case 17:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(17);
                break;
            case 18:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(18);
                break;
            case 19:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(19);
                break;
            case 20:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(20);
                break;
            case 21:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(21);
                break;
            case 22:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(22);
                break;
            case 23:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(23);
                break;
            case 24:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(24);
                break;
            case 25:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(25);
                break;
            case 26:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(26);
                break;
            case 27:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(27);
                break;
            case 28:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(28);
                break;
            case 29:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(29);
                break;
            case 30:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(30);
                break;
            case 31:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(31);
                break;
            case 32:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myIndicator_vw.setVisibility(View.VISIBLE);
                MyProgressBar.myIndicator_vw.setmyIndicator(32);
                break;
            case 33:
                myStaticValue = 1;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 34:
                myStaticValue = 2;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 35:
                myStaticValue = 3;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 36:
                myStaticValue = 4;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 37:
                myStaticValue = 5;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 38:
                myStaticValue = 6;
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);

                MyProgressBar.vy_loader.setVisibility(View.VISIBLE);
                break;
            case 39:
                MyProgressBar.isIs_0 = false;
                MyProgressBar.isIs_1 = false;
                MyProgressBar.isIs_2 = true;
                MyProgressBar.isIs_3 = false;
                MyProgressBar.txt.setVisibility(View.GONE);
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);

                MyProgressBar.myBallCradleLoading.setVisibility(View.VISIBLE);
                MyProgressBar.myBallCradleLoading.start();
                break;
            default:
                MyProgressBar.spinner_loading.setVisibility(View.GONE);
                MyProgressBar.imageView.setVisibility(View.VISIBLE);
                MyProgressBar.myBallCradleLoading.setVisibility(View.GONE);
                MyProgressBar.rotateLoading.setVisibility(View.GONE);
                MyProgressBar.vy_loader.setVisibility(View.GONE);
                spinner.start();
                break;
        }
    }

    public static int getSdk(Context context) {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            MyProgressBar.ll_parent.setBackgroundDrawable(ContextCompat.getDrawable(context, android.R.color.transparent));
        } else {
            MyProgressBar.ll_parent.setBackground(ContextCompat.getDrawable(context, android.R.color.transparent));
        }
        return sdk;
    }
}
