//Approach 1:
 public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<TreeNode>();
     TreeNode p = root;
     int count = 0;
     
     while(!stack.isEmpty() || p != null) {
         if(p != null) {
             stack.push(p);    // Just like recursion
             p = p.left;   
             
         } else {
            TreeNode node = stack.pop();
            if(++count == k) return node.val; 
            p = node.right;
         }
     }
     
     return Integer.MIN_VALUE;
 }


//Approach 2: 
  // better keep these two variables in a wrapper class
  private static int number = 0;
  private static int count = 0;

  public int kthSmallest(TreeNode root, int k) {
      count = k;
      helper(root);
      return number;
  }
  
  public void helper(TreeNode n) {
      if (n.left != null) helper(n.left);
      count--;
      if (count == 0) {
          number = n.val;
          return;
      }
      if (n.right != null) helper(n.right);
  }

//Approach 3:

class Solution {
    void  solve(TreeNode root, int k, List<Integer> list){
        if(root == null) return;

        solve(root.left, k, list);
        if(list.size() != k) list.add(root.val);

        if(list.size() !=  k) solve(root.right, k, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        solve(root, k, list);
        return list.get(k-1);
    }
}
