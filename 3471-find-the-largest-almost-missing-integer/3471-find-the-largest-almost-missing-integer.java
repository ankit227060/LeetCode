class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] arr = new int[51];

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
            max = Math.max(max, nums[i]);
        }

        if(k == nums.length)
            return max;

        if(k == 1){
            for(int i = 50; i >= 0; i--){
                if(arr[i] == 1)
                    return i;
            }
            return -1;
        }

        if(arr[nums[0]] == 1 && arr[nums[nums.length - 1]] == 1)
            return Math.max(nums[0], nums[nums.length - 1]);

        if(arr[nums[0]] == 1 && arr[nums[nums.length - 1]] != 1)
            return nums[0];

        if(arr[nums[0]] != 1 && arr[nums[nums.length - 1]] == 1)
            return nums[nums.length - 1];

        return -1;
    }
}