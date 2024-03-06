/*
    Company Tags                : Amazon, Microsoft, Accolite, Adobe, CouponDunia, FactSet, Goldman Sachs, Housing.com, Oracle, Samsung, Atlassian
    Leetcode Qn Link            : https://leetcode.com/problems/path-sum/
*/

//******************************************** C++ ***********************************************************************//
class Solution {
public:
    bool pathSum(TreeNode* root, int sum, int curr) {
        if(!root)
            return false;
        
        if(!root->left && !root->right)
            return ((curr + root->val) == sum);
        
        bool l = pathSum(root->left,  sum, curr+root->val);
        bool r = pathSum(root->right, sum, curr+root->val);
        return l || r;
    }
    bool hasPathSum(TreeNode* root, int sum) {
        return pathSum(root, sum, 0);
    }
};

//************************************************** JAVA ******************************************************************//

class Solution {
    private boolean solve(TreeNode root, int sum, int targetSum) {
        if(root == null) return false;

        sum += root.val;

        //if we reach leaf node
        if(root.left == null && root.right == null) {
            if(sum == targetSum){
                return true;
            }
            else return false;
        }

        return solve(root.left, sum, targetSum) || solve(root.right, sum, targetSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return solve(root, sum, targetSum);
    }
}
