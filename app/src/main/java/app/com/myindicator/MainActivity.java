package app.com.myindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import app.com.myprogressbar.customization.MyProgressBar;


/***
 * Created by Vishal Yadav :- 131320180803HRS
 */
public class MainActivity extends AppCompatActivity {
    MyProgressBar myProgressBar;
    public static final String TAG=MainActivity.class.getSimpleName();
    LinearLayout ll_parent;
    public static int counter=0;
    private ScheduledExecutorService scheduleTaskExecutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use this to display the Progress
        myProgressBar= new MyProgressBar(MainActivity.this,0);
        ll_parent = (LinearLayout) findViewById(R.id.ll_parent);
        ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (counter) {
                    case 0:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 0);
                        Log.e(TAG,"<<0>>");
                        counter++;
                        break;
                    case 1:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 1);
                        counter++;
                        Log.e(TAG,"<<1>>");
                        break;
                    case 2:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 2);
                        counter++;
                        Log.e(TAG,"<<2>>");
                        break;
                    case 3:

                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 3);
                        counter++;
                        Log.e(TAG,"<<3>>");
                        break;
                }
            }
        });
        ll_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counter = 0;
                return false;
            }
        });
        /**
         * dismiss the progress bar
         *   if (mProgressHUD.isShowing()) {
         *       mProgressHUD.dismiss();
         *    }
         */
        scheduleTaskExecutor = Executors.newScheduledThreadPool(5);


            scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    // Do stuff here!

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                if (myProgressBar.isShowing()) {
                                    myProgressBar.dismiss();
                                }
                            } catch (Exception e) {
                                Log.e("98", "<<<>>>>" + e);
                            }
                        }
                    });

                }
            }, 0, 5, TimeUnit.SECONDS); // or .MINUTES, .HOURS etc.
    }
}
