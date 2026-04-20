class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        int i=0,j=colors.length-1;
        while(i<=j){
            if(colors[i]!=colors[j]) {
                max=Math.max(j-i,max);
                j--;
            }
            else j--;
        }
        i=0;
        j=colors.length-1;
        while(i<=j){
            if(colors[i]!=colors[j]) {
                max=Math.max(j-i,max);
                i++;
            }
            else i++;
        }
        return max;
    }
}