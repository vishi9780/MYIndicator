package app.com.myprogressbar.mydrawbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import app.com.myprogressbar.mydrawbutton.delegate.DrawMe;
import app.com.myprogressbar.mydrawbutton.delegate.DrawMeShapeText;

public class DrawMeEditText extends EditText {
    private final DrawMe drawMe;

    public DrawMeEditText(Context context) {
        super(context);
        drawMe = new DrawMeShapeText(context, this, null);
    }

    public DrawMeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawMe = new DrawMeShapeText(context, this, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int[] size = drawMe.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(size[0], size[1]);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        drawMe.onLayout(changed, left, top, right, bottom);
    }
}
