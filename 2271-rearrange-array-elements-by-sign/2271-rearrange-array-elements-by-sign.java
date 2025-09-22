class Solution {
    public int[] rearrangeArray(int[] nums) {
            ArrayList<Integer> plus = new ArrayList<>();
            ArrayList<Integer> minus = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            int n = nums.length;
            for (int val:nums){
                if(val<0){
                    minus.add(val);
                }else{
                    plus.add(val);
                }
            }
            int i =0 ;
            int j = 0;
            int k = 0 ;
            while(i <n){
                res.add(plus.get(j));
                i++ ;
                res.add(minus.get(k));
                j++;
                k++;
                i++;
            }
            int[] result = new int [res.size()];
            for ( int p=0;p<res.size(); p++){
                result[p]=res.get(p);
            }
            return result ; 

    }
}