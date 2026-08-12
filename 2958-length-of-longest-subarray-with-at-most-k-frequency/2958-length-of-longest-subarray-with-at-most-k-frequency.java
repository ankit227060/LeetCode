class Solution {
  public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0, n = nums.length;
        int maxLen = 0;
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            if (mp.get(nums[j]) > k) {
                while (mp.get(nums[j]) > k) {
                    mp.put(nums[i], mp.get(nums[i]) - 1);
                    if (mp.get(nums[i]) == 0) {
                        mp.remove(nums[i]);
                    }
                    i++;
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}