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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = preorder.length;

        Map<Integer, Integer> inorderMp = new HashMap<>();
        for(int i=0; i<n; i++) {
            inorderMp.put(inorder[i], i);
        }

        TreeNode root = solve(preorder, 0, n-1, inorder, 0, n-1, inorderMp);
        return root;

    }

    TreeNode solve(int[] preorder,int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inorderMp) {

        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inorderMp.get(root.val);
        int numsInLeftTree = inRoot - inStart;

        root.left = solve(preorder, preStart+1, preStart + numsInLeftTree, inorder, inStart, inRoot-1, inorderMp);
        root.right = solve(preorder,preStart + numsInLeftTree + 1, preEnd,  inorder,inRoot+1, inEnd, inorderMp);

        return root;
    }
}
