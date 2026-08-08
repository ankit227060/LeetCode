class Solution {
    public int[] validSequence(String word1, String word2) {
        int n2 = word2.length();

        int[] dp2 = new int[n2];
        Arrays.fill(dp2, -1);

        int j = n2 - 1;

        for (int i = word1.length() - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp2[j] = i;
                j--;
            }
        }

        int changed = 0;
        j = 0;

        int[] res = new int[n2];
        int size = 0;

        for (int i = 0; i < word1.length(); i++) {
            if (j >= n2) {
                break;
            }

            if (word1.charAt(i) == word2.charAt(j)) {
                res[size++] = i;
                j++;
            } else if (changed == 0) {
                if (j == n2 - 1 || i + 1 <= dp2[j + 1]) {
                    changed = 1;
                    res[size++] = i;
                    j++;
                }
            }
        }

        if (j != n2) {
            return new int[0];
        }

        return Arrays.copyOf(res, size);
    }
}