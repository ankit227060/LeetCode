class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n >> 1; i++)
            res = Math.max(res, nums[n - 1 - i] + nums[i]);

        return res;
    }
}
