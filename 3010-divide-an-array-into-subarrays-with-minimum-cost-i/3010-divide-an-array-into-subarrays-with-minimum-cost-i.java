// Added using AI
class Solution {
    public int minimumCost(int[] nums) {
        int ans = nums[0];
        Arrays.sort(nums, 1, nums.length);
        ans += nums[1];
        ans += nums[2];
        return ans;
    }
}