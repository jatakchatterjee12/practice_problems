/*
           Company tags      : Accolite, Amazon
           GFG Link          : https://www.geeksforgeeks.org/problems/diagonal-sum-in-binary-tree/1
*/

/*************************************************** C++ **********************************************************************
/*Complete the function below
Node is as follows:
struct Node{
    int data;
    Node *left,*right;
};
*/

class Solution {
  public:
    void solve(Node* root, int level, map<int,int> &mp){
        
        if(!root) return;
        
        mp[level] += root->data;
        
        solve(root->right, level, mp);
        
        solve(root->left, level+1, mp);
    }
    vector<int> diagonalSum(Node* root) {
        
        map<int, int> mp;
        solve(root, 0, mp);
        
        vector<int> ans;
        
        for(auto &it : mp) {
            ans.push_back(it.second);
        }
        
        return ans;
        
    }
}; 

/************************************************* JAVA ***********************************************************************
class Tree {
    static void solve(Node root, int level, TreeMap<Integer, Integer> mp) {
        
        if(root ==  null) return;
        
        mp.put(level, mp.getOrDefault(level,0) + root.data);
        
        solve(root.right, level, mp);
        solve(root.left, level+1, mp);
        
    }
    public static ArrayList <Integer> diagonalSum(Node root) 
    {
        
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        
        solve(root, 0, mp);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> it : mp.entrySet()) {
            ans.add(it.getValue());
        }
        
        return ans;
    }
}
