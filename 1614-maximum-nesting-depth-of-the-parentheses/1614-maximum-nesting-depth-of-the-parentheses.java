class Solution {
    public int maxDepth(String s) {
        int left = 0;
        int right = 0;
        int max1 = 0;

        for (char i : s.toCharArray()) {
            if (i == '(') {
                left++;
            }

            if (i == ')') {
                right++;
            }

            max1 = Math.max(max1, left - right);
        }

        return max1;
    }
}