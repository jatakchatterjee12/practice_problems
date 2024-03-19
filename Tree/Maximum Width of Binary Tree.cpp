/**/

//******************************************** C++ *****************************************************************************
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        if(root == NULL) return 0;
        
        queue<pair<TreeNode*, long long>> que;
        long long maxW = 0;

        que.push({root, 0});

        while(!que.empty()) {
            int size = que.size();

            int level_min = que.front().second;

            long long first = 0;
            long long  last  = 0;

            for(int i = 0; i < size; i++) {
                TreeNode* node = que.front().first;
                long long curr_id   = que.front().second - level_min;
                que.pop();

                if(i == 0) first = curr_id;
                if(i == size - 1) last = curr_id;

                if(node->left) que.push({node->left, curr_id*2 + 1});
                if(node->right) que.push({node->right, curr_id*2 + 2});
            }

            maxW = max(maxW, last - first + 1);
        }
        return maxW;
    }
};


//********************************************** JAVA ************************************************************************8
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Pair{
    TreeNode node;
    long idx;
    Pair(TreeNode node, long idx){
        this.node = node;
        this.idx = idx;
    }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));

        long maxW = 0L;

        while(!que.isEmpty()) {
            int size = que.size();
            long level_min = que.peek().idx;

            long first = 0L;
            long last = 0L;

            for(int i = 0; i < size; i++) {

                Pair p = que.poll();
                TreeNode node = p.node;
                long curr_id = p.idx - level_min;

                if(i == 0) first = curr_id;
                if(i == size-1) last = curr_id;

                if(node.left != null) que.add(new Pair(node.left, (curr_id*2)+1));
                if(node.right != null) que.add(new Pair(node.right, (curr_id*2)+2));
            }

            maxW = Math.max(maxW, last - first + 1);
           
        }
        return (int)maxW;
    }
}
