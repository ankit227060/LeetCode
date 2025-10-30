class Solution {
    public int minNumberOperations(int[] target) {
        int res = 0;
        int prev = 0;
        for (int x : target) {
            if (x > prev) {
                res += x - prev;
            }
            prev = x;
        }
        return res;
    }
}

