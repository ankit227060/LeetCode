//import java.util.*;

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         int longestLength = 0;
//         HashMap <Integer, Boolean > newmap  = new HashMap<>();
//         for (int num:nums){
//             newmap.put(num,Boolean.FALSE);
//         }

//         for(int num:nums){
//             int currentLength = 1;

//             int nextNum = num+1;
//             while(newmap.containsKey(nextNum) && newmap.get(nextNum) == false){
//                 currentLength ++ ;
//                 newmap.put(nextNum,Boolean.TRUE);
//                 nextNum++;
//             }

//             int prevNum = num-1;
//             while(newmap.containsKey(prevNum) && !newmap.get(prevNum)){
//                 currentLength ++;
//                 newmap.put(prevNum,Boolean.TRUE);
//                 prevNum--;
//             }

//             longestLength = Math.max(longestLength, currentLength);
//         }

//         return longestLength;
//     }
// }



import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> myset = new HashSet<>();
        int maxsize = 0;

        for (int num : nums) {
            myset.add(num);
        }

        for (int num : myset) {
            if (!myset.contains(num - 1)) {
                int current = num;
                int current_size = 1;

                while (myset.contains(current + 1)) {
                    current++;
                    current_size++;
                }

                maxsize = Math.max(maxsize, current_size);
            }
        }

        return maxsize;
    }
}
