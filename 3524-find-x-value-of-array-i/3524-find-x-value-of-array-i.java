class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int rem = num % k;
            long[] next = new long[k];
            next[rem]++;

            for (int r = 0; r < k; r++) {
                next[(r * rem) % k] += dp[r];
            }

            dp = next;

            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}