class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;

        for (int num : nums) {

            // Prime numbers have only 2 divisors → skip
            if (isPrime(num)) continue;

            int root = (int) Math.sqrt(num);

            // Perfect squares cannot have exactly 4 divisors → skip
            if (root * root == num) continue;

            int divisorCount = 0;
            int firstDivisor = 0;

            // Check divisors only till √num
            for (int i = 2; i <= root; i++) {

                // More than one divisor pair → more than 4 divisors
                if (divisorCount > 1) break;

                if (num % i == 0) {
                    divisorCount++;
                    firstDivisor = i;
                }
            }

            // Exactly one divisor pair → total 4 divisors
            if (divisorCount == 1) {
                sum += 1 + num + firstDivisor + (num / firstDivisor);
            }
        }

        return sum;
    }

    // Optimized prime check using 6k ± 1 rule
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }
}