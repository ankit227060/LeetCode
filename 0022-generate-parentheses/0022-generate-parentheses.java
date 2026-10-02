class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();

        getParanthesis(0,0,"",n,res);
        return res;
    }
    static void getParanthesis(int open,int close,String s,int n,ArrayList<String> res)
    {
        if(s.length() == 2*n)
        {
            res.add(s);
        }
        if(open < n)
        {
            getParanthesis(open+1,close,s+"(",n,res);
        }
        if(close < open)
        {
            getParanthesis(open,close+1,s+")",n,res);
        }
    }
}