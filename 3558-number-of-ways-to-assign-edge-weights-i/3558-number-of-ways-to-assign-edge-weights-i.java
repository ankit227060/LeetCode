import java.util.*;
class Solution {
    private static final int MOD = 1000000007;
    private int func(int pos, int currSumIsOdd, int depth, int[][] dp) {
        if (pos == depth) {
            return dp[pos][currSumIsOdd] = 1 - currSumIsOdd;
        }
        if (dp[pos][currSumIsOdd] != -1) {
            return dp[pos][currSumIsOdd] % MOD;
        }
        long curWays = 0;
        curWays = func(pos + 1, 1 - currSumIsOdd, depth, dp) % MOD;
        curWays += func(pos + 1, currSumIsOdd, depth, dp) % MOD;
        return dp[pos][currSumIsOdd] = (int) (curWays % MOD);
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n + 1];
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        vis[1] = true;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
            depth++;
        }
        depth--;
        int[][] dp = new int[depth + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        long ans = 0;
        ans += func(0, 0, depth - 1, dp);
        ans += func(0, 1, depth - 1, dp);
        return (int) (ans % MOD);
    }
}