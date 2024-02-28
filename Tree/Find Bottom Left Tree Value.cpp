/*
    Company Tags                : Microsoft
    Leetcode Link               : https://leetcode.com/problems/find-bottom-left-tree-value/
*/

/********************************************************** C++ **********************************************************/
//Approach-1 (Using DFS)
//T.C : O(n)
//S.C : O(max depth of tree)
class Solution {
public:
    int maxDepth;
    int bottomLeft;
    
    void solve(TreeNode* root, int currDepth) {
        if(!root) {
            return;
        }
        
        if(currDepth > maxDepth) { // visisting the current level or depth  for very first time 
            maxDepth   = currDepth;
            bottomLeft = root->val;
        }
        
        solve(root->left, currDepth+1);
        solve(root->right, currDepth+1);
    }
    
    int findBottomLeftValue(TreeNode* root) {
        maxDepth = -1;
        
        solve(root, 0);
        return bottomLeft;
        
    }
};


//Approach-2 (Using BFS)
//T.C : O(n)
//S.C : O(n) for queue
class Solution {
public:
    int findBottomLeftValue(TreeNode* root) {
        queue<TreeNode*> que;
        
        int bottomLeft;
        que.push(root);
        
        while(!que.empty()) {
            TreeNode* node = que.front();
            que.pop();
            
            bottomLeft = node->val;
            
            if(node->right) {
                que.push(node->right);
            }
            if(node->left) {
                que.push(node->left);
            }
        }
        
        return bottomLeft;
    }
};


//Approach-3 (Using BFS with inner while loop)
//T.C : O(n)
//S.C : O(n) for queue
class Solution {
public:
    int findBottomLeftValue(TreeNode* root) {
        queue<TreeNode*> que;
        
        int bottomLeft;
        que.push(root);
        
        while(!que.empty()) {
            int n = que.size();

            TreeNode* node;
            while(n--) {
                node = que.front();
                que.pop();
                
                
                if(node->right) {
                    que.push(node->right);
                }
                if(node->left) {
                    que.push(node->left);
                }
            }
           bottomLeft = node->val;
            
        }
        
        return bottomLeft;
    }
};



/********************************************************** JAVA **********************************************************/
//Approach-1 (Using DFS)
//T.C : O(n)
//S.C : O(max depth of tree)
class Solution {
    private int maxDepth;
    private int bottomLeft;
    
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = -1;
        
        solve(root, 0);
        return bottomLeft;
    }
    
    private void solve(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }
        
        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            bottomLeft = root.val;
        }
        
        solve(root.left, currDepth + 1);
        solve(root.right, currDepth + 1);
    }
}


//Approach-2 (Using BFS)
//T.C : O(n)
//S.C : O(n) for queue
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        int bottomLeft = 0;
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            bottomLeft = node.val;
            
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }
        
        return bottomLeft;
    }
}


//Approach-3 (Using BFS with inner while loop)
//T.C : O(n)
//S.C : O(n) for queue
class Solution {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        
        int bottomLeft = -1;
        que.add(root);
        
        while(!que.isEmpty()) {
            int n = que.size();
            
            TreeNode node = null;
            
            while(n-- > 0) {
                node = que.poll();
            
                
                if(node.right !=  null) {
                    que.add(node.right);
                }
                if(node.left != null) {
                    que.add(node.left);
                }
            }
            bottomLeft = node.val;
            
        }
        
        return bottomLeft;
    }
};
