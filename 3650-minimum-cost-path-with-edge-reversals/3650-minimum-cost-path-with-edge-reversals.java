class Solution {
    class pair{
        int node;
        int cost;
        public pair(int node, int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int minCost(int n, int[][] edges) {
        HashMap<Integer,HashMap<Integer,Integer>>hm=new HashMap<>();
        for(int i=0;i<n;i++) hm.put(i,new HashMap<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            //if edge exists----keep the one with minimum weight
            hm.get(u).put(v,Math.min(hm.get(u).getOrDefault(v,Integer.MAX_VALUE),wt));
            hm.get(v).put(u,Math.min(hm.get(v).getOrDefault(u,Integer.MAX_VALUE),2*wt));
        }
        int dist[]=new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
      
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            //remove
            pair p=pq.poll();
            int node=p.node;
            int wt=p.cost;
            if(dist[node]<wt) continue;
            for(int nbrs:hm.get(node).keySet()){
                int c=hm.get(node).get(nbrs);
                if(dist[nbrs]>dist[node]+c){
                    dist[nbrs]=dist[node]+c;
                    pq.add(new pair(nbrs,dist[node]+c));
                }
            }
        }
        if(dist[n-1]==Integer.MAX_VALUE) return -1;
        return dist[n-1];
    }
}