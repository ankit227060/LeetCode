import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        if(k > (3 << (n - 1))) return "";

        Queue<String> q = new LinkedList<>();
        q.add("");

        while(k > 0){
            String temp = q.poll();

            for(char ch = 'a'; ch <= 'c'; ch++){
                if(temp.length() == 0 || temp.charAt(temp.length() - 1) != ch){
                    q.add(temp + ch);

                    if(temp.length() + 1 == n)
                        k--;
                }

                if(k == 0) break;
            }
        }

        String ans = "";
        for(String s : q) ans = s;
        return ans;
    }
}