class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        boolean isSorted = true;
        int minIndex = 0;
        char dir = 'n';
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && (nums[i] < nums[i - 1])) {
                isSorted = false;
            }
            if (nums[i] == 0) {
                minIndex = i;
                if (nums[(i - 1 + n) % n] == 1) {
                    dir = 'l';
                } else if (nums[(i + 1) % n] == 1) {
                    dir = 'r';
                }
            }

        }
        if (dir == 'n') {
            return -1;
        }
        if (isSorted) {
            return 0;
        }

        int k = 0;
        int i = minIndex;
        if (dir == 'l') {
            while (k < nums.length - 1) {
                if (nums[(i - 1 + n) % n] < nums[(i + n) % n]) {
                    return -1;
                }
                i--;

                k++;
            }

            int left = minIndex + 1 + 1;
            int right = nums.length - minIndex;

            return Math.min(left, right);

        }

        while (k < nums.length - 1) {
            if (nums[(i + 1) % n] < nums[(i + n) % n]) {
                return -1;
            }
            i++;

            k++;
        }

        int right = n - minIndex + 1 + 1;
        int left = minIndex;

        return Math.min(left, right);

    }
}