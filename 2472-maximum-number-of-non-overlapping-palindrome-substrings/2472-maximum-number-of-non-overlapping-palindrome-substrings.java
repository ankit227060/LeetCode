class Solution {
    Map<Character,List<Integer>> map;
    Integer[] memo;
    public int maxPalindromes(String s, int k) {
        map = new HashMap<>();
        memo = new Integer[s.length()];
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(i);
        }
        
        return dp(s,k,0);
    }
    
    public int dp(String s, int k, int in){
        if(in>=s.length()) return 0;
        if(memo[in]!=null) return memo[in];
        
        int res=0;
        char c = s.charAt(in);
        
        for(int i : map.get(c)){
            if(i-in>=k-1){
                if(isP(s,in,i)){
                    res=Math.max(res,dp(s,k,i+1)+1);
                    break;
                }
            }
        }
        res=Math.max(res,dp(s,k,in+1));
        memo[in]=res;
        return res;
    }
    
    public boolean isP(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }
}