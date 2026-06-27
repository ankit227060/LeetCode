import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Long> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long)x, freq.getOrDefault((long)x, 0L) + 1);
        }

        long maxLen = 0;

        for (Map.Entry<Long, Long> x : freq.entrySet()) {
            long curr = x.getKey();

            if (curr == 1) {
                maxLen = Math.max(maxLen, 
                    freq.get(1L) % 2 == 0 ? freq.get(1L) - 1 : freq.get(1L));
                continue;
            }

            long currLen = 0;

            while (freq.containsKey(curr) && freq.get(curr) >= 2) {
                currLen += 2;
                curr *= curr;
            }

            if (freq.containsKey(curr) && freq.get(curr) == 1) {
                currLen++;
            } else {
                currLen--;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return (int) maxLen;
    }
}