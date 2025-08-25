class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int f=target-nums[i];
            for(int j=0;j<n;j++){
                if(i!=j&&f==nums[j])return new int[] {i,j};
            }
        }
        return new int[0];
    }
}