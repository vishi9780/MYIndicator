package app.com.myindicator;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;
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
                myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                        true, false, null, counter);
                counter++;
              /*  final Timer timer2 = new Timer();
                timer2.schedule(new TimerTask() {
                    public void run() {
                        myProgressBar.dismiss();
                        timer2.cancel(); //this will cancel the timer of the system
                    }
                }, 5000); // the timer will count 5 seconds....*/
            }
        });
        ll_parent.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return true;
            }
        });

        scheduleTaskExecutor = Executors.newScheduledThreadPool(40);
//        counter=35;
        scheduleTaskExecutor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // Do stuff here!

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                               /* if (counter!=40) {
                                    myProgressBar = MyProgressBar.show(MainActivity.this, "Please Wait . . .",
                                            true, false, null, counter);
                                    counter++;
                                    Log.e(TAG, "<<<<onClick:38>>>" + counter);
                                }else {*/
                               try {
                                   if (myProgressBar.isShowing()) {
                                       myProgressBar.dismiss();
                                       myProgressBar.hide();
                                       Log.e(TAG, "<<<<onClick:68>>>" + counter + "<<<else>>>");
                                   }
                               }catch (Exception e){
                                   Log.e("80","<<Main>>"+e);
                               }


                    }
                });

            }
        }, 0, 5,TimeUnit.SECONDS);
    }
}


