//DFS

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
