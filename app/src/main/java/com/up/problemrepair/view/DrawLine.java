package com.up.problemrepair.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;

/**
 * author Mzy
 * date 2019/3/13
 * 写bug啊
 */
public class DrawLine extends View {

    private Paint mPaint,mLinePaint ;
    public DrawLine(Context context){
        super(context);
        init();
    }
    public DrawLine(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private int mWidth, mHeight;
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(40, 40, 10, mPaint);

        canvas.drawLine(40, 40,getWidth(),40, mLinePaint);
    }
    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.parseColor("#00ff00"));
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setDither(true);//防止抖动
        mPaint.setStyle(Paint.Style.FILL);//画笔为填充
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.parseColor("#00ff00"));
        mLinePaint.setAntiAlias(true);//抗锯齿
        mLinePaint.setDither(true);//防止抖动
        mLinePaint.setTextSize(40);
        mLinePaint.setStyle(Paint.Style.FILL);//画笔为填充
    }

}
