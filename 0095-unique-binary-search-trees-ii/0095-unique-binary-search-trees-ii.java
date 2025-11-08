/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }

    public List<TreeNode> solve(int start, int end) {
        List<TreeNode> bstList = new ArrayList<>();

        if (start > end) {
            bstList.add(null);
            return bstList;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftBst = solve(start, i - 1);
            List<TreeNode> rightBst = solve(i + 1, end);

            for (TreeNode left : leftBst) {
                for (TreeNode right : rightBst) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    bstList.add(root);
                }
            }
        }

        return bstList;
    }
}