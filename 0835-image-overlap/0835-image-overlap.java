class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        int[] aLeftSlide = makeArray(A);
        int[] aRightSlide = aLeftSlide.clone();
        int[] b = makeArray(B);

        int maxOverlap = maxOverlapUpDownSlide(aLeftSlide, b);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                aLeftSlide[j] <<= 1;
                aRightSlide[j] >>= 1;
            }

            maxOverlap = Math.max(
                maxOverlap,
                maxOverlapUpDownSlide(aLeftSlide, b)
            );

            maxOverlap = Math.max(
                maxOverlap,
                maxOverlapUpDownSlide(aRightSlide, b)
            );
        }

        return maxOverlap;
    }

    private int[] makeArray(int[][] matrix) {
        int[] array = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    array[i] |= (1 << j);
                }
            }
        }

        return array;
    }

    private int maxOverlapUpDownSlide(int[] a, int[] b) {
        int maxOverlap = 0;

        for (int i = 0; i < a.length; i++) {
            int overlapUp = 0;
            int overlapDown = 0;

            for (int row = i; row < a.length; row++) {
                overlapUp += Integer.bitCount(
                    a[row] & b[row - i]
                );

                overlapDown += Integer.bitCount(
                    a[row - i] & b[row]
                );
            }

            maxOverlap = Math.max(
                maxOverlap,
                Math.max(overlapUp, overlapDown)
            );
        }

        return maxOverlap;
    }
}