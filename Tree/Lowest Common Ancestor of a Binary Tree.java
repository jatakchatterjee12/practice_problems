
/*
    Company Tags : Accolite, Amazon, American Express, Expedia, MakeMyTrip, Microsoft, Payu, Snapdeal, Times Internet, Twitter
    Link to Qn   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

/********************************************************* C++ **************************************************//
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root)
            return NULL;
        
        if(root->val == p->val || root->val == q->val)
            return root;
        
        TreeNode* l = lowestCommonAncestor(root->left, p, q);
        TreeNode* r = lowestCommonAncestor(root->right, p, q);
        
        if(l && r)
            return root;
        
        return l?l:r;
    }
};


//****************************************************** JAVA *******************************************//

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// If leftside return something(not null) and rightside return something(not null) i.e that is the ansr node we are currently standing on.
// Means if both right and left side call return something ,We found our answer.
// If either hand(left or right) returns null return otherhand(that might be null as well);

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(right == null) return left;
        if(left == null) return right;

        return root;
    }
}
