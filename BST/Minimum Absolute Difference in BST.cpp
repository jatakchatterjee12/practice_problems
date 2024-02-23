/*
    Company Tags                : GOOGLE
    Leetcode Link               : https://leetcode.com/problems/minimum-absolute-difference-in-bst
*/

//********************************************* C++ *******************************************************//
//Using Simple InOrder traversal - T.C : O(n)
class Solution {
public:
    
    int minDiff = INT_MAX;
    
    void inOrder(TreeNode* root, TreeNode* &prev) {
        
        if(root == NULL)
            return;
        
        inOrder(root->left, prev);
        
        if(prev != NULL) {
            minDiff = min(minDiff, root->val - prev->val);
        }
        
        prev = root;
        
        inOrder(root->right, prev);
        
    }
    
    int getMinimumDifference(TreeNode* root) {
        TreeNode* prev = NULL;
        inOrder(root, prev);
        return minDiff;
    }
};

//********************************************** JAVA *******************************************************//
//Using Simple InOrder traversal - T.C : O(n)
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
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev;

    void inorder(TreeNode root){

        if(root  == null) return;

        inorder(root.left);

        if(prev != null){

            minDiff = Math.min(minDiff, root.val - prev.val);
        }

        prev = root;

        inorder(root.right);
    }
    public int getMinimumDifference(TreeNode root) {

        prev  =  null;
        inorder(root);
        return minDiff;
    }
}
