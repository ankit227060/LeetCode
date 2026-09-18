class Solution {
    private int checkRight(String s, int i, int[] l, int[] r) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (l[c] < i) return -1;
            right = Math.max(right, r[c]);
        }
        return right;
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, Integer.MAX_VALUE);
        Arrays.fill(r, Integer.MIN_VALUE);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            l[c] = Math.min(l[c], i);
            r[c] = i;
        }

        List<String> ans = new ArrayList<>();
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (l[c] == i) {
                int nRight = checkRight(s, i, l, r);
                if (nRight != -1) {
                    if (i > right) ans.add("");
                    right = nRight;
                    ans.set(ans.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        return ans;
    }
}