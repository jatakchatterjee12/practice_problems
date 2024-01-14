/*
    Company Tags          : Accolite, Amazon, Flipkart, Knowlarity, MakeMyTrip, Ola Cabs, Open Solutions, OYO ROoms, Paytm, Qualcomm, Samsung,
                            Snapdeal, Twitter
    Leetcode Qn Link      : https://leetcode.com/problems/binary-tree-right-side-view/
    Approach              : Use DFS or Level Order Traversal
    Time Complexity       : O(n)
*/

//Approach - 1 (DFS)
class Solution {
public:
    //modifed pre order traversal
    void preOrder(TreeNode* root, int level, vector<int>& result) {
        if(!root)
            return;
        
        if(result.size() < level)
            result.push_back(root->val);
        
        preOrder(root->right, level+1, result);
        preOrder(root->left, level+1, result);
    }
    vector<int> rightSideView(TreeNode* root) {
        if(!root)
            return {};
        
        vector<int> result;
        
        preOrder(root, 1, result);
        
        return result;
    }
};


//Approach-2 (Level Order Traversal)
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(!root)
            return {};
        
        queue<TreeNode*> que;
        vector<int> result;
        
        que.push(root);
        
        while(!que.empty()) {
            int n = que.size();
            TreeNode* rightNode = NULL;
            while(n--) {
                rightNode = que.front();
                que.pop();
                
                if(rightNode->left)
                    que.push(rightNode->left);
                if(rightNode->right)
                    que.push(rightNode->right);
            }
            result.push_back(rightNode->val);
        }
        return result;
    }
};

/********************************************************* JAVA ***********************************************************/
//Approach - 1 (DFS) Moderated preOrder Traversal
class Solution {
  void solve(TreeNode root, int level, List<Integer> result){
    if(root == null) return;

    if(result.size() < level) 
        result.add(root.val);

    solve(root.right, level+1, result);
    solve(root.left, level+1, result);
  }
    public List<Integer> rightSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      solve(root,1,result);
      return result;
    }
}
//Approch-2. Level Order Traversal
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
      
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);
        while(!que.isEmpty()){

            int n = que.size();
            TreeNode node = new TreeNode();

            while(n-- > 0){

                node = que.poll();

                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            res.add(node.val);
        }
        return res;
    }
}
