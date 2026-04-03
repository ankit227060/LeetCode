class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] r = new int[n][2];
        HashSet<Integer> rs = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            r[i][0] = robots[i];
            r[i][1] = distance[i];
            rs.add(robots[i]);
        }
        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));
        
        int bw = 0;
        ArrayList<Integer> vwList = new ArrayList<>();
        for (int w : walls) {
            if (rs.contains(w)) bw++;
            else vwList.add(w);
        }
        Collections.sort(vwList);
        int[] vw = new int[vwList.size()];
        for (int i = 0; i < vwList.size(); i++) vw[i] = vwList.get(i);
        
        int[][] dp = new int[n][2];
        dp[0][0] = getW(vw, r[0][0] - r[0][1], r[0][0] - 1);
        dp[0][1] = 0;
        
        for (int i = 1; i < n; i++) {
            int L = r[i - 1][0], R = r[i][0];
            int d1 = r[i - 1][1], d2 = r[i][1];
            
            int eR = Math.min(R - 1, L + d1);
            int sL = Math.max(L + 1, R - d2);
            
            int wR = getW(vw, L + 1, eR);
            int wL = getW(vw, sL, R - 1);
            int wBoth = (eR >= sL) ? getW(vw, L + 1, R - 1) : wR + wL;
            
            dp[i][0] = Math.max(dp[i - 1][0] + wL, dp[i - 1][1] + wBoth);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + wR);
        }
        
        int wEnd = getW(vw, r[n - 1][0] + 1, r[n - 1][0] + r[n - 1][1]);
        int ans = Math.max(dp[n - 1][0], dp[n - 1][1] + wEnd);
        
        return ans + bw;
    }
    
    private int getW(int[] vw, int x, int y) {
        if (x > y) return 0;
        int i1 = lowerBound(vw, x);
        int i2 = upperBound(vw, y);
        return i2 - i1;
    }
    
    private int lowerBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] >= key) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    
    private int upperBound(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] > key) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}