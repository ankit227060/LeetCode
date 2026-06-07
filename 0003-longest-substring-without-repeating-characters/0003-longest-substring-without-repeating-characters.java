class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            String temp="";
            for(int j=i;j<s.length();j++){
                if(temp.contains(String.valueOf(s.charAt(j)))){
                    break;
                }
                temp+=s.charAt(j);
                maxLength= Math.max(maxLength,temp.length());
            }
        }
        return maxLength;
    }
}