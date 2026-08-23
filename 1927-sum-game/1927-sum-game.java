class Solution {
    public boolean sumGame(String num) {
        int n = num.length(), half = n / 2;
        int sum1 = 0, sum2 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < half; i++) {
            if (num.charAt(i) == '?') cnt1++;
            else sum1 += num.charAt(i) - '0';
        }

        for (int i = half; i < n; i++) {
            if (num.charAt(i) == '?') cnt2++;
            else sum2 += num.charAt(i) - '0';
        }

        int totalQ = cnt1 + cnt2;
        if (totalQ % 2 == 1) return true;

        return 2 * (sum1 - sum2) != 9 * (cnt2 - cnt1);
    }
}