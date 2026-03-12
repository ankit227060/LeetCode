class Solution {
    public int Comp(int [] a, int [] b) {
        if(a[2] >= b[2]) return -1;
        else if(a[2] < b[2]) return 1;
        return 0;
    }
    public int maxStability(int n, int[][] edges, int k) {
        // If Not single component then no MST -> -1
        // If No of edges with must=1 > n-1 leads to cycle Hence -> -1
        PriorityQueue<int []> pq2 = new PriorityQueue<>((x,y)->Comp(x, y));

        boolean poss = true;
        Disjoint dsu = new Disjoint(n);
        int min = Integer.MAX_VALUE;
        for(int e [] : edges) {
            if(e[3] == 1) {
                poss &= dsu.Join(e[0], e[1]);
                if(!poss) return -1;
                min = Math.min(min, e[2]);
            } else {
                pq2.add(Arrays.copyOf(e, e.length));
            }
        }
        // if(pq1.size() >= n) return -1;
        List<Integer> list2 = new ArrayList<>();
        while(!pq2.isEmpty()) {
            int [] curr = pq2.poll();
            boolean flag = dsu.Join(curr[0], curr[1]);
            if(!flag) continue;
            list2.add(curr[2]);
        }
        int p = -1;
        for(int i=0; i<n; i++) {
            if(p == -1) p = dsu.GiveP(i);
            else if(p != dsu.GiveP(i)) return -1;
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        for(int ele : list2) pq.add(new int [] {ele, 0});
        while(!pq.isEmpty()) {
            int [] curr = pq.poll();
            if(k > 0 && curr[1]!=1) {
                pq.add(new int [] {curr[0]*2, 1});
                k--;
            } else {
                // System.out.println("Here");
                min = Math.min(curr[0], min);
            }
        }

        return min;
    }
}

class Disjoint {
    int parent [];
    int size [];

    public Disjoint(int n) {
        parent = new int [n+1];
        size = new int [n+1];
        for(int i=0; i<=n; i++) {
            parent[i]=i;
            size[i]=1;
        }
    }

    public int GiveP(int x) {
        if(parent[x] == x) return x;
        parent[x] = GiveP(parent[x]);
        return parent[x];
    }

    public boolean Join(int a, int b) {
        int pa = GiveP(a);
        int pb = GiveP(b);
        if(pa == pb) return false;
        if(size[pa] >= size[pb]) {
            size[pa] += size[pb];
            parent[pb] = pa;
        } else {
            size[pb] += size[pa];
            parent[pa] = pb;
        }
        return true;
    }
}