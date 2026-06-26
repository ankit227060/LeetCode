class Solution {
    public long countMajoritySubarrays(int[] nums, int targetNum) {
        // Shift zero balance to prevent negative indices
        int zeroBalanceOffset = nums.length + 1;
        int currBalance = zeroBalanceOffset;

        long[] balanceFreqs = new long[zeroBalanceOffset * 2];
        balanceFreqs[currBalance] = 1;

        long subarrCnt = 0L;
        // Running sum of prefix frequencies where past balance < currBalance
        long cumFreqSum = 0L;

        for (int num : nums) {
            // Target seen: balance grows, adding old balance to valid prefix pool
            if (num == targetNum) {
                cumFreqSum += balanceFreqs[currBalance++];
            // Non-target seen: balance drops, removing new balance from valid prefix pool
            } else {
                cumFreqSum -= balanceFreqs[--currBalance];
            }

            // Record new balance state and accumulate valid subarrays ending here
            balanceFreqs[currBalance]++;
            subarrCnt += cumFreqSum;
        }

        return subarrCnt;
    }
}