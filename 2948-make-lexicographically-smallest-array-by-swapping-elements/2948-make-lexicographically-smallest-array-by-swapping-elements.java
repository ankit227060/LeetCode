class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] vp = new int[n][2];

        for (int i = 0; i < n; i++) {
            vp[i][0] = nums[i];
            vp[i][1] = i;
        }

        Arrays.sort(vp, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> indices = new ArrayList<>();
        indices.add(vp[0][1]);

        int l = 0;

        for (int i = 1; i < n; i++) {
            if (vp[i][0] - vp[i - 1][0] <= limit) {
                indices.add(vp[i][1]);
            }
            else {
                Collections.sort(indices);

                for (int j = l, k = 0; j < i; j++, k++) {
                    nums[indices.get(k)] = vp[j][0];
                }

                indices.clear();
                indices.add(vp[i][1]);
                l = i;
            }
        }

        Collections.sort(indices);

        for (int j = l, k = 0; j < n; j++, k++) {
            nums[indices.get(k)] = vp[j][0];
        }

        return nums;
    }
}