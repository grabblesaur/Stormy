package com.qqq.stormy.activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qqq.stormy.R;
import com.qqq.stormy.adapter.DailyAdapter;
import com.qqq.stormy.model.day.DailyData;

import java.util.List;

public class DailyActivity extends ListActivity {
    private List<DailyData> mDailyDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);

        mDailyDataList = getIntent().getParcelableArrayListExtra(MainActivity.DAILY_FORECAST);
        Log.v(MainActivity.TAG, "mDailyDataList was successfully received: " + mDailyDataList);

        DailyAdapter dailyAdapter = new DailyAdapter(this, mDailyDataList);
        setListAdapter(dailyAdapter);
    }
}
