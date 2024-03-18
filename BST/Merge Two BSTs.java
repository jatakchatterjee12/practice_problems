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

//********************************************************* C++ ***********************************************************8
//Iterative Approach : Using Stack
/*
struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
*/
class Solution
{
    public:
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    vector<int> merge(Node *root1, Node *root2)
    {
       //Your code here
       stack<Node*> st1, st2;
       
       vector<int> ans ;
       
       while(root1){
           st1.push(root1);
           root1  =root1->left;
       }
       
       while(root2){
           st2.push(root2);
           root2 = root2->left;
       }
       
       while(!st1.empty() && !st2.empty()) {
           
           if(st1.top()->data < st2.top()->data){
               ans.push_back(st1.top()->data);
               root1 = st1.top()->right;
               st1.pop();
           }
           else{
               ans.push_back(st2.top()->data);
               root2 = st2.top()->right;
               st2.pop();
           }
           
           while(root1){
               st1.push(root1);
               root1  =root1->left;
            }
       
           while(root2){
               st2.push(root2);
               root2 = root2->left;
           }
           
           
       }
       
       while(!st1.empty()) {
           ans.push_back(st1.top()->data);
           root1 = st1.top()->right;
           st1.pop();
           
           while(root1){
               st1.push(root1);
               root1 = root1->left;
           }
       }
       
       while(!st2.empty()) {
           ans.push_back(st2.top()->data);
           root2 = st2.top()->right;
           st2.pop();
           
           while(root2){
               st2.push(root2);
               root2 = root2->left;
           }
       }
       
       return ans;
       
    }
};
