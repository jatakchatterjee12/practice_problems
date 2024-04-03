/*
  struct Node
  {
  	int data;
  	struct Node *left, *right;
  };
*/


class Solution
{
    public:
    
    Node* LCA(Node* root, int x, int y) {
        
        if(!root) return NULL;
        
        if(root->data > x && root->data > y){
            return LCA(root->left, x, y);
        }
        
        else if(root->data < x && root->data < y){
            return LCA(root->right, x, y);
        }
        
        return root;
    }
    
    void solve(Node* root, Node* lca, vector<int> &path) {
        
        path.push_back(root->data);
        
        if(root->data > lca->data){
            solve(root->left, lca, path);
        }
        else if(root->data < lca->data){
            solve(root->right, lca, path);
        }
        
        return;
    }
    
    /*You are required to complete below function */
    int kthCommonAncestor(Node *root, int k,int x, int y)
    {
       
       Node *lca = LCA(root, x, y);
       vector<int> path;
       solve(root, lca, path);
       
       if(path.size() < k) return -1;
       return path[path.size() - k];
    }
};
