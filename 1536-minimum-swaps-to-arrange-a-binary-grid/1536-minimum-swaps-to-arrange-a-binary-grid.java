class Solution {
    public int minSwaps(int[][] grid) {
        int n=grid[0].length;
        int zeros[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0) zeros[i]++;
                else break;
            }
        }
        int[] ans=new int[1];
        for(int i=0;i<n;i++) if(!compute(zeros,i,ans)) return -1;
        return ans[0];
    }
    public boolean compute(int[] zeros,int i,int[] ans){
        int tar=zeros.length-i-1;
        if(zeros[i]>=tar) return true;
        boolean flag=false;
        for(int j=i+1;j<zeros.length;j++){
            if(zeros[j]>=tar){
                flag=true;
                ans[0]+=(j-i);
                j-=1;
                while(j>=i){
                    zeros[j+1]=zeros[j];
                    j--;
                }
                break;
            }
        }
        return flag;
    }
}