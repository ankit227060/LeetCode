class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n!= 1){

            if(n%2==1) cnt++;
            n = n/2;
        }
        return cnt+1;
    }
}