class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num:nums){
            result ^= num;
        }
        return result ;
    }
}

// using XOR to cencel out duplicate values