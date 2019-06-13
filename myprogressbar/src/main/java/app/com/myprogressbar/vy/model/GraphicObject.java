package app.com.myprogressbar.vy.model;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Vishal Yadav :- 173020181303HRS
 */

public abstract class GraphicObject {
    protected Paint paint;

    public GraphicObject() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public void setColor(int color) {
        paint.setColor(color);
    }

    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    public void setWidth(float width) {
        paint.setStrokeWidth(width);
    }

    public void setStyle(Paint.Style style) {
        paint.setStyle(style);
    }

    public abstract void draw(Canvas canvas);
}
