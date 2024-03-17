
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    int dfsHeight(TreeNode root) {
        if(root == null) return 0;

        int lH = dfsHeight(root.left);
        
        int rH = dfsHeight(root.right);

        if(lH == -1 || rH == -1) 
            return -1;

        if(Math.abs(lH - rH)  > 1) return -1;

        return 1 + Math.max(lH, rH);    

    }
}
