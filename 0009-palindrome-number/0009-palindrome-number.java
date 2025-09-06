class Solution {
    public boolean isPalindrome(int x) {
        int original =x;
        int num = 0;
        while(x>0){
            int digit= x%10;
            num = num * 10 + digit;
            x=x/10;
        }
    if (num==original){
        return true;
    }else{
        return false;
        }
    }
}