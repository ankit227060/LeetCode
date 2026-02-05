class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];
        for(int index=0;index<length;index++){
            if(nums[index]==0){
                result[index]=0;
                continue;
            }
            int pos=((index+nums[index]%length + length)%length);
            result[index] = nums[pos];
        }
        return result;
    }
}