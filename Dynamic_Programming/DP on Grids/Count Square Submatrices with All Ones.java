/*    
    Company Tags                : Flipkart
    Leetcode Link               : https://leetcode.com/problems/count-square-submatrices-with-all-ones

    
    Logic : 
    same as leetcode : maximal sqaure
    
    for top-down : 
    we go like right, diagonal, and down means dp[i][j] = size of biggest square with A[i][j] as top-left corner
    also means the number of square with A[i][j] as top-left corner
    
    for bottom-up :
    dp[i][j] means the size of biggest square with A[i][j] as bottom-right corner.
    dp[i][j] also means the number of squares with A[i][j] as bottom-right corner.
    
    If A[i][j] == 0, no possible square.
    If A[i][j] == 1,
    we compare the size of square dp[i-1][j-1], dp[i-1][j] and dp[i][j-1].
    min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 is the maximum size of square that we can find.
*/


/**************************************************************** C++ ****************************************************************/
//Approach - 1 (simple Recursion Memoization) - Same as Maximal Square (Leetcode-221)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int m, n;
    int solve(int i, int j, vector<vector<int>>& grid,
              vector<vector<int>>& t) {
        
        if (i >= grid.size() || j >= grid[0].size()) 
            return 0;

        if (grid[i][j] == 0)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        // Right
        int right = solve(i, j + 1, grid, t);
        // Diagonal
        int diagonal = solve(i + 1, j + 1, grid, t);
        // Below
        int below = solve(i + 1, j, grid, t);

        return t[i][j] = 1 + min({right, diagonal, below});
    }

    int countSquares(vector<vector<int>>& grid) {
        int result = 0;
        m = grid.size();
        n = grid[0].size();
        vector<vector<int>> t(m, vector<int>(n, -1));
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                result += solve(i, j, grid, t);
            }
        }
        return result;
    }
};


//Approach - 2 (simple Bottom Up - Same as Maximal Square (Leetcode-221)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        if(matrix.size() == 0)
            return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        
        vector<vector<int>> t(m, vector<int>(n, 0));
        int result = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    t[i][j] = matrix[i][j];
                } else {
                    if(matrix[i][j] == 1) {
                        // Because, if you have any 0, then you cannot expand side of square
                        t[i][j] = 1 + min({t[i-1][j], t[i][j-1], t[i-1][j-1]});
                    }
                }
                result += t[i][j];
            }
        }
        
        return result;
    }
};



/**************************************************************** JAVA ****************************************************************/
//Approach - 1 (simple Recursion Memoization) - Same as Maximal Square (Leetcode-221)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int m, n;

    private int solve(int i, int j, int[][] grid, int[][] t) {
        if (i >= grid.length || j >= grid[0].length) 
            return 0;

        if (grid[i][j] == 0)
            return 0;

        if (t[i][j] != -1)
            return t[i][j];

        // Right
        int right = solve(i, j + 1, grid, t);
        // Diagonal
        int diagonal = solve(i + 1, j + 1, grid, t);
        // Below
        int below = solve(i + 1, j, grid, t);

        return t[i][j] = 1 + Math.min(Math.min(right, diagonal), below);
    }

    public int countSquares(int[][] grid) {
        int result = 0;
        m = grid.length;
        n = grid[0].length;
        int[][] t = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = -1; // Initialize the memoization table with -1
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += solve(i, j, grid, t);
            }
        }
        return result;
    }
}


//Approach - 2 (simple Bottom Up - Same as Maximal Square (Leetcode-221)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }
                result += dp[i][j];
            }
        }

        return result;
    }
}
