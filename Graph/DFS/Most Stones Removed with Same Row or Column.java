/*    
    Company Tags                : Google
    Leetcode Link               : https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    
   
*/


/************************************************ C++ ************************************************/
//T.C : O(n^2)
//S.C : O(n)
class Solution {
public:
    int n ;
    void dfs(vector<vector<int>>& stones, int index, vector<bool>& visited) {
        visited[index] = true;
        
        for(int i = 0; i<n; i++) {
            if(!visited[i] &&
               ((stones[i][0] == stones[index][0]) || (stones[i][1] == stones[index][1]))) {
                dfs(stones, i, visited);
            }
        }
    }
    int removeStones(vector<vector<int>>& stones) {
        n = stones.size();
        vector<bool> visited(n, false);
        
        int count = 0;
        for(int i = 0; i<n; i++) {
            if(visited[i])
                continue;
            dfs(stones, i, visited);
            count++;
        }
        
        return n - count;
    }
};



/************************************************ JAVA ************************************************/
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    private int n;
    
    private void dfs(int[][] stones, int index, boolean[] visited) {
        visited[index] = true;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i] &&
                (stones[i][0] == stones[index][0] || stones[i][1] == stones[index][1])) {
                dfs(stones, i, visited);
            }
        }
    }
    
    public int removeStones(int[][] stones) {
        n = stones.length;
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(stones, i, visited);
            count++;
        }
        
        return n - count;
    }
}
