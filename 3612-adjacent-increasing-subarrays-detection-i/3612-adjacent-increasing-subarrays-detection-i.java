class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        
        for(int i=0; i+2*k<=nums.size(); i++){
            if(helper(nums, i, k)&&helper(nums, i+k, k)){
                return true;
            }
        }
        return false;
    }

    boolean helper(List<Integer> nums, int x, int k){
        for(int i=x+1; i<x+k; i++){
            if(nums.get(i)<=nums.get(i-1)) return false;
        }
        return true;
    }
}