class Solution {
    public void reverseString(char[] s) {
        reverse( s, 0,s.length -1);
    }
     // Helper recursive method
    private void reverse(char [] s, int left, int right){
        // Base case: pointers have met or crossed
        if (left >= right) return;
        // Swap characters at left and right
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp ;
        // Recursive call to the next pair
        reverse(s, left + 1, right - 1);
    }
}