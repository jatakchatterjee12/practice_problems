/*
      COMPANY TAGS                : GOOGLE
      Leetcode Link               : https://leetcode.com/problems/number-of-closed-islands/
*/


//******************************************************** C++ *****************************************************************//
//Approach-1 (Using DFS)
class Solution {
public:
    
    int m, n;
    bool dfs(vector<vector<int>> &grid, int r, int c) {
        
        if(r < 0 || r >= m || c < 0 || c >= n)
            return false; //Not closed
        
        if(grid[r][c] == 1)
            return true; //closed here (water or marked before , so returned as true)
        
        grid[r][c] = 1; // mark visited
        
        bool left  = dfs(grid, r, c-1);
        bool right = dfs(grid, r, c+1);
        bool up    = dfs(grid, r-1, c);
        bool down  = dfs(grid, r+1, c);
        
        return left && right && up && down;
        
    }
    
    int closedIsland(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        
        int count = 0;
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                
                if(grid[i][j] == 0) {
                    count += dfs(grid, i, j);
                }
                
            }
        }
        
        return count;
    }
};


//Approach-2 (Using BFS)
//soon I will share BFS too



//*************************************************************** JAVA ******************************************************//
//Approach 1: DFS
class Solution {
    boolean dfs(int[][] grid, int r, int c, int m, int n) {

        if(r < 0 || c < 0 || r >= m || c >= n){
            return false;
        }

        if(grid[r][c] == 1){ //water se iss side closed hai or marked before so return true
            return true;
        }

        grid[r][c] = 1; //mark visited

        boolean left_side = dfs(grid, r, c-1, m, n);
        boolean right_side = dfs(grid, r, c+1, m, n);
        boolean up_side = dfs(grid, r-1, c, m, n);
        boolean down_side = dfs(grid, r+1, c, m, n);

        return (left_side && right_side && up_side && down_side);
    }

  
    public int closedIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 0) { // land
                    if(dfs(grid, i, j, m, n) == true){
                        count++;
                    }
                }
                
            }
        }
        return count;
    }
}
