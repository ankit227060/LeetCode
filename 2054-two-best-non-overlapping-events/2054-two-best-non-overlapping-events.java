class Solution {
    public int maxTwoEvents(int[][] events) {
        // Events: [[1,3,2], [4,5,2], [2,4,3]]
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        // Sorted: [[1,3,2], [2,4,3], [4,5,2]]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); // pq = []
        int maxSingle = 0;
        int ans = 0;
        for(int[] event : events){
            int start = event[0];
            int end = event[1];
            int value = event[2];

            while(!pq.isEmpty() && pq.peek()[0] < start){
                maxSingle = Math.max(maxSingle, pq.poll()[1]);
            }
            ans = Math.max(ans, value);
            ans = Math.max(ans, maxSingle + value);
            pq.offer(new int[]{end, value});
        }
        return ans;
    }
}