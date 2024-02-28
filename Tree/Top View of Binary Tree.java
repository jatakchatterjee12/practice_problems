/*
    Company   :  Paytem, Ola Cabs, Walmart
    GFG Link  :  https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
*/

//**************************************************** C++ *********************************************//
/*
struct Node
{
    int data;
    Node* left;
    Node* right;
};
*/
class Solution
{
    public:
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    vector<int> topView(Node *root)
    {
        
        vector<int> ans;
        if(!root) return ans;
        
        map<int, int> mp;
        queue<pair<int, Node*>> q;
        
        q.push({0, root});
        
        while(!q.empty()) {
            int hd = q.front().first;
            Node* tmp = q.front().second;
            q.pop();
            
            if(mp.find(hd) == mp.end()) { // if we visit the vertical lines for the first time then only consider the node  as our ansr
                mp[hd] = tmp->data;
            }
            
            if(tmp->left){
                q.push({hd-1, tmp->left});
            }
            if(tmp->right){
                q.push({hd+1, tmp->right});
            }
        }
        
        for(auto &it : mp) {
            int nodeVal = it.second;
            ans.push_back(nodeVal);
        }
        return ans;
    }

};

//************************************************ JAVA *******************************************************//


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Pair{
    int hd;
    Node node;
    Pair( Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int hd = it.hd;
            Node tmp = it.node;
            
            if(mp.get(hd) == null) mp.put(hd, tmp.data); // only for the first time we take the node for every vertical index
            
            if(tmp.left != null) q.add(new Pair(tmp.left, hd-1));
            if(tmp.right != null) q.add(new Pair(tmp.right, hd+1));
        }
        
        for(int val : mp.values()) {
            ans.add(val);
        }
        return ans;
        
    }
}
