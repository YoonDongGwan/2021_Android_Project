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

import java.util.ArrayList;
import java.util.List;

public class CustomProgressbar extends ProgressBar {

    private int mWidth = 20;
    private final RectF rectF = new RectF();
    private final Paint progressPaint = new Paint();
    List<percent> list;
    float count;
    List<Float> test = new ArrayList<>();

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

    public void init(AttributeSet attrs, int style) {

        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setStrokeWidth(dpToPx(mWidth));
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        rectF.set(30, 30, dpToPx(300) - 30, dpToPx(300) - 30);
        test.add(0,(float)270);
        }



    @Override
    protected synchronized void onDraw(Canvas canvas) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                switch (list.get(i).grade) {
                    case "A+":
                        progressPaint.setColor(Color.rgb(255, 114, 114));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "A0":
                        progressPaint.setColor(Color.rgb(252, 175, 23));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "B+":
                        progressPaint.setColor(Color.rgb(186, 234, 0));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "B0":
                        progressPaint.setColor(Color.rgb(94, 172, 250));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "C+":
                        progressPaint.setColor(Color.rgb(221, 140, 226));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "C0":
                        progressPaint.setColor(Color.rgb(204, 204, 204));
                        canvas.drawArc(rectF, test.get(i), (list.get(i).percent/count)*(360-(list.size()*10)), false, progressPaint);
                        CalculatePosition(i,list.size());
                        break;
                    case "D+":
                        break;
                    case "D0":
                        break;

                }
            }
            super.onDraw(canvas);
        }
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public void putList(List<percent> list) {
        this.list = list;
        for(int i=0;i<list.size();i++){
            this.count += list.get(i).percent;
        }
    }
    public void CalculatePosition(int position, int size){
        if(test.get(position)+((list.get(position).percent/count)*(360-(size*10)))>360) {
            test.add(test.get(position)+((list.get(position).percent/count)*(360-(size*10))) - 350);
        }
        else{   test.add(position + 1, test.get(position) + ((list.get(position).percent / count) * (360-(size*10))) + 10);}
    }
}



