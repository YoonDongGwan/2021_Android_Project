package com.example.inucalc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.List;

public class CustomProgressbar extends ProgressBar {

    private int mWidth = 20;    //프로그래스바 굵기
    private final RectF rectF = new RectF();
    private final Paint progressPaint = new Paint();//프로그래스바
    List<percent> list;
    int sum = 0;
    float count;
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
        drawlist(list,canvas);
        super.onDraw(canvas);
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public void drawlist(List<percent> list, Canvas canvas){
        this.list = list;
        if (list != null){
            Log.d("test",list.get(0).grade);
            for (int i=0; i<list.size(); i++){
                sum += list.get(i).percent;
            }
            for (int i = 0; i < list.size(); i++) {
                count = list.get(i).percent;
                switch (list.get(i).grade) {
                    case "A+":
                        progressPaint.setColor(Color.rgb(255,114,114));
                        canvas.drawArc(rectF, 270, (count/sum)*360, false, progressPaint);
                        Log.d("test",(list.get(i).percent/sum)*360+"");
                        break;
                    case "A0":
                        break;
                    case "B+":
                        break;
                    case "B0":
                        break;
                    case "C+":
                        break;
                    case "C0":
                        break;
                    case "D+":
                        break;
                    case "D0":
                        break;

                }
            }
//            progressPaint.setColor(Color.rgb(255,114,114));
//            canvas.drawArc(rectF, 270, 90, false, progressPaint);
//            progressPaint.setColor(Color.rgb(252,175,23));
//            canvas.drawArc(rectF, 0+10, 90, false, progressPaint);
//            progressPaint.setColor(Color.rgb(186,234,0));
//            canvas.drawArc(rectF, 90+20, 40, false, progressPaint);
//            progressPaint.setColor(Color.rgb(94,172,250));
//            canvas.drawArc(rectF, 130+30, 20, false, progressPaint);
//            progressPaint.setColor(Color.rgb(221,140,226));
//            canvas.drawArc(rectF, 150+40, 70, false, progressPaint);

        }
    }
}

