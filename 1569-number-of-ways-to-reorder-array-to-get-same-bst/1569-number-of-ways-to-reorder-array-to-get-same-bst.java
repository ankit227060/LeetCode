class Solution {
    private static final long MOD = 1000000007L;

    private long[][] comb;

    private long count(List<Integer> arr) {
        int n = arr.size();

        if (n <= 2) {
            return 1;
        }

        int root = arr.get(0);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int x : arr) {
            if (x < root) {
                left.add(x);
            } else if (x > root) {
                right.add(x);
            }
        }

        int L = left.size();
        int R = right.size();

        long ways = comb[L + R][L];

        return ways * count(left) % MOD * count(right) % MOD;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;

        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = comb[i][i] = 1;

            for (int j = 1; j < i; j++) {
                comb[i][j] =
                    (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        List<Integer> arr = new ArrayList<>();

        for (int x : nums) {
            arr.add(x);
        }

        return (int)((count(arr) - 1 + MOD) % MOD);
    }
}