class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n= A.length;
        int res[]= new int[n];
        int freq[]= new int[n+1];
        int count=0;  
        for(int i=0;i<n;i++){
            if (++freq[A[i]]==2)count++;
            if (++freq[B[i]]==2)count++;
            res[i]=count;
        }
        return res;
        
    }
}