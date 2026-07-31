class Solution {
    public int minimumPushes(String word) {
        int[] mp = new int[26];
        for(char c : word.toCharArray()){
            mp[c - 97] += 1;
        }
        Arrays.sort(mp);
        int key = 1;
        int ans = 0;
        for(int i = 25; i >= 0; i--){
            int f = mp[i];
            if(f == 0){
                break;
            }
            ans += f * ((key + 7)/8);
            key++;
        }

        return ans;
    }
}