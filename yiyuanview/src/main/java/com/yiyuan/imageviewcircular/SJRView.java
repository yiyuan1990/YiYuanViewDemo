package com.yiyuan.imageviewcircular;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by ShiJunRan on 2019/6/27
 */
public class SJRView extends View {
    private String TAG = "SSSSSS";
    private Paint mPaint;
    private Paint bPaint;
    int pointSize;

    public SJRView(Context context) {
        super(context);
    }

    public SJRView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SJRView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SJRView);
        pointSize = typedArray.getInt(R.styleable.SJRView_pointSize, 10);
        typedArray.recycle();


        bPaint = new Paint();
        bPaint.setColor(Color.RED);
        //通过Paint的API来设置抗锯齿效果
        bPaint.setAntiAlias(true);
        bPaint.setStrokeWidth(pointSize);
        bPaint.setStrokeCap(Paint.Cap.BUTT);


        //设置Paint的文字对齐方式
        mPaint = new Paint();
//        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(60);
        mPaint.setColor(Color.BLUE);
        //设置字体加粗
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mPaint.setStyle(Paint.Style.STROKE);
        //通过Paint的API来设置抗锯齿效果
        mPaint.setAntiAlias(true);


    }

    //    float fl[] = new float[]{10, 20, 50, 20, 100, 20, 150, 20, 200, 20};
    float fl[];

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), 15, 15, bPaint);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), bPaint);
        Log.i(TAG, "MeasuredHeight: " + getMeasuredHeight() + "\nHeight" + getHeight() + "\nTextSize" + mPaint.getTextSize());
        float with = mPaint.measureText("测试画笔");
        int num = getWidth() / pointSize;
        fl = new float[num * 2];
        for (int i = 0; i < fl.length; i++) {
            if (i % 2 == 0) {
                fl[i] = i * pointSize;
            } else {
                fl[i] = 0;
            }
        }

//        canvas.drawText("测试画笔", 0, (getMeasuredHeight() + mPaint.getTextSize()) / 2, mPaint);
        canvas.drawPoints(fl, bPaint);
//        canvas.drawPoint(0,0,bPaint);


    }
}
