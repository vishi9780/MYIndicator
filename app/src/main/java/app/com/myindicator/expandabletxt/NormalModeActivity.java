package app.com.myindicator.expandabletxt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import app.com.myindicator.R;
import app.com.myprogressbar.expandable_txt.TextViewExpandableAnimation;



public class NormalModeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_mode);
        String text = getString(R.string.tips);

        TextViewExpandableAnimation tvExpand = (TextViewExpandableAnimation) findViewById(R.id.tv_expand);
        tvExpand.setText(text + text + text + text+text + text );

    }
}
