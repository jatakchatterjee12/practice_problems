//********************************************* C++ ***************************************************//
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
    bool solve(TreeNode* root, long min, long max){
        if(root == NULL) return true;

        if(root->val <= min || root->val >= max){
            return false;
        }
        bool left = solve(root->left, min, root->val);
        if(left){
            bool right = solve(root->right, root->val, max);
            return right;
        }
        return false;
        
    }
    bool isValidBST(TreeNode* root) {
        return solve(root, LONG_MIN, LONG_MAX);
    }
};

//******************************************** JAVA *******************************************************//
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

    boolean isValid(TreeNode root,long min,long max){

        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        boolean left = isValid(root.left,min,root.val);

        if(left) {
            boolean right = isValid(root.right,root.val,max);
            return right;
        }

        return false;
    }
    public boolean isValidBST(TreeNode root) {

        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
}
