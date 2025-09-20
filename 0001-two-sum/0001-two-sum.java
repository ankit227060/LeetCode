// import java.util.*;

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // Map to store number and its index
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int i = 0; i < nums.length; i++) {
//             int complement = target - nums[i];

//             // Check if complement exists in the map
//             if (map.containsKey(complement)) {
//                 return new int[] { map.get(complement), i };
//             }

//             // Otherwise, store current number with its index
//             map.put(nums[i], i);
//         }

//         // Since exactly one solution exists, we never reach here
//         return new int[] {};
//     }
// }


import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] arr = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = arr[left][0] + arr[right][0];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] { arr[left][1], arr[right][1] };
            }
        }

        return new int[0];
    }
}

