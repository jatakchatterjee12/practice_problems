/*
     Leetcode link       :     https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
*/

/*
trying for each cell and taking a cell as a starting point of the longest increasing path.
dp array cached for each cell computation that we already done, so we simply return the max path we get from the recursion dfs + 1 for the current cell inclusion.
TC : O(m*n)
SC : (O(m*n) + Call stack ~O(m*n)

*/


class Solution {
    private final int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    private int[][] dp = new int[201][201];

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int maxLen = 1;

        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){

                maxLen = Math.max(maxLen, solve(matrix, i, j, -1, m, n));
            }
        }
        return maxLen;
    }

    private int solve(int[][] matrix, int i, int j, int prev, int m, int n){

        if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= prev){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }


        int maxi = 0;
        for(int[] dir : dirs){
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            maxi = Math.max(maxi, solve(matrix, i_, j_, matrix[i][j], m, n));
        }

        return dp[i][j] = (maxi + 1);

    }
}
