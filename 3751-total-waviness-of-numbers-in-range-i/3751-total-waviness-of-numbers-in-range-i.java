class Solution {
    private int waviness(int num) {
        String s = String.valueOf(num);
        int cnt = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if ((s.charAt(i) > s.charAt(i - 1) &&
                 s.charAt(i) > s.charAt(i + 1)) ||
                (s.charAt(i) < s.charAt(i - 1) &&
                 s.charAt(i) < s.charAt(i + 1))) {
                cnt++;
            }
        }

        return cnt;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }
}