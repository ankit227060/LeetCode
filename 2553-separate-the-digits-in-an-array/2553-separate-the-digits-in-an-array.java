class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.clear();
        for(int i = 0 ; i < nums.length ; i++){
            digits(ans , nums[i]);
        }
        int[] arr = new int[ans.size()];
        for(int j = 0 ; j < ans.size() ; j++){
            arr[j] = ans.get(j);
        }
        return arr;

    }

   public void digits(ArrayList<Integer> arr, int n) {
	if(n== 0) {
		return ;
	}
	digits(arr , n/10);
	arr.add(n%10);
	}
    
}