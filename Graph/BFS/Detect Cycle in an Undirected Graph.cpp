class Graph {

public:
    bool detectCycle(int V, vector<int> adj[]) {
        
        vector<bool> vis(V+1, false);
    
        for(int i = 0; i <V; i++) {
            if(!vis[i]) {
               if( checkCycle(i,adj, vis) == true){
                   return true;
               }
            }
        }
        return false;
    }


    bool checkCycle(int src, vector<int>adj[], vector<bool> &vis) {
        queue<pair<int, int>> que; // {node, parent}

        que.push({src, -1});
        vis[src]  =true;

        while(!que.empty()) {

            int  node = que.front().first;
            int par = que.front().second;
            que.pop();

            for(int it : adj[node]) {
                if(!vis[it]) {
                    que.push({it, node});
                    vis[it]  =true;
                }
                else if(it != par) {
                    return true;
                }
            }
        }
        return false;
    }

};
