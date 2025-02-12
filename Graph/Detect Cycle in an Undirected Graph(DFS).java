
/*
    Company Tags  : Flipkart, Amazon, Samsung, MakeMyTrip, Oracle, Adobe
    Question Link : https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
*/

//************************************************************** C++ *************************************************//
class Graph {

public:
    bool detectCycle(int V, vector<int> adj[]) {
        
        vector<bool> vis(V+1, false);
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
               if( checkCycle(i,-1,adj, vis) == true){
                   return true;
               }
            }
        }
        return false;
    }
    
    bool checkCycle(int src, int parent, vector<int>adj[], vector<bool> &vis) {
       
       vis[src] = true;

       for(int adjNode : adj[src]) {
           if(!vis[adjNode]) {
               if(checkCycle(adjNode, src, adj, vis) == true){
                   return true;
               }
           }
           else if(adjNode != parent) return true;
       }

       return false;
    }

};


//************************************************************* JAVA ********************************************//


class Solution {
    private boolean checkDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[node] = true;
        
        for(int v : adj.get(node)){
            if(!vis[v]){
                
                if(checkDFS(v,node,adj,vis)){
                    return true;
                }
            }
            else if(v != parent){
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
       
       int V = adj.size();
       boolean[] vis = new boolean[V];
       
       for(int i = 0; i < V; i++){
           if(!vis[i] && checkDFS(i, -1, adj, vis)){
               return true;
           }
       }
       return false;
    }
}
