// Recur + Memo

class Solution {
    int mini = Integer.MAX_VALUE;
    int[][] dp;
    int solve(int i, int j, int[][] matrix,int n){
        
        if(j < 0 || j >= n) return (int)1e9;
        if(i == 0) return matrix[0][j];

        if(dp[i][j] != -1) return dp[i][j];

        int u = matrix[i][j] + solve(i-1,j,matrix,n);
        int lu = matrix[i][j] + solve(i-1,j-1,matrix,n);
        int ru = matrix[i][j] + solve(i-1, j+1,matrix,n);

        return dp[i][j] = Math.min(u, Math.min(lu, ru));
    } 
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int result = Integer.MAX_VALUE;

        dp = new int[n+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        for(int j=0;j<n;j++){
            result = Math.min(result, solve(n-1, j, matrix, n));
        }
        return result;
    }
}

// Bottom-Up
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[n+1][n+1];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){

                dp[i][j] = matrix[i][j] + (Math.min(dp[i-1][j] , 
                           Math.min(dp[i-1][Math.max(0,j-1)],
                           dp[i-1][Math.min(n-1,j+1)]))); // takeing care of outof index cases
            }
        }

        for(int j=0;j<n;j++){
            result = Math.min(result, dp[n-1][j]);
        }
        return result;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[n+1][n+1];
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int lu=(int)1e9;
                int ru=(int)1e9;

                int u = matrix[i][j] + dp[i-1][j];
                if(j>0)  lu = matrix[i][j] + dp[i-1][j-1];
                if(j<n-1) ru = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min(u, Math.min(lu,ru));
                            // takeing care of outof index cases
            }
        }

        for(int j=0;j<n;j++){
            result = Math.min(result, dp[n-1][j]);
        }
        return result;
    }
}

// Space Optimized Solution
// TC - O(m*n)
//sc- O(m+n)
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[] prev = new int[n];
        
        // Initialize the first row of prev array
        for (int col = 0; col < n; col++) {
            prev[col] = A[0][col];
        }
        
        // Iterate over the remaining rows
        for (int row = 1; row < n; row++) {
            int[] curr = new int[n];
            for (int col = 0; col < n; col++) {
                curr[col] = A[row][col] + Math.min(Math.min(prev[Math.max(0, col - 1)], prev[col]), prev[Math.min(n - 1, col + 1)]);
            }
            prev = curr;
        }
        
        // Return the minimum element in the last row of the dp array
        int minPathSum = Integer.MAX_VALUE;
        for (int value : prev) {
            minPathSum = Math.min(minPathSum, value);
        }
        
        return minPathSum;
    }
}
