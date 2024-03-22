//************************************************* C++ ************************************************************//
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        return (!root || solve(root->left, root->right));
    }

    bool solve(TreeNode* left, TreeNode* right) {

        if(left == NULL || right == NULL) {
            return left == right;
        }

        if(left->val != right->val) return false;

        return solve(left->left, right->right) && solve(left->right, right->left);
    }
};


//***************************************************** JAVA ***********************************************************//
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

    private boolean isSymmetricHelp(TreeNode left,TreeNode right){
        if(left == null || right == null)
            return left == right;

        if(left.val != right.val) return false;

        return isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left);    
    }
    public boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricHelp(root.left,root.right);
        
    }
}
