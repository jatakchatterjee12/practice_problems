/*      
    Company Tags                : Flipkart
    Leetcode Link               : https://leetcode.com/problems/maximal-square/
*/


/********************************************************************** C++ **********************************************************************/
//Approach - Using Simple Bottom Up
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0)
            return 0;
        int r = matrix.size();
        int c = matrix[0].size();
        
        vector<vector<int>> t(r, vector<int>(c, 0));
        int side = matrix[0][0]=='0'?0:1;
        for(int i = 0; i<r; i++) {
            for(int j = 0; j<c; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = matrix[i][j] =='0' ? 0 : 1;
                } else {
                    if(matrix[i][j] == '1') {
                        //Because, if you have any 0, then you cannot expand side of square
                        t[i][j] = 1 + min({t[i-1][j], t[i][j-1], t[i-1][j-1]});
                    }
                }
                side = max(side, t[i][j]);
            }
        }
        
        return side*side;
    }
};



/********************************************************************** JAVA **********************************************************************/
//Approach - Using Simple Bottom Up
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        int side = matrix[0][0] == '0' ? 0 : 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
                side = Math.max(side, dp[i][j]);
            }
        }
        
        return side * side;
    }
}


// Approach : Recursion + Memo
class Solution {
    int m;
    int n;

    int solve(int i, int j, char[][] matrix, int[][] dp){
        if(i >= m || j >= n){
            return 0;
        }

        if(matrix[i][j] == '0'){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i, j+1, matrix, dp);
        int diag = solve(i+1, j+1, matrix, dp);
        int below = solve(i+1, j, matrix, dp);

        return dp[i][j] =  1 + Math.min(right, Math.min(diag, below));
    }
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int result = 0;

        for(int i = 0; i  < m; i++) {
            for(int j = 0; j < n; j++){

                if(matrix[i][j] == '1'){

                    result = Math.max(result, solve(i, j, matrix, dp));
                }
            }

        }

        return (result*result);
    }
}
