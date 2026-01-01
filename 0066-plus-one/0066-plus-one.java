class Solution {
    public int[] plusOne(int[] digits) {
        final int n=digits.length;
        for(int i=n-1; i>=0; i--){
            digits[i]++;
            if (digits[i]<10) return digits;
            digits[i]=0;
        }
        digits=new int[n+1];
        digits[0]=1;
        return digits;
    }
}