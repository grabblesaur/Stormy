package com.qqq.stormy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qqq.stormy.R;
import com.qqq.stormy.model.hour.HourlyData;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {
    private List<HourlyData> mHourlyDataList;

    public HourlyAdapter(List<HourlyData> hourlyDataList) {
        mHourlyDataList = hourlyDataList;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hourly_list_item, parent, false);

        return new HourlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        holder.bindHourlyData(mHourlyDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHourlyDataList.size();
    }

    public class HourlyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTimeLabel;
        public TextView mTemperatureLabel;
        public ImageView mIconWeather;
        public TextView mSummaryLabel;

        public HourlyViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = (TextView) itemView.findViewById(R.id.tv_hourly_time);
            mTemperatureLabel = (TextView) itemView.findViewById(R.id.tv_hourly_temperature);
            mIconWeather = (ImageView) itemView.findViewById(R.id.iv_hourly_icon_weather);
            mSummaryLabel = (TextView) itemView.findViewById(R.id.tv_hourly_summary);
        }

        public void bindHourlyData(HourlyData hourlyData) {
            mTimeLabel.setText(hourlyData.getFormattedTimeInHours());
            mTemperatureLabel.setText(String.valueOf(hourlyData.getTemperatureInCelsius()));
            mIconWeather.setImageResource(hourlyData.getIconId());
            mSummaryLabel.setText(hourlyData.getSummary());
        }
    }
}
