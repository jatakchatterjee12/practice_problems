/*
    Company Tags                : Bloomberg, LinkedIn, Amazon, Bloomberg, Quora
    Leetcode Link               : https://leetcode.com/problems/path-sum-ii/
*/

//********************************************* C++ **************************************************//
class Solution {
public:
    void collectPaths(TreeNode* root, int curr, vector<int>& temp, vector<vector<int>>& result) {
        if(!root)
            return;
        temp.push_back(root->val);
        if(root->left == NULL && root->right == NULL && root->val == curr) {
            result.push_back(temp);
        }
        
        collectPaths(root->left, curr-root->val, temp, result);
        collectPaths(root->right, curr-root->val, temp, result);
        temp.pop_back();
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        vector<vector<int>> result;
        
        vector<int> temp;
        collectPaths(root, sum, temp, result);
        return result;
    }
};

//******************************************** JAVA ******************************************************//

class Solution {
    private void solve(TreeNode root, int currSum, int targetSum, List<List<Integer>> ans, List<Integer> tmp) {
        if(root == null) return;

        currSum += root.val;
        tmp.add(root.val);

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                ans.add(new ArrayList<>(tmp));
                
            }
        }
      
        solve(root.left, currSum, targetSum, ans, tmp);
        
        solve(root.right, currSum, targetSum, ans, tmp);

        tmp.remove(tmp.size() - 1);
        
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int currSum = 0;

        solve(root, currSum, targetSum, ans, tmp);
        return ans;
    }
}
