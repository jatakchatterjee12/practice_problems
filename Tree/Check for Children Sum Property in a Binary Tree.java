/*
    Company    :  Intuit
    GFG Link   :  https://www.geeksforgeeks.org/problems/children-sum-parent/1
*/

//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        if(root == null || root.left == null && root.right == null )
            return 1;
        
        
        int l = 0;
        int r = 0;
        if(root.left != null) {
            l = root.left.data;
        }
        
        if(root.right != null) {
            r = root.right.data;
        }
        
        if(root.data == l+r && isSumProperty(root.left) == 1 && isSumProperty(root.right) == 1){
            return 1;
        }
        return 0;
        
    }
}
