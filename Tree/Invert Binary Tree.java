//Approach 1 : Using DFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;
        
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);

        return root;
    }
}


//Approach 2 : Using Level Order Traversal (BFS)

class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) return null;

        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        return root;
    }
}
