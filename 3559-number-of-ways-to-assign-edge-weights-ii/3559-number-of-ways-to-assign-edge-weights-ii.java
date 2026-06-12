class Solution {
    static final int MOD = 1_000_000_007;
    int LOG;
    List<Integer>[] graph;
    int[][] up;
    int[] depth;
    long[] pow2;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 1);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int l = lca(u, v);
            int dist = depth[u] + depth[v] - 2 * depth[l];

            if (dist == 0)
                ans[i] = 0;
            else
                ans[i] = (int) pow2[dist - 1];
        }

        return ans;
    }

    void dfs(int node, int parent) {
        up[node][0] = parent;

        for (int next : graph[node]) {
            if (next != parent) {
                depth[next] = depth[node] + 1;
                dfs(next, node);
            }
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }

        int diff = depth[u] - depth[v];

        for (int j = LOG - 1; j >= 0; j--) {
            if (((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }

        if (u == v)
            return u;

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }
}