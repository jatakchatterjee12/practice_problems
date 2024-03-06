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
    private void solve(TreeNode root, long sum, int targetSum, Map<Long, Integer> mp, int[] total) {
        if(root == null) return;

        sum += root.val;
        if(mp.containsKey(sum - targetSum)) {
            total[0] = total[0] + mp.get(sum - targetSum);
        }

        mp.put(sum, mp.getOrDefault(sum, 0) + 1);

        solve(root.left, sum, targetSum, mp, total);
        solve(root.right, sum, targetSum, mp, total);

        mp.put(sum, mp.get(sum)-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int[] total = new int[1];
        Map<Long, Integer> mp = new HashMap<>();
        mp.put((long)0, 1);
        solve(root, 0, targetSum, mp, total);
        return total[0];
    }
}
