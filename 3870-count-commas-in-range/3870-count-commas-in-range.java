class Solution {
    public int countCommas(int n) {
        if (n >= 1000) return n - 1000 + 1;
        else return 0;
    }
}