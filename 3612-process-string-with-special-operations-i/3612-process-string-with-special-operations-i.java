class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == '*' && ans.length() >= 1) {
                ans.deleteCharAt(ans.length() - 1);
            }
            else if(ch == '#' && ans.length() >= 1) {
                String temp = ans.toString();
                ans.append(temp);
            }
            else if(ch == '%') {
                ans.reverse();
            }
            if(ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}