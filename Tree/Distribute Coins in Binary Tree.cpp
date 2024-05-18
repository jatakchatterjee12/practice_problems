/*
      Company Tags                : Microsoft
      Leetcode Link               : https://leetcode.com/problems/distribute-coins-in-binary-tree
      GfG Link                    : https://www.geeksforgeeks.org/problems/distribute-candies-in-a-binary-tree/1
*/

/****************************************************************** C++ ****************************************************************************************/
//T.C : O(n)
//S.C : O(height of tree due to recursion)

class Solution {
public:
    int solve(TreeNode* root, int &moves) {

        if(!root) return 0;

        int left = solve(root->left, moves);
        int right = solve(root->right, moves);

        int totalExtraCoins = (left + right + root->val) - 1;

        moves += abs(left) + abs(right);

        return totalExtraCoins;
    }
    int distributeCoins(TreeNode* root) {
        if(!root || (!root->left && !root->right)){
            return 0;
        }

        int moves = 0;

        solve(root, moves);

        return moves;
    }
};


//*********************************************************** JAVA *******************************************

class Solution {
    int solve(TreeNode root, int[] moves) {

        if(root == null) return 0;

        int left = solve(root.left, moves);
        int right = solve(root.right, moves);

        int totalExtraCoins = (left + right + root.val) - 1;

        moves[0] += Math.abs(left) + Math.abs(right);

        return totalExtraCoins;
    }
    public int distributeCoins(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)){
            return 0;
        }
        
        int[] moves = new int[1];

        solve(root, moves);

        return moves[0];
    }
} 
