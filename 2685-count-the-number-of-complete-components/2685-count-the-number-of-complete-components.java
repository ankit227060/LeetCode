import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        boolean[] vis = new boolean[n];
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            vis[i] = true;
            
            while (!q.isEmpty()) {
                int curr = q.poll();
                comp.add(curr);
                for (int next : adj[curr]) {
                    if (!vis[next]) {
                        vis[next] = true;
                        q.add(next);
                    }
                }
            }
            
            boolean ok = true;
            for (int node : comp) {
                if (adj[node].size() != comp.size() - 1) {
                    ok = false;
                    break;
                }
            }
            if (ok) res++;
        }
        return res;
    }
}
