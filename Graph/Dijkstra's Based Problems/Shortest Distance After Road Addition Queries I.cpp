/*

    Leetcode  link   :    https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/

*/

//****************************************** C++ **************************************************//
class Solution {
public:
    vector<int> shortestDistanceAfterQueries(int n, vector<vector<int>>& queries) {
        unordered_map<int, vector<int>> adj;
        
        for(int i = 0; i < n-1; i++){
            adj[i].push_back(i+1);
        }
        
        vector<int> dist(n, 1e8);
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int>> > pq;
        
        // pq.push({0,0});
        // dist[0] = 0 ;
        
        vector<int> result;
        
        for(auto &q : queries){
            
            pq.push({0,0});
            dist[0] = 0;
            
            int u = q[0];
            int v = q[1];
            adj[u].push_back(v);
            
            while(!pq.empty()) {
                auto [wt, node] = pq.top();
                pq.pop();
                
                for(int nbr : adj[node]){
                    if(wt+1 > dist[nbr]) continue;
                    else if(wt + 1 <= dist[nbr]){
                        dist[nbr] = wt + 1;
                        pq.push({wt+1, nbr});
                    }
                }
            }
            
            result.push_back(dist[n-1]);
            
        }
        return result;
    }
};
