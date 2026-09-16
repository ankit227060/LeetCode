
class Solution {
    static final long MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        int total = n + k - 1;
        int choose = 2 * k;

        long[] fact = new long[total + 1];
        long[] invFact = new long[total + 1];

        fact[0] = 1;

        for (int i = 1; i <= total; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[total] = power(fact[total], MOD - 2);

        for (int i = total; i > 0; i--) {
            invFact[i - 1] = invFact[i] * i % MOD;
        }

        return (int) (fact[total]
                * invFact[choose] % MOD
                * invFact[total - choose] % MOD);
    }

    private long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                result = result * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return result;
    }
}