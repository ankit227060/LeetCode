class Solution {
    public int[] arrayRankTransform(int[] arr) {
        TreeSet<Integer>treeSet=new TreeSet<>();
        for(int val:arr){
            treeSet.add(val);
        }
        int[]ans=new int[arr.length];
        Map<Integer,Integer>map=new HashMap<>();
        int rank=1;
        for(int val:treeSet){
            map.put(val,rank++);
        }
        int index=0;
        for(int val:arr){
            ans[index++]=map.get(val);
        }
        return ans;
    }
}