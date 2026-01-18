class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        long[][] rowPrefix = new long[n][m + 1];
        long[][] colPrefix = new long[n + 1][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowPrefix[i][j + 1] = rowPrefix[i][j] + grid[i][j];
            }
        }
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                colPrefix[i + 1][j] = colPrefix[i][j] + grid[i][j];
            }
        }
        
        for (int k = Math.min(n, m); k > 1; k--) {
            for (int r = 0; r <= n - k; r++) {
                for (int c = 0; c <= m - k; c++) {
                    
                    long target = rowPrefix[r][c + k] - rowPrefix[r][c];
                    boolean isMagic = true;
                    
                    for (int i = 0; i < k; i++) {
                        long currRowSum = rowPrefix[r + i][c + k] - rowPrefix[r + i][c];
                        if (currRowSum != target) {
                            isMagic = false;
                            break;
                        }
                    }
                    if (!isMagic) continue;
                
                    for (int j = 0; j < k; j++) {
                        long currColSum = colPrefix[r + k][c + j] - colPrefix[r][c + j];
                        if (currColSum != target) {
                            isMagic = false;
                            break;
                        }
                    }
                    if (!isMagic) continue;
                    
                    long d1 = 0, d2 = 0;
                    for (int i = 0; i < k; i++) {
                        d1 += grid[r + i][c + i];
                        d2 += grid[r + i][c + k - 1 - i];
                    }
                    
                    if (d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }
        
        return 1;
    }
}