/*
    Company Tags   : 
    LeetCode Link  : https://leetcode.com/problems/check-completeness-of-a-binary-tree/description/
*/

/* Idea  :  BFS
    Use BFS to do a level order traversal,
    add childrens to the bfs queue,
    until we met the first empty node.
    
    For a complete binary tree,
    there should not be any node after we met an empty one.
    
    Time O(N), Space O(N)

*/                   

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.peek() != null) {

            TreeNode node = q.poll();
            q.add(node.left);
            q.add(node.right);
        }

        while(!q.isEmpty() && q.peek() == null) {
            q.poll();
        }

        return q.isEmpty();
    }
}

// Idea is if we do a level order traversal and we see a non emptyNode followed by an empty node,
// it isn't a complete binary tree.

public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean seenEmpty = false;
        
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                seenEmpty = true;
                continue;
            } else if (seenEmpty) {
                    return false;
            }
            
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        
        return true;
    }
