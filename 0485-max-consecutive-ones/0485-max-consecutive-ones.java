import java.util.* ;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int ma = 0;
        for (int i =0; i <nums.length ; i++){
            if (nums[i]==1){
                count = count +1;
            }else if (nums[i]==0){
                ma = Math.max(count, ma);
                count =0;
            }
        }
        ma = Math.max(count, ma);
        return ma ;
    }
}