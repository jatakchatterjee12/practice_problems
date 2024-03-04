/*
    Company Tags     : Flipkart, Amazon, Microsoft, Samsung, D-E-Shaw
    LeetCode Link    : https://leetcode.com/problems/largest-bst-subtree/description/  --> It's a premium Qns on Leetcode
    GFG Link         : https://www.geeksforgeeks.org/problems/largest-bst/1
*/

//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class NodeValue{
    int mini, maxi, size;
    NodeValue(int mini, int maxi, int size) {
        this.mini = mini;
        this.maxi = maxi;
        this.size = size;
    }
}
class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static NodeValue solve(Node root) {
      // An Empty tree is a BSt of size 0
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

      // Get values from left and right subtree of current tree
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);

      //Current node is greater than max in left AND smaller than min in  right, it is a BSt 
        if(left.maxi < root.data && root.data < right.mini) {
          // it is a BST
            return new NodeValue(Math.min(root.data, left.mini), Math.max(root.data, right.maxi), left.size + right.size + 1);
        } 
      
      // Otherwise, return [-inf, inf] so that the parent can't be a valid BST 
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size , right.size));
    }
    
    static int largestBst(Node root)
    {
        return solve(root).size;
         
    }
    
}
