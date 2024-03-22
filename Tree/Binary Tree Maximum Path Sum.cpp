//***************************************** C++ **********************************************************//
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
    int maxPathSum(TreeNode* root) {
        int maxSum = INT_MIN;

        solve(root, maxSum);
        return maxSum; 
    }

    int solve(TreeNode* root, int &maxSum) {

        if(!root) return 0;

        int leftSum = max(0, solve(root->left, maxSum));
        int rightSum = max(0, solve(root->right, maxSum));

        maxSum = max(maxSum, leftSum + rightSum + root->val);

        return root->val + max(leftSum, rightSum);
    }
};


//*********************************************** JAVA *****************************************************//
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
    public int maxPathSum(TreeNode root) {
        
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }

    int maxPathDown(TreeNode root, int[] maxValue){

        if(root == null)return 0;

        int left = Math.max(0,maxPathDown(root.left,maxValue));
        int right = Math.max(0,maxPathDown(root.right,maxValue));

        maxValue[0] = Math.max(maxValue[0],root.val + left + right);

        return (root.val + Math.max(left,right));
    }
}
