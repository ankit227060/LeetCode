class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int idx1=-1;
        int idx2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                idx1=i;
            }
            if(nums[i]<min){
                min=nums[i];
                idx2=i;
            }
        }
       int first=Math.min(idx1,idx2);
       int last=Math.max(idx1,idx2);
       int deleteFront=last+1;
       int deleteBack=n-first;
       int deleteBothEnds=(first+1)+(n-last);
       return Math.min(deleteFront,Math.min(deleteBack,deleteBothEnds));

    }
}