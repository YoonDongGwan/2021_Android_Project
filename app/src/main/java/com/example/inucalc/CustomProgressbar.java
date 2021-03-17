package com.example.inucalc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CustomProgressbar extends ProgressBar {

    private int mWidth = 20;    //프로그래스바 굵기
    private final RectF rectF = new RectF();
    private final Paint progressPaint = new Paint();   //프로그래스바

    public CustomProgressbar(Context context) {

        super(context);
        init(null, 0);
    }

    public CustomProgressbar(Context context, AttributeSet attrs) {

        super(context, attrs);
        init(attrs, 0);
    }

    public CustomProgressbar(Context context, AttributeSet attrs, int defStyleAttr) {

        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    public void init(AttributeSet attrs, int style){

        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(dpToPx(mWidth));
        progressPaint.setStrokeCap(Paint.Cap.ROUND);

        rectF.set(30,30,dpToPx(300)-30,dpToPx(300)-30);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        progressPaint.setColor(Color.rgb(255,114,114));
        canvas.drawArc(rectF, 270, 90, false, progressPaint);
        progressPaint.setColor(Color.rgb(252,175,23));
        canvas.drawArc(rectF, 0+10, 90, false, progressPaint);
        progressPaint.setColor(Color.rgb(186,234,0));
        canvas.drawArc(rectF, 90+20, 40, false, progressPaint);
        progressPaint.setColor(Color.rgb(94,172,250));
        canvas.drawArc(rectF, 130+30, 20, false, progressPaint);
        progressPaint.setColor(Color.rgb(221,140,226));
        canvas.drawArc(rectF, 150+40, 70, false, progressPaint);
        super.onDraw(canvas);
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}

