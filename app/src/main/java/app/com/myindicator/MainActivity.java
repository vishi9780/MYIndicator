package app.com.myindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.com.myprogressbar.MyProgressBar;
/***
 * Created by Vishal Yadav :- 131320180803HRS
 */
public class MainActivity extends AppCompatActivity {
    MyProgressBar mMyProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use this to display the Progress
        mMyProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                true, false, null);


        /**
         * dismiss the progress bar
         *   if (mProgressHUD.isShowing()) {
         *       mProgressHUD.dismiss();
         *    }
         */
    }
}
