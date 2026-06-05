class Solution {
    public int compress(char[] chars) {
        int index=0;
        int i =0;
        while(i<chars.length){
            int count=0;
            char ch=chars[i];
            while(i<chars.length && chars[i]==ch){
                count++;
                i++;
            }
            chars[index++] = ch;

            if(count>1){
                String s = String.valueOf(count);
                for(char c : s.toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}