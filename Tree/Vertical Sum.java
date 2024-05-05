/*
    Company Tags     :   Amazon
    Gfg   Link       :   https://www.geeksforgeeks.org/problems/vertical-sum/1
*/

//************************************************** C++ ****************************************************//

//Approach 1: store in map and then calculate the sum

class Solution{
  public:
    void preorder(Node* root, int level, map<int, vector<int>> &mp){
        
        if(!root) return;
        mp[level].push_back(root->data);
        
        preorder(root->left, level-1, mp);
        preorder(root->right, level+1, mp);
    } 
        
        
    vector <int> verticalSum(Node *root) {
       
       map<int , vector<int>> mp;
       
       preorder(root, 0, mp);
       
       vector<int> result;
       
       for(auto it: mp) {
           vector<int> val = it.second;
           
           int sum = 0;
           for(int x : val){
               sum += x;
           }
           result.push_back(sum);
       }
       
       return result;
    }
};




//Approach 2: Modification : Directly store the sum in the map
class Solution{
  public:
    void preorder(Node* root, int level, map<int, int> &mp){
        
        if(!root) return;
        mp[level] += root->data;
        
        preorder(root->left, level-1, mp);
        preorder(root->right, level+1, mp);
    } 
        
        
    vector <int> verticalSum(Node *root) {
       
       map<int ,int> mp;
       
       preorder(root, 0, mp);
       
       vector<int> result;
       
       for(auto it: mp) {
           
           result.push_back(it.second);
       }
       
       return result;
    }
};





//********************************************************* JAVA ************************************************//

//Approach 1: store in map and then calculate the sum

class Solution{
    void preorder(Node root, int level, TreeMap<Integer, List<Integer>> mp) {
        
        if(root == null) return;
        
        mp.computeIfAbsent(level, k-> new ArrayList<>()).add(root.data);
        
        preorder(root.left, level-1, mp);
        preorder(root.right, level+1, mp);
    }
    public ArrayList <Integer> verticalSum(Node root) {
       TreeMap<Integer, List<Integer>> mp = new TreeMap<>();
       
       preorder(root, 0, mp);
       
       ArrayList<Integer> result = new ArrayList<>();
       
       for(Map.Entry<Integer, List<Integer>> entry : mp.entrySet()) {
           
           List<Integer> list = entry.getValue();
           int sum = 0;
           for(int it : list){
               sum += it;
           }
           
           result.add(sum);
       }
       return result;
       
    }
}




//Approach 2: Modification : Directly store the sum in the map
class Solution{
    void preorder(Node root, int level, TreeMap<Integer, Integer> mp) {
        
        if(root == null) return;
        
        mp.put(level, mp.getOrDefault(level,0) + root.data);
        
        preorder(root.left, level-1, mp);
        preorder(root.right, level+1, mp);
    }
    public ArrayList <Integer> verticalSum(Node root) {
       TreeMap<Integer, Integer> mp = new TreeMap<>();
       
       preorder(root, 0, mp);
       
       ArrayList<Integer> result = new ArrayList<>();
       
       for(int val : mp.values()) {
           
          
           result.add(val);
       }
       return result;
       
    }
}
