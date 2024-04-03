//Recur + Memo
class Solution {
    int solve(int i, int j, int[][] grid, int[][] dp){


        if(i == 0 && j == 0) return grid[0][0];

        if(i < 0 || j < 0) return 100000; // a bigger value

        if(dp[i][j] != -1) return dp[i][j];

        int up   = grid[i][j] + solve(i-1, j, grid, dp);
        int left = grid[i][j] + solve(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
  
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(m-1, n-1, grid, dp);
    }
}


//Tabulation
class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else{

                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i > 0) up += dp[i-1][j];
                    else      up += 1000000;

                    if(j > 0) left += dp[i][j-1];
                    else      left += 1000000; 

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
