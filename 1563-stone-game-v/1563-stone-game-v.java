class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] prefix=new int[n+1];
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+stoneValue[i];
        } 

        int[][] dp=new int[n][n]; 
        for(int j=1;j<n;j++)
        {
            for(int i=j-1;i>=0;i--)
            {
                for(int k=i;k<j;k++)
                {
                    int left=prefix[k+1]-prefix[i];
                    int right=prefix[j+1]-prefix[k+1];
                    int val;
                    if(left<right)
                        val=dp[i][k]+left;
                    else if(left>right)
                        val=dp[k+1][j]+right;
                    else
                        val=Math.max(dp[i][k]+left,dp[k+1][j]+right);
                    dp[i][j]=Math.max(dp[i][j],val);
                }
            }
        }

        return dp[0][n-1];
    }
}