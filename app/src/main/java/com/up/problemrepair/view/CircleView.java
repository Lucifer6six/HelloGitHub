package com.up.problemrepair.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.up.problemrepair.hellogithub.R;


/**
 * author Mzy
 * date 2018/12/10
 */
public class CircleView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor = Color.RED;
    private static final String TAG = "CircleView";
    public CircleView(Context context) {
        super(context);
        Log.e(TAG,"CircleView(Context context");
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CircleView);
        Log.e(TAG,"CircleView1 mColor = "+mColor);
        mColor = array.getColor(R.styleable.CircleView_circle_color,Color.RED);
        Log.e(TAG,"CircleView2 mColor = "+mColor);
        array.recycle();
        init();
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.e(TAG,"CircleView(Context context, @Nullable AttributeSet attrs)");
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CircleView);
        Log.e(TAG,"CircleView1 mColor = "+mColor);
        mColor = array.getColor(R.styleable.CircleView_circle_color,Color.RED);
        Log.e(TAG,"CircleView2 mColor = "+mColor);
        array.recycle();
        init();
    }

    private void init() {
        Log.e(TAG,"init mColor = "+mColor);
        mPaint.setColor(mColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBotton = getPaddingBottom();
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingBotton - paddingTop;
        int radius = Math.min(width, height) / 2;
        Log.e(TAG,"onDraw mColor = "+mPaint.getColor());
        canvas.drawCircle(paddingLeft + width / 2, paddingRight + height / 2, radius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = (int) this.getContext().getResources().getDimension(R.dimen.cricleView_width);
        int height = (int) this.getContext().getResources().getDimension(R.dimen.cricleView_height);
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(width, height);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(heightSpecSize, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, widthSpecSize);
        }
    }
}
