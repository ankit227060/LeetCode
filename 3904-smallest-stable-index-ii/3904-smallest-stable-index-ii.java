class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suf = new int[n];
        int mn = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            mn = Math.min(mn, nums[i]);
            suf[i] = mn;
        }

        int mx = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            if (mx - suf[i] <= k) return i;
        }

        return -1;
    }
}