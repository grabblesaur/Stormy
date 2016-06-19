package com.qqq.stormy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qqq.stormy.R;
import com.qqq.stormy.model.day.DailyData;

import java.util.List;

public class DailyAdapter extends BaseAdapter{
    private Context mContext;
    private List<DailyData> mDailyDataList;

    public DailyAdapter(Context context, List<DailyData> dailyDataList) {
        mContext = context;
        mDailyDataList = dailyDataList;
    }

    @Override
    public int getCount() {
        return mDailyDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDailyDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null);
            holder = new ViewHolder();
            holder.iconImageView = (ImageView) convertView.findViewById(R.id.iv_daily_weather_icon);
            holder.temperatureMaxLabel = (TextView) convertView.findViewById(R.id.tv_max_temperature);
            holder.temperatureMinLabel = (TextView) convertView.findViewById(R.id.tv_min_temperature);
            holder.dayOfTheWeekLabel = (TextView) convertView.findViewById(R.id.tv_day_name_label);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DailyData dailyData = mDailyDataList.get(position);

        holder.iconImageView.setImageResource(dailyData.getIconId());
        holder.temperatureMaxLabel.setText(dailyData.getTemperatureMaxF());
        holder.temperatureMinLabel.setText(dailyData.getTemperatureMinF());
        holder.dayOfTheWeekLabel.setText(dailyData.getDayOfTheWeek());

        return convertView;
    }

    private static class ViewHolder {
        ImageView iconImageView;
        TextView temperatureMaxLabel;
        TextView temperatureMinLabel;
        TextView dayOfTheWeekLabel;
    }
}
