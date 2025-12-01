class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total = 0L;
        for (int b : batteries) total += b;

        long low = 0L;
        long high = total / n;

        while (low < high) {
            long mid = low + (high - low + 1) / 2;

            long usable = 0L;
            for (int b : batteries) {
                usable += Math.min((long)b, mid);
                if (usable >= mid * n) break;
            }

            if (usable >= mid * n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}