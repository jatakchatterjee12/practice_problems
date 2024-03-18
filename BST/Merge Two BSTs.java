/*
      Company TAgs     :  Amazon, Microsoft, Google
      GFG  Link        :  https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
*/

//User function Template for Java


/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
    
*/
class Solution
{
    void inorder(Node root, List<Integer> ans) {
        
        if(root == null) return;
        
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        
        inorder(root1,ans1);
        inorder(root2,ans2);
        
        List<Integer> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        int n = ans1.size();
        int m = ans2.size();
        
        while(i < n && j < m) {
            
            if(ans1.get(i) < ans2.get(j)) {
                ans.add(ans1.get(i));
                i++;
            }
            else{
                ans.add(ans2.get(j));
                j++;
            }
        }
        
        while(i < n){
            ans.add(ans1.get(i));
            i++;
        }
        while(j < m){
            ans.add(ans2.get(j));
            j++;
        }
        
        return ans;
        
    }
}
