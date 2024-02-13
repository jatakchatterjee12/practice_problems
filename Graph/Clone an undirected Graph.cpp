/*
            GFG Link    :  https://www.geeksforgeeks.org/problems/clone-graph/1
*/

//********************************************* C++ ******************************************************//
// struct Node {
//     int val;
//     vector<Node*> neighbors;
//     Node() {
//         val = 0;
//         neighbors = vector<Node*>();
//     }
//     Node(int _val) {
//         val = _val;
//         neighbors = vector<Node*>();
//     }
//     Node(int _val, vector<Node*> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// };

class Solution {
public:
    Node* cloneGraph(Node* node) {
        Node* myStart = new Node(node->val);
        map<int, Node*> vis;
        
        function<void(Node *, Node *)> dfs = [&](Node* my_node, Node* org_node) {
            vis[my_node->val] = my_node;
            
            for(auto child : org_node->neighbors){
                bool not_vis = vis.find(child->val) == vis.end(); // means not visited yet
                Node* new_child;
                
                if(not_vis){
                    new_child = new Node(child->val);
                }
                else {
                    new_child = vis[child->val];
                }
                
                (my_node -> neighbors).push_back(new_child);
                
                if(not_vis){
                    dfs(new_child, child);
                }
            }
        };
        
        dfs(myStart, node);
        return myStart;
    }
};

//******************************************** JAVA *********************************************************//
// /*
//     class Node{
//         int val;
//         ArrayList<Node> neighbors;
//         public Node(){
//             val = 0;
//             neighbors = new ArrayList<>();
//         }
    
//         public Node(int val){
//             this.val = val;
//             neighbors = new ArrayList<>();
//         }
    
//         public Node(int val, ArrayList<Node> neighbors){
//             this.val = val;
//             this.neighbors = neighbors;
//         }
//     }
// */
class Solution{
    Map<Integer, Node> vis = new HashMap<>();
    void dfs(Node myNode, Node org_node){
        
        vis.put(myNode.val, myNode);
        
        for(Node child : org_node.neighbors){
            boolean not_vis = !vis.containsKey(child.val);
            
            Node newNode;
            
            if(not_vis == true){
                newNode = new Node(child.val);
            }
            else{
                newNode = vis.get(child.val);
            }
            
            (myNode.neighbors).add(newNode);
            
            if(not_vis) dfs(newNode, child);
        }
    }
    Node cloneGraph(Node node){
        Node myNode = new Node(node.val);
        
        dfs(myNode, node);
        return myNode;
    }
}
