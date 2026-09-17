class SegmentTree {
    int[] seg;

    SegmentTree(int n) {
        seg = new int[4 * n];
    }

    void build(int i, int l, int r, int[] v) {
        if (l == r) {
            seg[i] = v[l];
            return;
        }

        int mid = (l + r) >> 1;

        build(2 * i + 1, l, mid, v);
        build(2 * i + 2, mid + 1, r, v);

        seg[i] = Math.min(
            seg[2 * i + 1],
            seg[2 * i + 2]
        );
    }

    int query(int start, int end, int i, int l, int r) {
        if (l > end || r < start)
            return (int)1e9;

        if (l >= start && r <= end)
            return seg[i];

        int mid = (l + r) >> 1;

        int left = query(
            start, end,
            2 * i + 1, l, mid
        );

        int right = query(
            start, end,
            2 * i + 2, mid + 1, r
        );

        return Math.min(left, right);
    }
}

class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // Create prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int[] nextInd = new int[n];
        int[] subarraySize = new int[n];

        Arrays.fill(nextInd, n);
        Arrays.fill(subarraySize, n);

        for (int i = 0; i < n; i++) {

            int tar = prefix[i] + target;

            // lower_bound
            int l = 0;
            int r = n + 1;

            while (l < r) {
                int mid = (l + r) >> 1;

                if (prefix[mid] >= tar)
                    r = mid;
                else
                    l = mid + 1;
            }

            int pos = l;

            if (pos == n + 1 || prefix[pos] != tar) {
                nextInd[i] = -1;
            }
            else {
                nextInd[i] = pos - 1;
                subarraySize[i] = pos - i;
            }
        }

        SegmentTree seg = new SegmentTree(n);
        seg.build(0, 0, n - 1, subarraySize);

        int ans = (int)1e9;

        for (int i = 0; i < n; i++) {

            int l = nextInd[i];

            if (l == -1)
                continue;

            int leftSize = subarraySize[i];

            int rightSize = seg.query(
                l + 1,
                n - 1,
                0,
                0,
                n - 1
            );

            if (rightSize == n)
                continue;

            ans = Math.min(
                ans,
                leftSize + rightSize
            );
        }

        return ans == (int)1e9 ? -1 : ans;
    }
}