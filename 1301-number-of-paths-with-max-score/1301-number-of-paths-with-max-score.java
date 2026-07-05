import java.util.List;
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int mod=1000000007;
        int[][] maxScore=new int[n][n];
        int[][] ways=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maxScore[i][j]=-1;
            }
        }
        maxScore[n-1][n-1]=0;
        ways[n-1][n-1]=1;
        for (int r=n-1;r>=0;r--){
            for (int c=n-1;c>=0;c--){
                char ch=board.get(r).charAt(c);
                if (ch=='X' || ch=='S') continue;
                int bestPrevScore=-1;
                if (c+1<n && maxScore[r][c+1]!=-1){
                    bestPrevScore=Math.max(bestPrevScore,maxScore[r][c+1]);
                }
                if (r+1<n && maxScore[r+1][c]!=-1){
                    bestPrevScore=Math.max(bestPrevScore,maxScore[r+1][c]);
                }
                if (r+1<n && c+1<n && maxScore[r+1][c+1]!=-1){
                    bestPrevScore=Math.max(bestPrevScore,maxScore[r+1][c+1]);
                }
                if (bestPrevScore==-1) continue;
                long pathCount=0;
                if (c+1<n && maxScore[r][c+1]==bestPrevScore) pathCount += ways[r][c+1];
                if (r+1<n && maxScore[r+1][c]==bestPrevScore) pathCount += ways[r+1][c];
                if (r+1<n && c+1<n && maxScore[r+1][c+1]==bestPrevScore) pathCount+=ways[r+1][c+1];
                int currentVal=(ch=='E')?0:(ch-'0');
                maxScore[r][c]=bestPrevScore+currentVal;
                ways[r][c]=(int)(pathCount%mod);
            }
        }
        if (ways[0][0]==0){
            return new int[]{0,0};
        }
        return new int[]{maxScore[0][0],ways[0][0]};
    }
}