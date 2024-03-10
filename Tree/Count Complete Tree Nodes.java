

/*
    1. If left sub tree height equals right sub tree height then,
        a. left sub tree is perfect binary tree
        b. right sub tree is complete binary tree

    2. If left sub tree height greater than right sub tree height then,
        a. left sub tree is complete binary tree
        b. right sub tree is perfect binary tree
*/

class Solution {
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight == rightHeight) {
            return (int)(Math.pow(2, leftHeight)) + countNodes(root.right);
        }
        else {
            return (int)(Math.pow(2, rightHeight)) + countNodes(root.left);
        }
    }

    int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
