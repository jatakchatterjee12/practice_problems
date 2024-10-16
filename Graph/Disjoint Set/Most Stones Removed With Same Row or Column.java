/*   
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    
  
*/


/******************************************************** C++ ********************************************************/
//T.C : O(n^2 * α(n))
//S.C : O(n)
class Solution {
public:
    vector<int> parent;
    vector<int> rank;
    int n;
    
    int find(int i) {
        if(parent[i] != i)
            parent[i] = find(parent[i]);
        
        return parent[i];
    }
    
    void Union(int i, int j) {
        int root_i = find(i);
        int root_j = find(j);
        
        if(root_i != root_j) {
            if(rank[root_i] > rank[root_j]) {
                parent[root_j] = root_i;
            } else  if(rank[root_i] < rank[root_j]) {
                parent[root_i] = root_j;
            } else {
                parent[root_j] = root_i;
            }
        }
    }
    
    int removeStones(vector<vector<int>>& stones) {
        n = stones.size();
        parent.resize(n);
        rank.resize(n);
        
        for(int i = 0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    Union(i, j);
            }
        }
        
        int groups = 0;
        for(int i = 0; i<n; i++) {
            if(parent[i] == i) groups++;
        }
        
        return n-groups;
    }
};


/******************************************************** JAVA ********************************************************/
//T.C : O(n^2 * α(n))
//S.C : O(n)
class Solution {
    private int[] parent;
    private int[] rank;
    private int n;

    // Find function with path compression
    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]); // Path compression
        }
        return parent[i];
    }

    // Union function with union by rank
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        
        if (rootI != rootJ) {
            if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }

    public int removeStones(int[][] stones) {
        n = stones.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize parent and rank arrays
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Union stones that are in the same row or column
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }

        // Count the number of disjoint sets (connected components)
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                groups++;
            }
        }

        // The number of stones that can be removed is total stones - number of groups
        return n - groups;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    int[] parent;
    int[] rank;
    int n;

    int find(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    void union(int x, int y){
        int x_parent = find(x);
        int y_parent = find(y);

        if(x_parent == y_parent){
            return;
        }

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int i = 0; i <  n; i++){
            for(int j = i+1; j < n; j++) {

                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    union(i, j);
                }
            }
        }

        int groups = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) {
                groups++;
            }
        }

        return n - groups;
    }
}
