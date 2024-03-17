public class Solution {
    public static int heightOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;

        int lH = heightOfBinaryTree(root.left);
        int rH = heightOfBinaryTree(root.right);

        return 1 + Math.max(lH, rH);
    }
}
