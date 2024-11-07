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
    public boolean isCousins(TreeNode root, int x, int y) {

        if(x == root.val || y == root.val) return false;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){

            int n = que.size();
            boolean gotX = false;
            boolean gotY = false;


            while(n-- > 0) {

               TreeNode curr = que.poll(); 

               if(curr.val == x) gotX = true;
               if(curr.val == y) gotY = true;

               if(curr.left != null && curr.right != null){

                    if((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }
               }

               if(curr.left != null) que.add(curr.left);
               if(curr.right != null) que.add(curr.right);

            }

            if(gotX && gotY){
                return true;
            }
        }

        return false;
    }
}
