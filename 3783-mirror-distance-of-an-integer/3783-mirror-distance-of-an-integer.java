class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-revhelpler(n));
    }
    public static int revhelpler(int n){
        int num=0;
        while(n>0){
            num=num*10+n%10;
            n/=10;
        }
        return num;
    }
}