package app.com.myindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import app.com.myindicator.expandabletxt.NormalModeActivity;
import app.com.myindicator.expandabletxt.RecyclerViewModeActivity;
import app.com.myprogressbar.customsplash.ParticleView;
import app.com.myprogressbar.justification_txt_edit_txt.JustifiedTextView;
import app.com.myprogressbar.mygradient.GradientLinearLayout;
import app.com.myprogressbar.toastcustomization.YummyToast;


public class OtpVerificationActivity extends AppCompatActivity {
    private EditText ed;
    private TextView tv;
    JustifiedTextView tv_txt;
    private String otp_generated,contactNo,id1;
    private ParticleView prVw_particle;
    GradientLinearLayout activity_otp_verifications;
//    VerifyCodeView verfiy_cview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        ed=(EditText)findViewById(R.id.otp);
        tv=(TextView) findViewById(R.id.verify_otp);
        tv_txt=(JustifiedTextView) findViewById(R.id.tv_txt);
        tv_txt.setText("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");

        final ParticleView prVw_particle = findViewById(R.id.prVw_particle);
        prVw_particle.startAnim();

//        verfiy_cview=(VerifyCodeView)findViewById(R.id.verfiy_cview);


        findViewById(R.id.btn_normal_mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpVerificationActivity.this,NormalModeActivity.class));
            }
        });
        findViewById(R.id.btn_recycler_view_mode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpVerificationActivity.this,RecyclerViewModeActivity.class));
            }
        });
        YummyToast.makeText(OtpVerificationActivity.this,"",YummyToast.LENGTH_LONG,YummyToast.CONFUSING);
        activity_otp_verifications=(GradientLinearLayout)findViewById(R.id.activity_otp_verification);
        generateBackgroundForSection(activity_otp_verifications, 1);

    }
    private void generateBackgroundForSection(final GradientLinearLayout layout, final int section) {
        switch (section) {
            case 1:
                layout.setGradientBackgroundConfig(
                        Color.rgb(123, 31, 162),
                        Color.rgb(0, 150, 136),
                        GradientDrawable.Orientation.BL_TR);
                break;
            case 2:
                layout.setEndColor(Color.rgb(123,31,162));
                break;
            case 3:
                layout
                        .setEndColor(Color.rgb(104,159,56))
                        .setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                break;
            case 4:
                layout
                        .setStartColor(Color.rgb(255,87,34))
                        .setEndColor(Color.rgb(255,193,7))
                        .setOrientation(GradientDrawable.Orientation.TR_BL);
                break;
        }
    }
    /**
     * Parse verification code
     *
     * @param message sms message
     * @return only four numbers from massage string
     */
    private String parseCode(String message) {
        Pattern p = Pattern.compile("\\b\\d{4}\\b");
        Matcher m = p.matcher(message);
        String code = "";
        while (m.find()) {
            code = m.group(0);
        }
        return code;
    }


    @Override
    public void onResume() {
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("otp"));
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("otp")) {
                final String message = intent.getStringExtra("message");
                Log.e("48","<<<<>>>>"+message.substring(10));
                ed.setText(message.substring(10,16));
                // message is the fetching OTP
            }
        }
    };

}
