class Solution {
    private int[][] heights;
    private int m, n;
    private final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Pacific - top and left
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
            dfs(m - 1, j, atlantic);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
            if (visited[newRow][newCol]) continue;
            if (heights[newRow][newCol] < heights[row][col]) continue;
            dfs(newRow, newCol, visited);
        }
    }
}
