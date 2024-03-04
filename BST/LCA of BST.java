class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) { return null; }
    if (root.val > p.val && root.val > q.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (root.val < p.val && root.val < q.val) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root; // i.e  p  and q lie in opposite subtree of the current node...that is the lca
    }
  }
}
