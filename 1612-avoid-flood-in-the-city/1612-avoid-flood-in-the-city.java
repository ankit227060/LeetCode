import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> lakeToLastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                result[i] = -1;
                if (lakeToLastRain.containsKey(lake)) {
                    
                    int lastRainDay = lakeToLastRain.get(lake);
                    Integer dryDay = dryDays.ceiling(lastRainDay + 1);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    result[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lakeToLastRain.put(lake, i);
            } else {
                dryDays.add(i); 
                result[i] = 1;  
            }
        }

        return result;
    }
}
