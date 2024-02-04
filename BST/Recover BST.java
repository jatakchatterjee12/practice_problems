 //***************************************** C++ *************************************//
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
    TreeNode *first, *middle, *last, *prev;
    void inorder(TreeNode* root){
        if(!root) return;
        inorder(root->left);

        if(prev != NULL && root->val < prev->val){
            if(first == NULL){ // first violation
                first = prev;
                middle = root;
            }
            else { // second violation
                last = root;
            }
        }
        prev = root;
        inorder(root->right);
    }
    void recoverTree(TreeNode* root) {
        first = middle = last = NULL;
        prev = new TreeNode(INT_MIN);

        inorder(root);

        if(first && last){
            swap(first->val, last->val);
        }
        else if(first && middle){
            swap(first->val, middle->val);
        }
    }
};
//****************************************** JAVA ************************************//
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
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);

        if(prev != null && (root.val < prev.val)){
            
            // if this is first violation , mark these two nodes as first and middle
            if(first == null){
                first = prev;
                middle = root;
            }
            else{ // second violation
                last = root;
            }
        }

        // Mark this node as previous
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first != null && last != null){
            //swap both
            int t = first.val;
            first.val = last.val;
            last.val = t;
            
        }
        else if(first != null && middle != null){
            //swap both
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
             
        }
    }
}
