class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max=0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            String s1 = String.valueOf(arr1[i]);
            for(int j=0;j<s1.length();j++){
                set.add(s1.substring(0, j+1));
            }
        }

         for(int j=0;j<arr2.length;j++){
            String s2 = String.valueOf(arr2[j]);
            for(int k=0;k<s2.length();k++){
                String substring = s2.substring(0,k+1);
                if(set.contains(substring)){
                    max = Math.max(max, substring.length());
                }
            }
        }

        return max;
    }
}