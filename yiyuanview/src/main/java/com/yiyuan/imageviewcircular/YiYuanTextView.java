package com.yiyuan.imageviewcircular;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ShiJunRan on 2019/6/28
 */
public class YiYuanTextView extends View {
    private Paint mPaint;
    String text;
    int textSize;
    String textColor;
    int textStyle;

    public YiYuanTextView(Context context) {
        super(context);
    }

    public YiYuanTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public YiYuanTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.YiYuanTextView);
        text = typedArray.getString(R.styleable.YiYuanTextView_text);
        textSize = typedArray.getInteger(R.styleable.YiYuanTextView_textSize, 14);
        textColor = typedArray.getString(R.styleable.YiYuanTextView_textColor);
        textStyle = typedArray.getInteger(R.styleable.YiYuanTextView_textStyle, 0);

        typedArray.recycle();
        //设置Paint的文字对齐方式
        mPaint = new Paint();
        mPaint.setTextSize(sp2px(textSize));
        mPaint.setColor(Color.parseColor(textColor));
        //设置字体加粗
        switch (textStyle) {
            case 0://默认
                mPaint.setTypeface(Typeface.SANS_SERIF);
                break;
            case 1://
                mPaint.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 2://
                mPaint.setTypeface(Typeface.SERIF);
                break;
            case 3://
                mPaint.setTypeface(Typeface.MONOSPACE);
                break;
        }

        mPaint.setStyle(Paint.Style.FILL);
        //通过Paint的API来设置抗锯齿效果
        mPaint.setAntiAlias(true);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
    }

    int num;
    int mX;
    float textWidth;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mX = getWidth() - num;
        if (text != null && !text.equals("")) {
            textWidth = mPaint.measureText(text);
            canvas.drawText(text, mX, 100, mPaint);
        }

    }

    Timer timer;

    public void startRun() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                num++;
                if (mX + textWidth < 0) {
                    num = 0;
                }
                postInvalidate();
            }
        }, 0, 10);
    }

    public void stopRun() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void reStartRun() {
        num = 0;
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                num++;
                if (mX + textWidth < 0) {
                    num = 0;
                }
                postInvalidate();
            }
        }, 0, 10);

    }

    /**
     * dp转px
     *
     * @param dp dp值
     * @return px值
     */
    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    /**
     * sp转px
     *
     * @param sp sp值
     * @return px值
     */
    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                getResources().getDisplayMetrics());
    }
}
