class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int ts = 0;
        for(int i : nums) ts += i;
        int cs = 0;
        int count = 0;
        for(int i = 0;i<n-1;i++){
            cs += nums[i];
            ts -= nums[i];
            if((ts-cs)%2==0) count++;
        }
        return count;
    }
}