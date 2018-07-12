package app.com.myindicator;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

import app.com.myprogressbar.customization.MyProgressBar;

public class ProressBar extends AppCompatActivity {
    LinearLayout ll_parent;
    MyProgressBar myProgressBar;
    int counter=0;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f);
        initIDs();
    }

    private void initIDs() {
        ll_parent=(LinearLayout)findViewById(R.id.ll_parent);

        ll_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myProgressBar = MyProgressBar.show(ProressBar.this, "Please Wait . . .",
                        true, false, null, counter);
                counter++;
                final Timer timer2 = new Timer();
                timer2.schedule(new TimerTask() {
                    public void run() {
                            myProgressBar.dismiss();
                            timer2.cancel(); //this will cancel the timer of the system


                    }
                }, 4000); // the timer will count 5 seconds....*//*
            }
        });
    }

}
