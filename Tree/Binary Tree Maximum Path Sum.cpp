
/*    
    Company Tags                : Google, Amazon, Meta, Flipkart
    Leetcode Link               : https://leetcode.com/problems/binary-tree-maximum-path-sum/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1
*/

/****************************************************** C++ ******************************************/
//Approach - Recursively finding the best path
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    
    int maxSum;
    
    int solve(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int l = solve(root->left);
        int r = solve(root->right);
        
        int neeche_hi_milgaya_answer = l + r + root->val; //(1)
        
        int koi_ek_acha = max(l, r) + root->val; //(2)
        
        int only_root_acha = root->val; //(3)
        
        maxSum = max({maxSum, neeche_hi_milgaya_answer, koi_ek_acha, only_root_acha});
        
        
        //most important part
        return max(koi_ek_acha, only_root_acha);
        
    }
    
    int maxPathSum(TreeNode* root) {
        maxSum = INT_MIN;
        
        solve(root);
        
        return maxSum;
        
    }
};


/****************************************************** JAVA ******************************************/
//Approach - Recursively finding the best path
//T.C : O(n)
//S.C : O(n)
class Solution {
    
    private int maxSum;
    
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = solve(root.left);
        int right = solve(root.right);
        
        int neecheHiMilgayaAnswer = left + right + root.val; // (1)
        int koiEkAcha = Math.max(left, right) + root.val; // (2)
        int onlyRootAcha = root.val; // (3)

        maxSum = Math.max(maxSum, Math.max(neecheHiMilgayaAnswer, Math.max(koiEkAcha, onlyRootAcha)));
        
        // Most important part
        return Math.max(koiEkAcha, onlyRootAcha);
    }
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}


///********************************* STRIVER *****************************************///



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
