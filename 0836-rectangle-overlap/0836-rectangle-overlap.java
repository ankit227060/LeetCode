class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int overlapx =  Math.min(rec2[2] , rec1[2]) - Math.max(rec2[0] , rec1[0]);

        int overlapy =  Math.min(rec2[3] , rec1[3]) - Math.max(rec2[1] , rec1[1]);

        return overlapx > 0 && overlapy > 0;
    }
}