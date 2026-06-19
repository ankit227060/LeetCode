class Solution {
    public int largestAltitude(int[] gain) {
        int c = 0; int n = 0;
        for (int i = 0; i < gain.length; i++) {
            n += gain[i];
            c = Math.max(c, n);
        }
        return c;
    }
}