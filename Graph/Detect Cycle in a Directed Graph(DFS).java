/*
  Company Tags                : Flipkart, Amazon, Microsoft, Samsung, MakeMyTrip, Oracle, Adobe, BankBazaar
  Gfg Link                    : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

//********************************************** C++ ****************************************************//

class Solution {
  public:
    
    bool isCycleDFS(vector<int> adj[], int u, vector<bool>& visited, vector<bool>& inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        
        
        for(int &v : adj[u]) {
            //if not visited, then we check for cycle in DFS
            if(visited[v] == false && isCycleDFS(adj, v, visited, inRecursion))
                return true;
            else if(inRecursion[v] == true)
                return true;
        }
        
        inRecursion[u] = false;
        return false;
        
    }
    
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<int> adj[]) {
        vector<bool> visited(V, false);
        vector<bool> inRecursion(V, false);
        
        for(int i = 0; i<V; i++) {
            if(!visited[i] && isCycleDFS(adj, i, visited, inRecursion))
                return true;
        }
        
        return false;
    }
};

//************************************************* JAVA ************************************************//


/*Complete the function below*/

class Solution {
    private boolean checkDFS(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] inRecursion) {
        vis[node] = true;
        inRecursion[node] = true;
        
        for(int v : adj.get(node)){
            if(!vis[v]){
                if(checkDFS(v,adj,vis,inRecursion)){
                    return true;
                }
            }
            else if(inRecursion[v]){
                return true;
            }
        }
        
        inRecursion[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] vis = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        
        for(int i = 0; i < V; i++) {
            if(!vis[i]){
                if(checkDFS(i, adj, vis, inRecursion)){
                    return true;
                }
            }
        }
        return false;
    }
}
