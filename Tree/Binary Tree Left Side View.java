// DFS -> Moderated Preorder Traversal
class Solution {
  void solve(TreeNode root, int level, List<Integer> result){
    if(root == null) return;

    if(result.size() < level) 
        result.add(root.val);

    solve(root.left, level+1, result);
    solve(root.right, level+1, result);
  }
    public List<Integer> leftSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      solve(root, 1, result);
      return result;
    }
}
