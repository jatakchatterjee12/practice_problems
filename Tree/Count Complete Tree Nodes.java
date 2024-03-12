/*
    Company Tags               : Amazon, Microsoft, Salesforce, Facebook
    Leetcode Link              : https://leetcode.com/problems/count-complete-tree-nodes/
*/

/*
    1. if leftHeight == rightheight --> perfect binary tree .. direct count nodes thru formula (2^h - 1)
    2. if leftHeight != rightHeight --> count left nodes + count rightnodes + 1(for root itself)
*/

//Time Complexity : O(log(n) * log(n))
class Solution {
public:
    int leftHeight(TreeNode* root) {
        if(!root)
            return 0;
        
        int lh = 0;
        TreeNode* temp = root;
        while(temp) {
            temp = temp->left;
            lh++;
        }
        return lh;
    }
    int rightHeight(TreeNode* root) {
        if(!root)
            return 0;
        
        int rh = 0;
        TreeNode* temp = root;
        while(temp) {
            temp = temp->right;
            rh++;
        }
        return rh;
    }
    int countNodes(TreeNode* root) {
        if(!root)
            return 0;
        
        int lh = leftHeight(root);
        int rh = rightHeight(root);
        if(lh == rh) {
            return pow(2, lh) - 1;
        }
        
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};

//************************************************* JAVA *****************************************************//

class Solution {
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if(left == right) {
             // perfect binary tree
             return (1 << left) - 1; // 2^left - 1 
        }

        else return countNodes(root.left) + countNodes(root.right) + 1;

    }
    int getLeftHeight(TreeNode root) {
        if(root == null) return 0;

        int cnt = 0;
        while(root != null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }

    int getRightHeight(TreeNode root) {
        if(root == null) return 0;

        int cnt = 0;
        while(root != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
}

