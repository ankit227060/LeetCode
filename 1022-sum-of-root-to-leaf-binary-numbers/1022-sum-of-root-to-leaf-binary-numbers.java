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
    public int sumRootToLeaf(TreeNode root) {
        return DFS(root, 0);
    }

    public int DFS(TreeNode rt, int x) {
        if (rt==null) return 0;
        x = x*2 + rt.val;
        if(rt.left==rt.right) return x;
        return DFS(rt.left, x) + DFS(rt.right, x);
    }
}