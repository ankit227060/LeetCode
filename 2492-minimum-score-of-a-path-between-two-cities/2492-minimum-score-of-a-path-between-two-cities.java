class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int city = 1; city <= n; city++) {
            graph[city] = new ArrayList<>();
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int distance = road[2];

            graph[a].add(new int[]{b, distance});
            graph[b].add(new int[]{a, distance});
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int[] edge : graph[city]) {
                int nextCity = edge[0];
                int distance = edge[1];

                answer = Math.min(answer, distance);

                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }

        return answer;
    }
}