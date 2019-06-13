package app.com.myprogressbar.vy.type;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import app.com.myprogressbar.vy.model.Arc;
import app.com.myprogressbar.vy.util.LoaderView;


/**
 * Created by Vishal Yadav :- 173020181303HRS
 */

public class Whirlpool extends LoaderView {
    private Arc[] arcs;
    private int numberOfArc;
    private float[] rotates;

    public Whirlpool() {
        numberOfArc = 3;
    }

    @Override
    public void initializeObjects() {
        float r = Math.min(width, height) / 2f;
        arcs = new Arc[numberOfArc];
        rotates = new float[numberOfArc];

        for (int i = 0; i < numberOfArc; i++) {
            float d = r / 4 + i * r / 4;
            arcs[i] = new Arc();
            arcs[i].setColor(color);
            arcs[i].setOval(new RectF(center.x - d, center.y - d, center.x + d, center.y + d));
            arcs[i].setStartAngle(i * 45);
            arcs[i].setSweepAngle(i * 45 + 90);
            arcs[i].setStyle(Paint.Style.STROKE);
            arcs[i].setWidth(r / 10f);
        }
    }

    @Override
    public void setUpAnimation() {
        try {
            for (int i = numberOfArc - 1; i >= 0; i--) {
                final int index = i;

                ValueAnimator fadeAnimator = ValueAnimator.ofFloat(arcs[i].getStartAngle(),
                        arcs[i].getStartAngle() + 360 * (i % 2 == 0 ? -1 : 1));
                fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
                fadeAnimator.setDuration((i + 1) * 500);
                fadeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        rotates[index] = (float) animation.getAnimatedValue();
                        if (invalidateListener != null) {
                            invalidateListener.reDraw();
                        }
                    }
                });

                fadeAnimator.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        try {
            for (int i = 0; i < numberOfArc; i++) {
                canvas.save();
                canvas.rotate(rotates[i], center.x, center.y);
                arcs[i].draw(canvas);
                canvas.restore();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
