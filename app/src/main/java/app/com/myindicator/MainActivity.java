package app.com.myindicator;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import app.com.myprogressbar.customization.MyProgressBar;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */
public class MainActivity extends MainActivity2{
    public static final String TAG=MainActivity.class.getSimpleName();
    private ScheduledExecutorService scheduleTaskExecutor;
    LinearLayout ll_parent;
    public static int counter=0;
    MyProgressBar myProgressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_parent = (LinearLayout) findViewById(R.id.ll_parent);

        ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (counter) {
                    case 0:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "",
                                true, false, null, 32);
                        Log.e(TAG,"<<0>>");
                        counter++;
                        break;
                    case 1:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "",
                                true, false, null, 11);
                        counter++;
                        Log.e(TAG,"<<1>>");
                        break;
                    case 2:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 12);
                        counter++;
                        Log.e(TAG,"<<2>>");
                        break;
                    case 3:

                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 13);
                        counter++;
                        Log.e(TAG,"<<3>>");
                        break;
                    case 4:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 14);
                        counter++;
                        Log.e(TAG,"<<"+counter+">>");
                        break;
                    case 5:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 0);
                        Log.e(TAG,"<<0>>");
                        counter++;
                        break;
                    case 6:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 1);
                        counter++;
                        Log.e(TAG,"<<1>>");
                        break;
                    case 7:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 2);
                        counter++;
                        Log.e(TAG,"<<2>>");
                        break;
                    case 8:

                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 8);
                        counter++;
                        Log.e(TAG,"<<3>>");
                        break;
                    case 9:
                        myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                true, false, null, 9);
                        counter++;
                        Log.e(TAG,"<<"+counter+">>");
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
        scheduleTaskExecutor = Executors.newScheduledThreadPool(10);


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
        }, 0, 30,TimeUnit.SECONDS);
    }
}


