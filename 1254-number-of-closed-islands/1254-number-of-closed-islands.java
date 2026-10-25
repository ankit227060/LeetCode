class Solution {
    int n;
    int m;
    public boolean helper(int grid[][],int i,int j){
          if(i<0||j<0||i>=n||j>=m) return false;
          if(grid[i][j]==1) return true;
          grid[i][j]=1;
          boolean up=helper(grid,i-1,j);
          boolean down=helper(grid,i+1,j);
          boolean left=helper(grid,i,j-1);
          boolean right=helper(grid,i,j+1);
          return up && down && left && right;
    }
    public int closedIsland(int[][] grid) {
         n=grid.length;
         m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                if(helper(grid,i,j)){
                    ans++;
                }
            }}
           
        }
        return ans;

    }
}