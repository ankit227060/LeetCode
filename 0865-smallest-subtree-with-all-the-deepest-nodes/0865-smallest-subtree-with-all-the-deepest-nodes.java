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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Helper class to store depth and subtree root
    class Pair {
        int depth;
        TreeNode node;

        Pair(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public Pair dfs(TreeNode root) {
        // Base case
        if (root == null) {
            return new Pair(0, null);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        // Compare depths
        if (left.depth == right.depth) {
            return new Pair(left.depth + 1, root);
        } else if (left.depth > right.depth) {
            return new Pair(left.depth + 1, left.node);
        } else {
            return new Pair(right.depth + 1, right.node);
        }
    }
}