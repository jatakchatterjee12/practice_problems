//********************************************** C++ ********************************************************///
//Approach 1 : DFS -> Moderated Preorder Traversal
class Solution {
  void preorder(Node* root, int level, vector<int> &ans) {
    
    if(root == NULL) return;
    
    if(ans.size() < level) {
        ans.push_back(root->data);
    }
    
    preorder(root->left, level+1, ans);
    preorder(root->right, level+1, ans);
  
  }
//Function to return a list containing elements of left view of the binary tree.
  vector<int> leftView(Node *root)
  {
     vector<int> ans;
     if(!root) return ans;
     preorder(root, 1, ans);
  }
}

//Approach 2 : Level Order Traversal

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

//****************************************************** JAVA ********************************************************//
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

// Approach 2: Iteratve BFS(normal) -->> Level Order Traversal
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      
      Queue<Node> q = new LinkedList<>();
      
      q.add(root);
      
      while(!q.isEmpty()) {
          
          ans.add(q.peek().data); //first take in the ans vector
          
          int n = q.size();
          while(n-- > 0) {
              Node node = q.poll();
              if(node.left != null) q.add(node.left); //then go left
              if(node.right != null) q.add(node.right); // then right
          }
      }
      return ans;
    }
}

//Approach 3: one more way to do BFS -->> go right first and then left  and do the level order 
//            traversal and take out the last node in the ans vector
class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null) return ans;
      
      Queue<Node> q = new LinkedList<>();
      
      q.add(root);
      
      while(!q.isEmpty()) {
          
          Node node = null;
          
          int n = q.size();
          while(n-- > 0) {
              node = q.poll();
              if(node.right != null) q.add(node.right // go right
              if(node.left != null) q.add(node.left); // then go left
          }
          ans.add(node.data); // at the end of every level the last one will be the left most node
      }
      return ans;
    }
}
