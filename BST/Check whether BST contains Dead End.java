/*
    GFG Link  : https://www.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution
{
    static boolean solve(Node root, int mini, int maxi) {
        
        if(root == null) return false;
        
        if(root.left == null && root.right == null) {
            if(mini == Integer.MIN_VALUE && maxi - root.data == 1 && root.data == 1 
            || (root.data - mini == 1 && maxi - root.data == 1)){
                return true;
            }
        }
        
        return solve(root.left, mini, root.data) || solve(root.right, root.data, maxi);
        
    }
    public static boolean isDeadEnd(Node root)
    {
        return solve(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// node values range - 1 <= val <= INT_MAX

//Function should return true if a deadEnd is found in the bst otherwise return false.
class Solution
{
    static boolean solve(Node root, int mini, int maxi) {
        
        if(root == null) return false;
        
        if(root.left == null && root.right == null) {
            if(root.data - mini == 1 && maxi - root.data == 1){
                return true;
            }
        }
        
        return solve(root.left, mini, root.data) || solve(root.right, root.data, maxi);
        
    }
    public static boolean isDeadEnd(Node root)
    {
        return solve(root, 0, Integer.MAX_VALUE);
    }
}
