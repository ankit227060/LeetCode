class Solution {
    int res=0; 
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return res;
    }
    public int[] postOrder(TreeNode node){
        
        if(node==null) return new int[]{0,0};

        int[] left=postOrder(node.left);
        int[] right=postOrder(node.right);

        int currentSum=left[0]+right[0]+node.val;
        int currentCount=left[1]+right[1]+1;

        if(currentSum/currentCount==node.val){
            res++;
        }
        return new int[]{currentSum, currentCount};
    }
}