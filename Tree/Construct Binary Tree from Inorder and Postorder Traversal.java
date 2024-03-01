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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length; // == inorder.length

        Map<Integer, Integer> inorderMp = new HashMap<>();
        for(int i=0; i<n; i++) {
            inorderMp.put(inorder[i], i);
        }

        TreeNode root = solve(inorder, 0, n-1, postorder, 0, n-1, inorderMp);
        return root;
    }

    TreeNode solve(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inorderMp) {

        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot =  inorderMp.get(root.val); // index of root at inorder
        int numsInLeftTree = inRoot - inStart;

        root.left = solve(inorder, inStart, inRoot-1, postorder, postStart, postStart + numsInLeftTree - 1, inorderMp);
        root.right = solve(inorder, inRoot+1, inEnd, postorder, postStart + numsInLeftTree, postEnd-1, inorderMp);
        
        return root;
    }
}
