package app.com.myprogressbar.vy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import app.com.myprogressbar.R;
import app.com.myprogressbar.customization.SettingIndicatorHere;
import app.com.myprogressbar.vy.callback.InvalidateListener;
import app.com.myprogressbar.vy.util.LoaderGenerator;
import app.com.myprogressbar.vy.util.LoaderView;


/**
 * Created by Tuyen Nguyen on 2/5/17.
 */

public class VYLoader extends View implements InvalidateListener {
  public static LoaderView loaderView;
  public static TypedArray typedArray;
  public VYLoader(Context context) {
    super(context);
    initialize(context, null, SettingIndicatorHere.myStaticValue);
  }

  public VYLoader(Context context, AttributeSet attrs) {
    super(context, attrs);
    initialize(context, attrs, SettingIndicatorHere.myStaticValue);
  }

  public VYLoader(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    initialize(context, attrs, defStyleAttr);
  }

  public static void initialize(Context context, AttributeSet attrs, int defStyleAttr) {
     typedArray = context.obtainStyledAttributes(attrs, R.styleable.VYLoader);
   /* int loaderType = typedArray.getInt(R.styleable.VYLoader_VY_type,-1);

//    loaderView = LoaderGenerator.generateLoaderView(loaderType);*/

    loaderView = LoaderGenerator.generateLoaderView(SettingIndicatorHere.myStaticValue);
    loaderView.setColor(typedArray.getColor(R.styleable.VYLoader_VY_color, Color.parseColor("#ffffff")));

    typedArray.recycle();
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    final int measuredWidth = resolveSize(loaderView.getDesiredWidth(), widthMeasureSpec);
    final int measuredHeight = resolveSize(loaderView.getDesiredHeight(), heightMeasureSpec);

    setMeasuredDimension(measuredWidth, measuredHeight);
  }

  @Override
  protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
    loaderView.setSize(getWidth(), getHeight());
    loaderView.initializeObjects();
    loaderView.setUpAnimation();
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    loaderView.draw(canvas);
  }

  @Override
  public void reDraw() {
    invalidate();
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (loaderView != null && loaderView.isDetached()) {
      loaderView.setInvalidateListener(this);
    }
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (loaderView != null) {
      loaderView.onDetach();
    }
  }
}
