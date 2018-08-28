package app.com.myprogressbar.myball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import app.com.myprogressbar.R;


/***
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class MyBallCradleLoading extends LinearLayout {

    private MyBall myBallOne;
    private MyBall myBallTwo;
    private MyBall myBallThree;
    private MyBall myBallFour;
    private MyBall myBallFive;

    private static final int DURATION = 310;
    private static final int SHAKE_DISTANCE = 4;
    private static final float PIVOT_X = 0.5f;
    private static final float PIVOT_Y = -5f;
    private static final int DEGREE = 9;


    private boolean isStart = false;

    public MyBallCradleLoading(Context context) {
        super(context);
        initView(context);
    }

    public MyBallCradleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyBallCradleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.myballcradleloading, this, true);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        myBallOne = (MyBall) findViewById(R.id.ball_one);
        myBallTwo = (MyBall) findViewById(R.id.ball_two);
        myBallThree = (MyBall) findViewById(R.id.ball_three);
        myBallFour = (MyBall) findViewById(R.id.ball_four);
        myBallFive = (MyBall) findViewById(R.id.ball_five);

        initAnim();
    }

    RotateAnimation rotateLeftAnimation;//cradleBallOne left to right
    RotateAnimation rotateRightAnimation;//cradleBallFive right to left
    TranslateAnimation shakeLeftAnimation;
    TranslateAnimation shakeRightAnimation;


    private void initAnim() {
        rotateRightAnimation = new RotateAnimation(0, -DEGREE, RotateAnimation.RELATIVE_TO_SELF, PIVOT_X, RotateAnimation.RELATIVE_TO_SELF, PIVOT_Y);
        rotateRightAnimation.setRepeatCount(1);
        rotateRightAnimation.setRepeatMode(Animation.REVERSE);
        rotateRightAnimation.setDuration(DURATION);
        rotateRightAnimation.setInterpolator(new LinearInterpolator());
        rotateRightAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isStart)
                    startRightAnim();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        shakeLeftAnimation = new TranslateAnimation(0, SHAKE_DISTANCE, 0, 0);
        shakeLeftAnimation.setDuration(DURATION);
        shakeLeftAnimation.setInterpolator(new CycleInterpolator(2));

        rotateLeftAnimation = new RotateAnimation(0, DEGREE, RotateAnimation.RELATIVE_TO_SELF, PIVOT_X, RotateAnimation.RELATIVE_TO_SELF, PIVOT_Y);
        rotateLeftAnimation.setRepeatCount(1);
        rotateLeftAnimation.setRepeatMode(Animation.REVERSE);
        rotateLeftAnimation.setDuration(DURATION);
        rotateLeftAnimation.setInterpolator(new LinearInterpolator());
        rotateLeftAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (isStart) {
                    myBallTwo.startAnimation(shakeLeftAnimation);
                    myBallThree.startAnimation(shakeLeftAnimation);
                    myBallFour.startAnimation(shakeLeftAnimation);

                    myBallFive.startAnimation(rotateRightAnimation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        shakeRightAnimation = new TranslateAnimation(0, -SHAKE_DISTANCE, 0, 0);
        shakeRightAnimation.setDuration(DURATION);
        shakeRightAnimation.setInterpolator(new CycleInterpolator(2));
        shakeRightAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (isStart)
                    startLeftAnim();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void startLeftAnim() {
        myBallOne.startAnimation(rotateLeftAnimation);
    }

    private void startRightAnim() {
        myBallTwo.startAnimation(shakeRightAnimation);
        myBallThree.startAnimation(shakeRightAnimation);
        myBallFour.startAnimation(shakeRightAnimation);
    }

    public void start() {
        if (!isStart) {
            isStart = true;
            startLeftAnim();
        }
    }

    public void stop() {
        isStart = false;
        myBallOne.clearAnimation();
        myBallTwo.clearAnimation();
        myBallThree.clearAnimation();
        myBallFour.clearAnimation();
        myBallFive.clearAnimation();
    }

    public boolean isStart() {
        return isStart;
    }

    public void setLoadingColor(int color) {
        myBallOne.setLoadingColor(color);
        myBallTwo.setLoadingColor(color);
        myBallThree.setLoadingColor(color);
        myBallFour.setLoadingColor(color);
        myBallFive.setLoadingColor(color);
    }
}
