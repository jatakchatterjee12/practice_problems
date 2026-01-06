/*
    Company Tags                : AMAZON, SAMSUNG(June, 2023, Online Assessment)
    Leetcode Link               : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
*/

//*********************************************** C++ ***************************************************//

//Approach-1 (Using BFS - T.C : O(n))
class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        int maxSum = INT_MIN;
        int resultLevel = 0;
        int currLevel = 1;
        
        queue<TreeNode*> que;
        que.push(root);
        
        
        while(!que.empty()) {

            int n = que.size();
            
            int sum = 0;
            
            while(n--) {
                
                TreeNode* node = que.front();
                que.pop();
                
                sum += node->val;
                
                if(node->left)
                    que.push(node->left);
                
                if(node->right)
                    que.push(node->right);
            }
            
            if(sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }
            currLevel++;
        }
        
        return resultLevel;
        
    }
};


//Approach-2 (Using DFS - T.C : O(n))
class Solution {
public:
    
    map<int, int> mp;
    
    void DFS(TreeNode* root, int currLevel) {
        
        if(!root)
            return;
        
        mp[currLevel] += root->val;
        
        DFS(root->left, currLevel+1);
        DFS(root->right, currLevel+1);
        
    }
    
    int maxLevelSum(TreeNode* root) {
        mp.clear();
        
        DFS(root, 1);
        
        int maxSum = INT_MIN;
        int result = 0;
        
        for(auto &it : mp) {
            
            int level = it.first;
            int sum   = it.second;
            
            if(sum > maxSum) {
                maxSum = sum;
                result = level;
            }
            
        }
        
        return result;
    }
};


//*********************************************************** JAVA ***************************************************//
//Approach-1 (Using BFS - T.C : O(n))
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
    public int maxLevelSum(TreeNode root) {
        
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int resultLevel = 0;

        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty()){
            int sz = que.size();
            int levelSum = 0;

            while(sz-- > 0){
                TreeNode curr = que.poll();
                levelSum += curr.val;

                if(curr.left != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);
            }
            level++;

            if(levelSum > maxSum){
                maxSum = levelSum;
                resultLevel = level;
            }
        }
        return resultLevel;
    }
}

//Approach-2 (Using DFS - T.C : O(n))

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
    Map<Integer, Integer> levelToLevelSum = new HashMap<>(); // level->levelSum
    private void DFS(TreeNode root, int currLevel){

        if(root == null) return;

        levelToLevelSum.put(currLevel, levelToLevelSum.getOrDefault(currLevel, 0) + root.val);

        DFS(root.left, currLevel+1);
        DFS(root.right, currLevel+1);
    }
    public int maxLevelSum(TreeNode root) {
        
        DFS(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;

        for(Map.Entry<Integer, Integer> entry : levelToLevelSum.entrySet()){
            int level = entry.getKey();
            int levelSum = entry.getValue();

            if(levelSum > maxSum){
                maxSum = levelSum;
                resultLevel = level;
            }
        }
        return resultLevel;
    }
}
