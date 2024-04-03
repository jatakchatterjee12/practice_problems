//Recur + Memo
class Solution {
    int row;
    int col;
    int[][] dp;

    int solve(int i, int j) {

        if(i >= row || j >= col) return 0;

        if(i == row-1 && j == col-1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int down = solve(i+1, j);
        int right = solve(i, j+1);

        return dp[i][j] = (down + right);
    }
    public int uniquePaths(int m, int n) {
        row = m;
        col = n;

        dp = new int[row+1][col+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(0, 0);
        
    }
}


//Bottom-up
class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];

        dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {

                if(i == m-1 && j == n-1){
                    dp[i][j] = 1;
                }
                else{

                    int up = 0;
                    int left = 0;

                    if(i+1 < m) up = dp[i+1][j];
                    if(j+1 < n) left = dp[i][j+1];

                    dp[i][j] = (up + left);
                }
            }
        }
        return dp[0][0];
    }
}
