package com.vivint.fancytext;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

/**
 * Created by Dustin on 12/10/15.
 */
public class FrameSpan extends ReplacementSpan {

    private int _width;
    private Paint _paint;

    public FrameSpan() {
        _paint = new Paint();
        _paint.setStyle(Paint.Style.STROKE);
        _paint.setColor(Color.BLUE);
        _paint.setAntiAlias(true);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        //return text with relative to the Paint
        _width = (int) paint.measureText(text, start, end);
        return _width;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        //draw the frame with custom Paint
        canvas.drawRect(x, top, x + _width, bottom, _paint);
    }
}
