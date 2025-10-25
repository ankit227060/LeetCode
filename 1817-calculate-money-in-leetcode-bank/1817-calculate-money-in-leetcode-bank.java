class Solution {
    public int totalMoney(int n) {
        int w = n / 7; // weeks
        int d = n % 7; // days
        
        return (w * (49 + 7 * w) + d * (2 * w + d + 1)) / 2;}
}