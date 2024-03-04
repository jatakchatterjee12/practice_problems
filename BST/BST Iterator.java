// Only push the left elements of root into the stack. 
//when next() is called... pop out the element and again push all the left elements of poped out node into stack as we need the right guy for the next() call next time

//TC - O(H) . only pushing left elements..so height of the tree 
// SC - O(1) .. Through out the life... there is total n node put into the stack.. and n times next() called..so (n/n)~ O(1)

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
class BSTIterator {
    private Stack<TreeNode> myStack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tmpNode = myStack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !myStack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        for(; root != null; myStack.push(root), root = root.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
