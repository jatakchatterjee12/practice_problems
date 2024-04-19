/*
    Company Tags    :   
    GFG  Link       : https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
*/

//************************************************************** C++ ************************************************************//
//Approach : DFS
//TC - O(n*m)
//SC - O(n*m)
class Solution {
  private:
    void dfs(int row,int col, vector<vector<int>> &vis,vector<vector<int>>& grid,
    vector<pair<int,int>> &vec,int n,int m,int row0,int col0){
        
        vis[row][col] = 1;
        vec.push_back({row- row0, col - col0});
        
        int dirs[4][2] = {{-1,0},{1,0},{0,1},{0,-1}};
        
        for(auto dir:dirs){
            
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            
            if(nrow >= 0 && nrow <n && ncol >=0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                
                dfs(nrow,ncol,vis,grid,vec,n,m,row0,col0);
            }
        }
    }
    
  public:
    int countDistinctIslands(vector<vector<int>>& grid) {
        
       int n = grid.size();
       int m = grid[0].size();
       vector<vector<int>> vis(n,vector<int> (m,0));
       set<vector<pair<int,int>>> st;
       
       for(int i = 0; i <n; i++){
           
           for(int j = 0; j <m ;j++){
               
               if(!vis[i][j] && grid[i][j] == 1){
                   
                   vector<pair<int,int>> vec;
                   dfs(i,j,vis,grid,vec,n,m,i,j);
                   st.insert(vec);
               }
           }
       }
       
       return st.size();
    }
};



//****************************************************** JAVA *************************************************************
//Approach : DFS
//TC - O(n*m)
//SC - O(n*m)


class Solution {
    
    void dfs(int[][] grid, int i, int j, int[][] vis, List<String> list, int base_i, int base_j, int m, int n) {
        
        vis[i][j] = 1;
        list.add(toString(i - base_i, j - base_j));
        
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            
            if(i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && grid[i_][j_] == 1 && vis[i_][j_] == 0) {
                dfs(grid, i_, j_, vis, list, base_i, base_j, m, n);
            }
        }
    }
    
    String toString(int i, int j) {
        return (Integer.toString(i) + "-" + Integer.toString(j));
    }

    int countDistinctIslands(int[][] grid) {
       
       int m = grid.length;
       int n = grid[0].length;
       int[][] vis = new int[m][n];
       Set<List<String>> st = new HashSet<>();
       
       for(int i = 0; i < m; i++) {
           for(int j = 0; j  < n; j++) {
               
               if(vis[i][j] == 0 && grid[i][j] == 1) {
                   
                   List<String> list = new ArrayList<>();
                   dfs(grid, i, j, vis, list, i, j, m, n);
                   st.add(list);
               }
           }
       }
       return st.size();
    }
}
