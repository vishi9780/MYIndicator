package app.com.myindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import app.com.myprogressbar.customization.MyProgressBar;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class MainActivity2 extends AppCompatActivity {
    MyProgressBar myProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    protected void showProgress() {
        if (myProgressBar != null && myProgressBar.isShowing())
            dismissProgress();
        myProgressBar = MyProgressBar.show(MainActivity2.this, "Please Wait . . .",
                true, false, null, 0);
    }

    protected void dismissProgress() {
        if (myProgressBar != null) {
            myProgressBar.dismiss();
            myProgressBar = null;
        }
    }
}
