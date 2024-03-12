/*
    Company Tags : Amazon
    GFG Link     : https://www.geeksforgeeks.org/problems/print-common-nodes-in-bst/1
*/

//Inorder Traversal and compare nodes for both trees.. 
class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Node> st1 = new Stack<>(), st2 = new Stack<>();
        
        while(root1 != null) {
            st1.push(root1);
            root1 = root1.left;
        }
        while(root2 != null) {
            st2.push(root2);
            root2 = root2.left;
        }
        
        while(!st1.isEmpty() && !st2.isEmpty()) {
            
            if(st1.peek().data == st2.peek().data) {
                ans.add(st1.peek().data);
                
                root1 = st1.pop().right;
                root2 = st2.pop().right;
                
            }
            
            //st1 > st2
            else if(st1.peek().data > st2.peek().data){
                
                root2 = st2.pop().right;
            }
            else{
                // st2 > st1
                
                root1 = st1.pop().right;
            }
            
            while(root1 != null) {
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null) {
                st2.push(root2);
                root2 = root2.left;
            }
        }
        return ans;
    }
}
