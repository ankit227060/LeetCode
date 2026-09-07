class Solution {
    public int distinctSubseqII(String s) {
        long sum = 0;
        long[] count = new long[26];
        int mod = 1000000007;
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (sum < count[c]) sum += mod;
            long cur = 1 + sum - count[c];
            count[c] = (1 + sum) % mod;
            sum = (sum + cur) % mod;
        }
        return (int) sum;
    }
}