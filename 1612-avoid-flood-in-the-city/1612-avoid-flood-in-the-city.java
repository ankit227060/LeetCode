import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> lakeToLastRain = new HashMap<>(); // lake -> last rain index
        TreeSet<Integer> dryDays = new TreeSet<>(); // indices of 0s

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                result[i] = -1; // raining day
                if (lakeToLastRain.containsKey(lake)) {
                    // Already full, need to dry before
                    int lastRainDay = lakeToLastRain.get(lake);
                    Integer dryDay = dryDays.ceiling(lastRainDay + 1); // find dry day after last rain
                    if (dryDay == null) {
                        return new int[0]; // flood can't be avoided
                    }
                    result[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                lakeToLastRain.put(lake, i); // update last rain day
            } else {
                dryDays.add(i); // store dry day index
                result[i] = 1;  // temporary default value, will be replaced if we use this day
            }
        }

        return result;
    }
}
