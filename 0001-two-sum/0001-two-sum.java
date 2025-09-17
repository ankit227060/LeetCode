import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in the map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store current number with its index
            map.put(nums[i], i);
        }

        // Since exactly one solution exists, we never reach here
        return new int[] {};
    }
}
