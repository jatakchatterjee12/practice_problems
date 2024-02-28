/*
    Company    :  Paytm, Flipkart, Accolite, Amazon, OYO Rooms, Walmart, CouponDunia
    GFG  Link  :  https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/

//*********************************************** C++ *******************************************************//
//Function to return a list containing the bottom view of the given tree.

class Solution {
  public:
    vector <int> bottomView(Node *root) {
       
       vector<int> ans;
       if(!root){
           return ans;
       }
       
       map<int, int> mp;
       queue<pair<Node*,int>> q;
       
       q.push({root, 0});
       
       while(!q.empty()) {
           Node* node = q.front().first;
           int hd = q.front().second;
           q.pop();
           
           mp[hd] = node->data;
           
           if(node->left) q.push({node->left, hd-1});
           if(node->right) q.push({node->right, hd+1});
       }
       
       for(auto &it : mp) {
           ans.push_back(it.second);
       }
       return ans;
    }
};
//************************************************ JAVA *******************************************************//


//User function Template for Java
class Pair{
    int hd;
    Node node;
    
    Pair(Node n, int hd) {
        this.node = n;
        this.hd = hd;
    }
}

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
       
       ArrayList<Integer> ans = new ArrayList<>();
       if(root == null) return ans;
       
       Map<Integer, Integer> mp = new TreeMap<>();
       Queue<Pair> que = new LinkedList<>();
       
       que.add(new Pair(root, 0));
       
       while(!que.isEmpty()) {
           Pair it = que.poll();
           int hd = it.hd;
           Node node = it.node;
           
           mp.put(hd, node.data);
           
           if(node.left != null) {
               que.add(new Pair(node.left, hd-1));
           }
           if(node.right != null) {
               que.add(new Pair(node.right, hd+1));
           }
       }
       
       for(int val : mp.values()) {
           ans.add(val);
       }
       return ans;
    }
}
