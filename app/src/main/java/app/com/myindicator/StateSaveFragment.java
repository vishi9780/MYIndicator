package app.com.myindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import app.com.myprogressbar.toastcustomization.YummyToast;

public class StateSaveFragment extends AppCompatActivity {

    Button btn_f1,btn_f2;
    FrameLayout framelt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state_save_fragment);
        initViews();
    }

    private void initViews() {
        btn_f1=(Button)findViewById(R.id.btn_f1);
        btn_f2=(Button)findViewById(R.id.btn_f2);
        framelt=(FrameLayout) findViewById(R.id.framelt);
        btn_f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SUCCESS
                //WARNING
                //ERROR
                //INFO
                //DEFAULT
                YummyToast.makeText(getApplicationContext(),"", YummyToast.LENGTH_SHORT,YummyToast.SUCCESS);
            }
        });
    }


}
