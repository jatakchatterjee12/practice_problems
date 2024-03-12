/*
    Company Tags  : Flipkart, Amazon, Microsoft
    GFG Link      : https://www.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1
*/

class Solution
{   
    static void solve(Node root, int low, int high, ArrayList<Integer> ans) {
        
        if(root == null) return;
        
        if(root.data > high){
            solve(root.left, low, high, ans);
        }
        else if(root.data < low) {
            solve(root.right, low, high, ans);
        }
        else {
            
            solve(root.left, low, high, ans);
            ans.add(root.data);
            solve(root.right, low, high, ans);
        }
    }
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        
        ArrayList<Integer> ans = new ArrayList<>();
        solve(root, low, high, ans);
        return ans;
    }
    
}
