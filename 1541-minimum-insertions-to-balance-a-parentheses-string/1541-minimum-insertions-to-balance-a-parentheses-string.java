class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int openNeeded = 0;
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                openNeeded++;
                i++;
            } else {
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i += 2;
                } else {
                    ans++;
                    i++;
                }

                openNeeded--;
                if (openNeeded < 0) {
                    ans++;
                    openNeeded = 0;
                }
            }
        }

        return ans + (openNeeded * 2);
    }
}
