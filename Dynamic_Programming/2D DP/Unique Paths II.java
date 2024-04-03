//Recur + Memo
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[101][101];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(n-1,m-1,grid,dp);
    }
  
    int solve(int i,int j, int[][] grid, int[][] dp){

        if(i < 0 || j < 0 || grid[i][j] == 1) return 0;

        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int up = solve(i-1, j, grid, dp);
        int left = solve(i, j-1, grid, dp);

        return dp[i][j] = up + left;
    }
}


//Bottom-up
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[101][101];
       

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if( grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if(i ==0 && j ==0) {
                    dp[i][j] = 1;
                    continue;
                }

                 int up = 0;
                 int left = 0;
                
                   
                if(i> 0)   up = dp[i-1][j];
                if(j > 0)  left = dp[i][j-1];

                dp[i][j] = up + left;
                
            }
        }
        return dp[n-1][m-1];
    }
    
}
