class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;

        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j] == target)count++;

                if((j-i+1)/2 < count){
                    res++;
                }
            }
        }

        return res;
    }
}