class Solution {
    Map<String,Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return solve(s1,s2);
    }
    private boolean solve(String a, String b){
        int n = a.length();
        if(a.equals(b)) return true;
        
        String key = a + " " + b;
        if(map.containsKey(key)){
            return map.get(key);
        }
        boolean flag = false;
        for(int i=1;i<=n-1;i++){
            boolean noswap = solve(a.substring(0,i), b.substring(0,i)) &&
                            solve(a.substring(i), b.substring(i));
            
            boolean swap = solve(a.substring(0,i), b.substring(n-i)) &&
                            solve(a.substring(i), b.substring(0,n-i));
            
            if(swap || noswap){
                flag = true;
                break;
            }
        }
        map.put(key, flag);
        return flag;
    }
}