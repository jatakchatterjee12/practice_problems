
/*
    Company Tags : Accolite, Amazon, American Express, Expedia, MakeMyTrip, Microsoft, Payu, Snapdeal, Times Internet, Twitter
    Link to Qn   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    NOTE         : This can be solved using concept of "LCS in Binary Tree" but we have BST here we can use it to our benefit.
*/

//Approach-1 (Recursive) Time : O(N) worst case : skewed BST
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root)
            return root;
        
        //we need to find the first bifurcation point
        /*
            i.e the point just after which path for p and q separates to left and right
        */
        if(root->val > p->val && root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        else if(root->val < p->val && root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
        
        return root;
    }
};


//Approach-2 (Iterative) Time : O(N) worst case : skewed BST
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        TreeNode* curr = root;
        
        while(true) {
            if(p->val < curr->val && q->val < curr->val)
                curr = curr->left;
            else if(p->val > curr->val && q->val > curr->val)
                curr = curr->right;
            else
                break;
        }
        
        return curr;
    }
};


//***************************************************** JAVA ****************************************************//
//Approach-1 (Recursive) Time : O(N) worst case : skewed BST
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return root;
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return root;
        }
    }
}



//Approach-2 (Iterative) Time : O(N) worst case : skewed BST
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;

        while(curr != null){
            if(curr.val > p.val && curr.val > q.val){
                curr = curr.left;
            }
            else if(curr.val < p.val && curr.val < q.val){
                curr = curr.right;
            }
            else{
                // we are at our answer node, no need to g further, just break the loop and return the curr node
                break;
            }
            
        }
        return curr;
    }
}
