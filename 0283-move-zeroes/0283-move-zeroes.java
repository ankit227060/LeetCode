class Solution {
    public void moveZeroes(int[] nums) {
        int lastnonzero = 0;
        for (int i  = 0; i<nums.length ; i++){
            if(nums[i]!=0){
                nums[lastnonzero]=nums[i];
                lastnonzero++;
            }
        }
        for (int i = lastnonzero; i<nums.length;i++){
            nums[i]=0;
        }
    }
}