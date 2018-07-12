package app.com.myindicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import app.com.myprogressbar.customization.MyProgressBar;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    MyProgressBar myProgressBar;
    Button button,button2, button3,button4, button5,button6,
            button7,button8, button9,button10, button11,button12;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m2);
        initids();
    }

    private void initids() {
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        button5=(Button)findViewById(R.id.button5);
        button6=(Button)findViewById(R.id.button6);
        button7=(Button)findViewById(R.id.button7);
        button8=(Button)findViewById(R.id.button8);
        button9=(Button)findViewById(R.id.button9);
        button10=(Button)findViewById(R.id.button10);
        button11=(Button)findViewById(R.id.button11);
        button12=(Button)findViewById(R.id.button12);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                startActivity(new Intent(this,MainWithSwipe.class));
                break;
                case R.id.button2:
                startActivity(new Intent(this,Main3WithoutSwipe.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this,ProressBar.class));
                break;
        }
    }

    public void saveStateFragment(View view) {
        startActivity(new Intent(this,StateSaveFragment.class));
    }
}
