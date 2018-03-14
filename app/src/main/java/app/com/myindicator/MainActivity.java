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
import app.com.myprogressbar.vy.VYLoader;


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
        myProgressBar=new MyProgressBar(MainActivity.this);
        ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ll_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                counter = 0;
                return false;
            }
        });

        scheduleTaskExecutor = Executors.newScheduledThreadPool(40);
        scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // Do stuff here!

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                                if (counter<40)
                                myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                        true, false, null, counter);
                                counter++;
                                Log.e(TAG, "onClick:38>>>"+counter);
                    }
                });

            }
        }, 0, 3,TimeUnit.SECONDS);
    }
}


