class Solution {
    public int minAddToMakeValid(String s) {
        int minAdd = 0;
        int valid = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                valid++;
            } else {
                if (valid == 0) {
                    minAdd++;
                } else {
                    valid--;
                }
            }
        }

        minAdd += valid;
        return minAdd;
    }
}