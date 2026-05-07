class Solution {
    static class Pair {
        int num;
        int pos;
        Pair(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Pair[] bestLeft = new Pair[n];
        int largest = Integer.MIN_VALUE;
        int largestIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
                largestIndex = i;
            }
            bestLeft[i] = new Pair(largest, largestIndex);
        }
        fillValues(
            n - 1,
            Integer.MAX_VALUE,
            0,
            nums,
            result,
            bestLeft
        );
        return result;
    }
    private void fillValues(
        int end,
        int minOnRight,
        int inheritedMax,
        int[] nums,
        int[] result,
        Pair[] bestLeft
    ) {
        Pair current = bestLeft[end];
        int blockMax = current.num;
        int split = current.pos;
        int valueToFill;
        if (blockMax <= minOnRight) {
            valueToFill = blockMax;
        } else {
            valueToFill = inheritedMax;
        }
        int updatedMin = Math.min(minOnRight, blockMax);
        for (int i = split; i <= end; i++) {
            result[i] = valueToFill;
            updatedMin = Math.min(updatedMin, nums[i]);
        }
        if (split == 0) {
            return;
        }
        fillValues(
            split - 1,
            updatedMin,
            valueToFill,
            nums,
            result,
            bestLeft
        );
    }
}