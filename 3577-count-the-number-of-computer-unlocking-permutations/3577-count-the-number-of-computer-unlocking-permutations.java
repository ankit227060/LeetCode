class Solution {
    public int countPermutations(int[] complexity) {
        long mod=1_000_000_007;
        int min=complexity[0];
        int n=complexity.length;
        for(int i=1;i<n;i++){
            if(complexity[i]<=min){
                return 0;
            }
        }
        long fact=1;
        for(int j=n-1;j>0;j--){
            fact=(long)(fact*j)%mod;
        }
        return (int)fact;
    }
}