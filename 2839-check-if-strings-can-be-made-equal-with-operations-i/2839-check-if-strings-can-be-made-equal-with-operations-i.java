class Solution {
    public boolean canBeEqual(String s1, String s2) {
        
        int i = 0, j = 2;

        while (j < s1.length()) {

            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(j) == s2.charAt(j)) {

            }
            else if (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i)) {

            }
            else {
                return false;
            }

            i++;
            j++;
        }

        return true;
    }
}