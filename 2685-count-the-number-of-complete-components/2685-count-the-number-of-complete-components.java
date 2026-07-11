import java.util.Collection;

class Solution {
    class UnionFind {
        private int[] parents;
        public UnionFind(int size) {
            parents = new int[size];
            for (int i = 0; i < size; ++i) {
                parents[i] = i;
            }
        }
        public int find(int node) {
            int start = node;
            while (node != parents[node]) {
                node = parents[node];
            }
            return parents[start] = node;
        }
        public void connect(int source, int target) {
            int sourceParent = find(source);
            int targetParent = find(target);
            if (sourceParent == targetParent) return;
            parents[sourceParent] = targetParent;
        }
        public Collection<List<Integer>> getComponents() {
            Map<Integer, List<Integer>> components = new HashMap<>();
            for (int i = 0; i < parents.length; ++i) {
                int parent = find(i);
                if (components.containsKey(parent)) {
                    components.get(parent).add(i);
                } else {
                    components.put(parent, new ArrayList<>(List.of(i)));
                }
            }
            return components.values();
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        UnionFind uf = new UnionFind(n);
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int source = edge[0];
            int target = edge[1];
            uf.connect(source, target);
            degree[source]++;
            degree[target]++;
        }
        Collection<List<Integer>> components = uf.getComponents();
        for (List<Integer> component : components) {
            int expectedDegree = component.size() - 1;
            boolean completeSubGraph = true;
            for (int vertice : component) {
                if (degree[vertice] != expectedDegree) {
                    completeSubGraph = false;
                    break;
                }
            }
            if (completeSubGraph) res++;
        }
        return res;
    }
}