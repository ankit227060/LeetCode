class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        int mx = 0;

        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int[] spf = new int[mx + 1];

        for (int i = 0; i <= mx; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= mx; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= mx; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            Set<Integer> used = new HashSet<>();

            while (x > 1) {
                int p = spf[x];

                if (!used.contains(p)) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    used.add(p);
                }

                x /= p;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        int[] dist = new int[n];

        Arrays.fill(dist, -1);

        q.offer(0);
        dist[0] = 0;

        while (!q.isEmpty()) {
            int i = q.poll();

            int steps = dist[i];

            if (i == n - 1) {
                return steps;
            }

            if (i - 1 >= 0 && dist[i - 1] == -1) {
                dist[i - 1] = steps + 1;
                q.offer(i - 1);
            }

            if (i + 1 < n && dist[i + 1] == -1) {
                dist[i + 1] = steps + 1;
                q.offer(i + 1);
            }

            int val = nums[i];

            if (val > 1 && spf[val] == val) {

                List<Integer> list = map.getOrDefault(val, new ArrayList<>());

                for (int nxt : list) {
                    if (dist[nxt] == -1) {
                        dist[nxt] = steps + 1;
                        q.offer(nxt);
                    }
                }

                list.clear();
            }
        }

        return -1;
    }
}