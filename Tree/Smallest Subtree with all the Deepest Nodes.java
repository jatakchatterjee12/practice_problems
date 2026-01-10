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
    class Pair{
        int depth;
        TreeNode node;
        Pair(int d, TreeNode n){
            this.depth = d;
            this.node = n;
        }
    }
    private Pair solve(TreeNode root){

        if(root == null){
            return new Pair(0, null);
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        if(left.depth > right.depth){
            return new Pair(left.depth+1, left.node);
        }
        else if(left.depth < right.depth){
            return new Pair(right.depth+1, right.node);
        }

        return new Pair(left.depth+1, root); // left.depth == right.depth, return the root
    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root).node;
    }
}
