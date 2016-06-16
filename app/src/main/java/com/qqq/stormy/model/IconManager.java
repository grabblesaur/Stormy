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

    private static Map<String, Integer> mIconsHashMap = new HashMap<>();

    public IconManager() {
        for (int i = 0; i < mIconsNames.length; i++) {
            mIconsHashMap.put(mIconsNames[i], mIconsId[i]);
        }
    }

    public static int getIconId(String iconName) {
        if (mIconsHashMap.containsKey(iconName)) {
            return mIconsHashMap.get(iconName);
        } else {
            return R.drawable.clear_day;
        }
    }
}
