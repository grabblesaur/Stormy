package com.qqq.stormy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qqq.stormy.R;
import com.qqq.stormy.adapter.HourlyAdapter;
import com.qqq.stormy.model.hour.HourlyData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyActivity extends AppCompatActivity {
    @BindView(R.id.hourly_recycler_view) RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<HourlyData> mHourlyDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly);
        ButterKnife.bind(this);

        mHourlyDataList = getIntent().getParcelableArrayListExtra(MainActivity.HOURLY_FORECAST);
        Log.d(MainActivity.TAG, "mHourlyDataList was successfully transferred");

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new HourlyAdapter(mHourlyDataList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
    }
}
