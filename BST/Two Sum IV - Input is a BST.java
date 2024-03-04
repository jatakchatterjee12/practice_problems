// Using BST Iterator concept.
// next -- for sorting in ascending order... inorder
//before -- for sorting in descending order... reverse inorder

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
class BSTIterator{
    Stack<TreeNode> st = new Stack<>();
    // rev == true  -> before
    //rev == false -> next
    boolean rev = true;

    public BSTIterator(TreeNode root, boolean isReverse){
        rev = isReverse;
        pushAll(root);
    }

    public boolean hasNext(){
        return !st.isEmpty();
    }

    public int next() {
        TreeNode tmp = st.pop();

        if(rev == true) pushAll(tmp.left);
        else pushAll(tmp.right);

        return tmp.val;
    }
    private void pushAll(TreeNode root){
        while(root != null) {
            st.push(root);

            if(rev == true) root = root.right;
            else root  = root.left;
        }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next(); // next
        int j = r.next(); // before

        while(i < j) {
            if(i + j == k) return true;
            else if(i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
