//Approach 1 : Recursive Way;
// Using Reverse Post Order ----> Right Left Root
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.right); /// start with extreme right and start making 
        flatten(root.left); 

        root.right = prev; // making right hand the prev root(As start with extreme right part of the tree)
        root.left = null // making left hand null

        prev = root;


    }
}

// Approach 2 : Using Stack
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
    public void flatten(TreeNode root) {
        if(root == null) return;

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.empty()){
            TreeNode curr = st.pop();

            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);

            if(!st.empty()){
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
}
