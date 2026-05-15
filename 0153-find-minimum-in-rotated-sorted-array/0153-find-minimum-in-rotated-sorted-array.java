class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}