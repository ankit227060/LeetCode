class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX = 2048; 
        boolean _xor[] = new boolean[MAX + 1]; 
        boolean _xor_final[] = new boolean[MAX + 1]; 
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                _xor[nums[i] ^ nums[j]] = true; 
            }
        }
        int cnt = 0; 
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <= MAX; j++) {
                if(_xor[j]) {
                    int x = nums[i] ^ j; 
                    if(!_xor_final[x]) {
                        cnt++; 
                        _xor_final[x] = true; 
                    }
                }
            }
        }
        return cnt; 
    }
}