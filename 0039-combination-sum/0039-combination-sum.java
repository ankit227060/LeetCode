import java.util.ArrayList;
import java.util.List;

class Solution {
    public void backtrack(int[] candidates, int target, List<Integer> combination, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backtrack(candidates, target - candidates[i], combination, result, i);
            combination.remove(combination.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }
}