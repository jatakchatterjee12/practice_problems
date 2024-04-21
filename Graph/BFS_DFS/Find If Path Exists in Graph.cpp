/*
    Company Tags                : Microsoft, Adobe, Amazon, Morgan Stanley, Samsung
    Leetcode Link               : https://leetcode.com/problems/find-if-path-exists-in-graph/
*/

//Using DFS : O(m+n)
class Solution {
public:
    bool dfs(unordered_map<int, vector<int>> &mp, int node, int destination, vector<int> &vis) {

        if(node == destination) return true;


        vis[node] = 1;

        for(auto it : mp[node]) {
            if(vis[it] == 0){
                if(dfs(mp, it, destination, vis) == true){
                    return true;
                }
            }
        }
        return false;
    }
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {

        if(source == destination) return true;
        unordered_map<int, vector<int>> mp;

        for(auto edge : edges) {
            int u = edge[0];
            int v = edge[1];

            mp[u].push_back(v);
            mp[v].push_back(u);
        }

        vector<int> vis(n, 0);

        return dfs(mp, source, destination, vis);
    }
};




//BFS - O(m+n)
class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        
        if(source == destination) return true;
        unordered_map<int, vector<int>> mp;

        for(auto edge : edges) {
            int u = edge[0];
            int v = edge[1];

            mp[u].push_back(v);
            mp[v].push_back(u);
        }

        queue<int> que;
        vector<int> vis(n, 0);
        
        que.push(source);
        vis[source] = 1;

        while(!que.empty()) {
            int node = que.front();
            que.pop();

            if(node == destination) return true;

            for(auto it : mp[node]) {
                int adjNode = it;
                if(vis[adjNode] == 0){
                    que.push(adjNode);
                    vis[adjNode] = 1;
                }
            }
        }
        return false;

    }
};
