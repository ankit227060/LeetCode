class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                int maxLen = Math.min(nCols-1-c, Math.min((nRows-1 - r) / 2, c));
                // Calculate Rhombus going that length;
                for (int i = 0; i <= maxLen; i++) {
                    int perim = calculateRhombus(grid, r,c, i);
                    if (!minHeap.contains(perim)) {
                        minHeap.add(perim);
                        if (minHeap.size() > 3) {
                            minHeap.poll();
                        }
                    }
                }
            }
        }
        int[] res = new int[minHeap.size()];
        int index = res.length - 1;
        while (!minHeap.isEmpty()) {
            res[index--] = minHeap.poll();
        }
        return res;
    }

    public int calculateRhombus(int[][] grid, int r, int c, int len) {
        if (len == 0) return grid[r][c];

        int res = 0;        

        // Down left
        for (int i = 0; i < len; i++) {
            res += grid[r][c];
            r++;
            c--;
        }

        // Down right
        for (int i = 0; i < len; i++) {
            res+=grid[r][c];
            r++;
            c++;
        }

        // Up right
        for (int i = 0; i < len; i++) {
            res+=grid[r][c];
            r--;
            c++;
        }

        // up left
        for (int i = 0; i < len; i++) {
            res+=grid[r][c];
            r--;
            c--;
        }

        return res;
    }
}