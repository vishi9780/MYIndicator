package app.com.myindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.com.myprogressbar.customsplash.ParticleView;
import app.com.myprogressbar.otpview.PinView;
import app.com.myprogressbar.otpview.otpCatcher.OnSmsCatchListener;
import app.com.myprogressbar.otpview.otpCatcher.SmsVerifyCatcher;


public class OtpVerificationActivity extends AppCompatActivity {
    private EditText ed;
    private TextView tv;
    private String otp_generated,contactNo,id1;
    private ParticleView prVw_particle;
    private SmsVerifyCatcher smsVerifyCatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        ed=(EditText)findViewById(R.id.otp);
        tv=(TextView) findViewById(R.id.verify_otp);
        final PinView pinView = findViewById(R.id.firstPinView);
        final ParticleView prVw_particle = findViewById(R.id.prVw_particle);
        prVw_particle.startAnim();

        pinView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, getTheme()));
        pinView.setTextColor(ResourcesCompat.getColorStateList(getResources(), R.color.text_colors, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, getTheme()));
        pinView.setLineColor(ResourcesCompat.getColorStateList(getResources(), R.color.line_colors, getTheme()));
        pinView.setItemCount(4);
        pinView.setItemHeight(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        pinView.setItemWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        pinView.setItemRadius(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_radius));
        pinView.setItemSpacing(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
        pinView.setLineWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
        pinView.setAnimationEnable(true);// start animation when adding text
        pinView.setCursorVisible(false);
        pinView.setCursorColor(ResourcesCompat.getColor(getResources(), R.color.line_selected, getTheme()));
        pinView.setCursorWidth(getResources().getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("TAG", "onTextChanged() called with: s = [" + s + "], start = [" + start + "], before = [" + before + "], count = [" + count + "]");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //init SmsVerifyCatcher
        smsVerifyCatcher = new SmsVerifyCatcher(this, new OnSmsCatchListener<String>() {
            @Override
            public void onSmsCatch(String message) {
                String code = parseCode(message);//Parse verification code
                pinView.setText(code);
                //set code in edit text
                //then you can send verification code to server
            }
        });

        //set phone number filter if needed
        smsVerifyCatcher.setPhoneNumberFilter("777");
        //smsVerifyCatcher.setFilter("regexp");

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
    protected void onStart() {
        super.onStart();
        smsVerifyCatcher.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
        smsVerifyCatcher.onStop();

    }
    /**
     * need for Android 6 real time permissions
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        smsVerifyCatcher.onRequestPermissionsResult(requestCode, permissions, grantResults);
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
