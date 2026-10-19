class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
    int lessNum=0,equalNum=0;
    for(int i : nums){
        if(i<target){
            lessNum++;
        }else if(i==target){
            equalNum++;
        }
    }
    List<Integer> list = new ArrayList<>();

    for(int i=0;i<equalNum;i++){
        list.add(lessNum+i);
    }
        return list;
    }
}