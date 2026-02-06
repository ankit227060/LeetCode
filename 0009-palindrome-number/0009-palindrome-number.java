class Solution {
    public boolean isPalindrome(int x) {
        int rev =0;
        int rem =0;
        int n = x;
        while(n>0){
            rem = n%10;
            rev = (rev*10)+rem;
            n=n/10;
        }
        if(rev==x){
            return true;
        }else return false ;
    }
}

//time : O(log n)
//space : O(1)