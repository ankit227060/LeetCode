import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); 
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long required = (success + spell - 1) / spell;
            int index = binarySearch(potions, required);
            result[i] = m - index;
        }

        return result;
    }

    private int binarySearch(int[] potions, long required) {
        int low = 0, high = potions.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (potions[mid] < required) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
