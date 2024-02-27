//Approach 1 : DFS -> Moderated Preorder Traversal
class Solution {
  void solve(TreeNode root, int level, List<Integer> result){
    if(root == null) return;

    if(result.size() < level) 
        result.add(root.val);

    solve(root.left, level+1, result);
    solve(root.right, level+1, result);
  }
    public List<Integer> leftSideView(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      solve(root, 1, result);
      return result;
    }
}

//Approach 2 : Level Order Traversal


/* A binary tree node

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
 */

//Function to return a list containing elements of left view of the binary tree.
vector<int> leftView(Node *root)
{
    vector<int> ans;
    if(!root) return ans;
    
   queue<Node*> q;
   q.push(root);

   while(!q.empty()) {
       
       //first element of current level
       ans.push_back(q.front()->data);
       
       int n = q.size();
       while(n--) {
           Node* tmp = q.front();
           q.pop();
           
           if(tmp->left){ // go left
               q.push(tmp->left);
           }
           if(tmp->right) { // go right
               q.push(tmp->right);
           }
       }
   }
   return ans;
}

