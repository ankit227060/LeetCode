import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length(), ones = 0, groupCount = 0;
        char[] c = s.toCharArray();
        for (char x : c) if (x == '1') ones++;
        
        int[] gStart = new int[n], gLen = new int[n], zeroGroupIndex = new int[n];
        for (int i = 0; i < n; i++) {
            if (c[i] == '0') {
                if (i > 0 && c[i - 1] == '0') gLen[groupCount - 1]++;
                else { gStart[groupCount] = i; gLen[groupCount] = 1; groupCount++; }
            }
            zeroGroupIndex[i] = groupCount - 1;
        }

        int q = queries.length;
        List<Integer> ans = new ArrayList<>(q);
        if (groupCount == 0) {
            for (int i = 0; i < q; i++) ans.add(ones);
            return ans;
        }

        int m = groupCount - 1, LOG = m > 0 ? 32 - Integer.numberOfLeadingZeros(m) : 0;
        int[][] st = new int[LOG][];
        if (m > 0) {
            st[0] = new int[m];
            for (int i = 0; i < m; i++) st[0][i] = gLen[i] + gLen[i + 1];
            for (int k = 1; k < LOG; k++) {
                int half = 1 << (k - 1), len = m - (1 << k) + 1;
                st[k] = new int[len];
                for (int j = 0; j < len; j++) st[k][j] = Math.max(st[k - 1][j], st[k - 1][j + half]);
            }
        }

        for (int[] query : queries) {
            int l = query[0], r = query[1], lg = zeroGroupIndex[l], rg = zeroGroupIndex[r];
            int left = lg == -1 ? -1 : gLen[lg] - (l - gStart[lg]), right = rg == -1 ? -1 : r - gStart[rg] + 1;
            int rEndGroup = c[r] == '1' ? rg : rg - 1, startAdj = lg + 1, endAdj = rEndGroup - 1, active = ones;

            if (c[l] == '0' && c[r] == '0' && lg + 1 == rg) active = Math.max(active, ones + left + right);
            else if (startAdj <= endAdj) {
                int k = 31 - Integer.numberOfLeadingZeros(endAdj - startAdj + 1);
                active = Math.max(active, ones + Math.max(st[k][startAdj], st[k][endAdj - (1 << k) + 1]));
            }
            if (c[l] == '0' && lg + 1 <= rEndGroup) active = Math.max(active, ones + left + gLen[lg + 1]);
            if (c[r] == '0' && lg < rg - 1) active = Math.max(active, ones + right + gLen[rg - 1]);
            ans.add(active);
        }
        return ans;
    }
}
