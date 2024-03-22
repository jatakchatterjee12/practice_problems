//////////////////////////////         GFG Problem Solution

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	   
	   ArrayList<Integer> ans = new ArrayList<>();
	   
	   if(root == null) return ans;
	   
	   Queue<Node> q = new LinkedList<>();
	   
	   q.add(root);
	   boolean flag = true;
	   
	   
	   while(!q.isEmpty()) {
	       
	       int levelSize = q.size();
	       List<Integer> temp = new ArrayList<>();
	       
	       while(levelSize-- > 0){
	       
    	       if(q.peek().left != null) q.add(q.peek().left);
    	       if(q.peek().right != null) q.add(q.peek().right);
    	       
    	       if(flag == true){
    	           temp.add(q.poll().data);
    	       }
    	       else{
    	           temp.add(0, q.poll().data);
    	       }
	       }
	       
	       flag = !flag;
	       
	       for(int i = 0; i < temp.size(); i++){
	           ans.add(temp.get(i));
	       }
	   }
	   return ans;
	}
}


//////////////////////////////////////////    LeetCode Solution


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ansList = new LinkedList<>();

        if(root == null) return ansList;

        q.offer(root);
        boolean flag = true;

        while(!q.isEmpty()){
            int levelnum = q.size();
            List<Integer> subList = new LinkedList<>();

            for(int i=0;i<levelnum;i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                
                if(flag){
                    subList.add(q.poll().val);
                } 
                else{
                    subList.add(0,q.poll().val);
                }  
            }

            flag = !flag;
            ansList.add(subList);            
        }

        return ansList;
    }
}
