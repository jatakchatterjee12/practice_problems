/*
     
      Company Tags                : META
      Leetcode Link               : https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
*/

/************************************************ C++ **********************************************************//

//DFS - Using Visited Array
class Solution {
public:
    int count = 0;
    void dfs(int node, int parent, vector<vector<pair<int, int>>>& adj, vector<bool>& visited) {
        visited[node] = true;
        
        for (auto& [child, sign] : adj[node]) {
            if (!visited[child]) {
                count += sign;
                dfs(child, node, adj, visited);
            }
        }
    }

    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& connection : connections) {
            adj[connection[0]].push_back({connection[1], 1});
            adj[connection[1]].push_back({connection[0], 0});
        }
        vector<bool> visited(n, false);
        dfs(0, -1, adj, visited);
        return count;
    }
};

//DFS - Without using Visited Array because there will be no cycle and hence this is undirected graph
class Solution {
public:
    int count = 0;
    void dfs(int node, int parent, vector<vector<pair<int, int>>>& adj) {

        for (auto& [child, sign] : adj[node]) {
            if (child != parent) {
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& connection : connections) {
            adj[connection[0]].push_back({connection[1], 1});
            adj[connection[1]].push_back({connection[0], 0});
        }
 
        dfs(0, -1, adj);
        return count;
    }
};



//BFS - Soon



/************************************************************ JAVA *****************************************************/
//DFS - Using Visited Array
class Solution {
    private int count =0;

    private void dfs(int u, boolean[] vis, Map<Integer, List<Pair<Integer, Integer>>> adj){

        vis[u] = true;

        for(Pair p : adj.getOrDefault(u, new ArrayList<>())){
            int v = (int)p.getKey();
            int isOrg = (int)p.getValue();

            if(vis[v] == false){
                if(isOrg == 1){ // original edge and it  goes far from 0 as we start dfs with 0 , so count++
                    count++;
                }
                dfs(v, vis, adj);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

        for(int[] it : connections){
            int u = it[0];
            int v = it[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, 1)) ; // original edge denoted with 1
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new Pair(u, 0)); // fake edge just to travel with dfs denoted with 0

        }

        dfs(0, new boolean[n], adj);

        return count;
    }
}


//DFS - Without using Visited Array because there will be no cycle and hence this is undirected graph
class Solution {
    private int count =0;

    private void dfs(int u, int parent, Map<Integer, List<Pair<Integer, Integer>>> adj){

        for(Pair p : adj.getOrDefault(u, new ArrayList<>())){
            int v = (int)p.getKey();
            int isOrg = (int)p.getValue();

            if(v != parent){
                if(isOrg == 1){ // original edge and it  goes far from 0 as we start dfs with 0 , so count++
                    count++;
                }
                dfs(v, u, adj);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

        for(int[] it : connections){
            int u = it[0];
            int v = it[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, 1)) ; // original edge denoted with 1
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new Pair(u, 0)); // fake edge just to travel with dfs denoted with 0

        }

        dfs(0, -1, adj);

        return count;
    }
}
