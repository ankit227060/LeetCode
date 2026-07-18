class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int small = nums[0];
        int big = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (nums[i] > big) {
                big = nums[i];
            }
        }

        return gcd(small, big);
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}