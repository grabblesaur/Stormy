package com.qqq.stormy.model;

import com.qqq.stormy.R;

import java.util.HashMap;
import java.util.Map;

public class IconManager {

    private static String[] mIconsNames = {"clear-day", "clear-night", "rain", "snow",
            "sleet", "wind", "fog", "cloudy", "partly-cloudy-day", "partly-cloudy-night"};
    private static int[] mIconsId = {R.drawable.clear_day, R.drawable.clear_night, R.drawable.rain,
            R.drawable.snow, R.drawable.fog, R.drawable.sleet, R.drawable.wind, R.drawable.fog,
            R.drawable.cloudy, R.drawable.partly_cloudy, R.drawable.cloudy_night};

    public static int getIconId(String iconName) {
        for (int i = 0; i < mIconsNames.length; i++) {
            if (iconName.equals(mIconsNames[i])) {
                return mIconsId[i];
            }
        }

        return R.drawable.partly_cloudy;
    }
}
