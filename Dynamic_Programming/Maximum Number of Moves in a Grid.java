class Solution {
    int m, n;

    int[][] dp;

    int[] dirs = {-1, 0, 1};

    int solve(int i, int j, int[][] grid) {

        int curr = grid[i][j];

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int moves = 0;

        for(int dir : dirs){
            int new_i = i + dir;
            int new_j = j + 1;

            if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] > curr){

                moves = Math.max(moves, 1 + solve(new_i, new_j, grid));
            }
        }

        return dp[i][j] = moves;
    }
    public int maxMoves(int[][] grid) {
        
        m = grid.length;
        n = grid[0].length;

        dp = new int[m+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }

        int result = 0;

        for(int row = 0; row < m; row++){

            result = Math.max(result, solve(row, 0, grid));
        }

        return result;
    }
}
