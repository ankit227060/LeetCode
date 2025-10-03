import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0)
            return 0;

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int totalWater = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!pq.isEmpty()) {
            Cell cell = pq.poll();

            for (int[] dir : directions) {
                int nx = cell.x + dir[0];
                int ny = cell.y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    
                    totalWater += Math.max(0, cell.height - heightMap[nx][ny]);
                    
                    pq.offer(new Cell(nx, ny, Math.max(cell.height, heightMap[nx][ny])));
                }
            }
        }

        return totalWater;
    }

    static class Cell {
        int x, y, height;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.height = h;
        }
    }
}
