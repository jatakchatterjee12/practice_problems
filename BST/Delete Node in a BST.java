/*
   find the key first ... if present then delete the key and reconstruct the tree otherwise if not present the key do nothing
   ie. find the key and then delete. 

   // for finding the key ---- 3 cases  1. root is the key  or 
                                        2. key lies on the left or 
                                        3. key lies on the right
*/

//for deleting follow the approaches below

/* Approach - 1 : --> find the rightmost guy of the left subtree
                  --> add right subtree to the right of that rightmost guy

   Approach - 2 : --> find the leftmost guy of the right sub tree
                  --> add left subtree to the left of that leftmost guy
*/

//CODE

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;


        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;

        while(root != null) {
            if(root.val > key){ // go left -->as key can not be in right sub tree

                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else { //otherwise go right
                if(root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    TreeNode helper(TreeNode root) {
        // Edge cases
        if(root.left == null) return root.right;
        else if(root.right == null) return root.left;
        else {

            TreeNode rightChild = root.right;
            TreeNode lastRightofLeft = findLastRight(root.left);
            lastRightofLeft.right = rightChild;
            return root.left;
        }
    }
    TreeNode findLastRight(TreeNode node) {
        if(node.right == null) return node;
        return findLastRight(node.right);
    }
}
