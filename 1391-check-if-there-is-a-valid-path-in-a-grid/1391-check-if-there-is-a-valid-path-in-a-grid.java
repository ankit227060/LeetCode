class Solution {
    public boolean hasValidPath(int[][] grid) {
        int[] up = {-1, 0}, right = {0, 1}, down = {1, 0}, left = {0, -1};
        int[][][] directionsMap = new int[7][][];
        directionsMap[1] = new int[][] { left, right };
        directionsMap[2] = new int[][] { up, down };
        directionsMap[3] = new int[][] { left, down };
        directionsMap[4] = new int[][] { right, down };
        directionsMap[5] = new int[][] { left, up };
        directionsMap[6] = new int[][] { right, up };
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        return move(grid, 0, 0, directionsMap, vis);
    }
    private boolean move(int[][] grid, int i, int j, 
            int[][][] directionsMap, 
            boolean[][] vis)
    {
        int m = grid.length, n = grid[0].length;
        int currCellVal = grid[i][j];
        vis[i][j] = true;
        if(i == m - 1 && j == n - 1) return true;
        for(int[] dir: directionsMap[currCellVal]) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if(!canConnectBack(directionsMap, i, j, nx, ny, grid[nx][ny])) {
                continue;
            }
            if(vis[nx][ny]) {
                continue;
            }
            if(move(grid, nx, ny, directionsMap, vis)) {
                return true;
            } 
        }
        return false;
    }
    private boolean canConnectBack(int[][][] directionsMap, 
        int parX, int parY, int currX, int currY, 
        int newCellVal) 
    {
        for(int[] dir: directionsMap[newCellVal]) {
            int nx = currX + dir[0];
            int ny = currY + dir[1];

            if(nx == parX && ny == parY) return true;
        }
        return false;
    }

}