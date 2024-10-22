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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>(); // min-heap

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){

            int size = que.size();
            long levelSum = 0;

            while(size-- > 0){
                TreeNode currNode = que.poll();

                if(currNode.left != null){
                    que.add(currNode.left);
                }
                if(currNode.right != null){
                    que.add(currNode.right);
                }

                levelSum += currNode.val;
            }

            pq.add(levelSum);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.size() < k ? -1 : pq.peek();

    }
}
