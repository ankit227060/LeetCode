class Solution {
    public boolean isMagicSquare(int[][] grid,int r,int c){
        int sum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        HashSet<Integer> set = new HashSet<>();
 
        for(int i=0;i<3;i++){ // 1 - 9 checking
            for(int j=0;j<3;j++){
                int num = grid[r+i][c+j];
                if(num<1 || num>9 || set.contains(num)) return false;
                set.add(num);
            }
        }
        
        for(int i=0;i<3;i++){ // row and col sum checking
            if((grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i]) != sum) return false;
            if(grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2] != sum) return false;
        }

        //diagonal sum checking
        if((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2]) != sum) return false;
        if(grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != sum) return false;
        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int c = 0;
        for(int i=0;i<=m-3;i++){
            for(int j=0;j<=n-3;j++){
                if(isMagicSquare(grid,i,j)) c++;
            }
        }
        return c;
    }
}