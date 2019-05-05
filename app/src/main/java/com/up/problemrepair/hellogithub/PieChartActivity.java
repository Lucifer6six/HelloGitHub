package com.up.problemrepair.hellogithub;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.up.problemrepair.view.PieChart;
import com.up.problemrepair.view.PieData;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {
    private PieChart mPieChart;
    private List<PieData> pieData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        mPieChart = findViewById(R.id.pieChart);
        pieData = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            pieData.add(new PieData("text" + i, (float) Math.random() * 90));
        }
        mPieChart.setmStartAngle(0.5f);
        mPieChart.setData(pieData, 0);
       /* List<PieEntry> yvals = new ArrayList<>();
        yvals.add(new PieEntry(2.0f, "本科"));
        yvals.add(new PieEntry(3.0f, "硕士"));
        yvals.add(new PieEntry(4.0f, "博士"));
        yvals.add(new PieEntry(5.0f, "大专"));
        yvals.add(new PieEntry(1.0f, "其他"));
// 设置每份的颜色
        List<Integer> colors = new ArrayList<>();
        colors.add(Color.parseColor("#6785f2"));
        colors.add(Color.parseColor("#675cf2"));
        colors.add(Color.parseColor("#496cef"));
        colors.add(Color.parseColor("#aa63fa"));
        colors.add(Color.parseColor("#f5a658"));

        PieChartManagger pieChartManagger = new PieChartManagger(mPieChart);
        pieChartManagger.showRingPieChart(yvals,colors);*/
    }
}
