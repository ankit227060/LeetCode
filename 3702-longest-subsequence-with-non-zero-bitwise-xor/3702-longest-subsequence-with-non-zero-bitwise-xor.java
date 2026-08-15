class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = nums.length; 
        int nonZero = 0; 
        int _xor = 0; 
        for(int x: nums) {
            _xor ^= x; 
            if(x != 0) nonZero++; 
        }
        if(_xor != 0) return ans; 
        if(nonZero == 0) return 0; 
        return ans - 1; 
    }
}