
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;
        
        // Maps the reversed value to the most recent index that generated it
        Map<Integer, Integer> reversedValToIndex = new HashMap<>();

        for (int j = 0; j < n; ++j) {
            int currentVal = nums[j];
            
            // Check if any previous element i < j had reverse(nums[i]) == nums[j]
            if (reversedValToIndex.containsKey(currentVal)) {
                minDistance = Math.min(minDistance, j - reversedValToIndex.get(currentVal));
            }
            
            // Store or update the mapped index for reverse(nums[j])
            reversedValToIndex.put(reverse(currentVal), j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverse(int x) {
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }
}