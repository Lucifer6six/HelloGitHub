package com.up.problemrepair.view;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.up.problemrepair.hellogithub.R;

/**
 * author Mzy
 * date 2019/3/18
 * 写bug啊
 */
public class LineView {
    private  Context mContext;
    private LinearLayout mLinearLayout;
    public LineView(Context context){
        this.mContext = context;
    }
    public View getLineView(){
        LayoutInflater lf = LayoutInflater.from(mContext);
        View view = lf.inflate(R.layout.layout,null);
        TextView tv = view.findViewById(R.id.hhhTv);
        tv.setText("噢噢哦哦哦哦哦哦哦");
        return  view;
    }

}
