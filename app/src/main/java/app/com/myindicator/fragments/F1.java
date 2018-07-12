package app.com.myindicator.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.com.myindicator.R;

public class F1 extends Fragment{
    TextView tv_NumberofFragments;
    ImageView mImageView ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {

        mImageView = (ImageView)view.findViewById(R.id.ivf); //this is your imageView

        final AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.spinner_0), 100);
        animation.addFrame(getResources().getDrawable(R.drawable.battery_full), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.battery_empty), 300);
        animation.addFrame(getResources().getDrawable(R.drawable.battery_charging), 300);
        animation.addFrame(getResources().getDrawable(R.drawable.battery_not_charging), 300);
        animation.setOneShot(false);

//        ImageView imageAnim =  (ImageView) findViewById(R.id.img);


        // start the animation!

        tv_NumberofFragments=(TextView)view.findViewById(R.id.tv_NumberofFragments);
        tv_NumberofFragments.setText("F1");
        tv_NumberofFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mImageView.setBackgroundDrawable(animation);
                animation.start();

                }});
    }
}
