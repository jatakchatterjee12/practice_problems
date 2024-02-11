// Approach 1 : Recur + Memo
class Solution {
    int[][][] dp;
    int solve(int[][] grid, int i, int j1, int j2, int n, int m){
        // 1st base case : out of boundary check
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)  return (int)-1e8;

        // 2nd base case : destination reached
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1]; // robot1 and robot2 at same cell
            }
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2]  != -1) return dp[i][j1][j2];

        int maxi = 0;

        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){

                if(j1 == j2){
                    maxi = Math.max(maxi,  grid[i][j1] + solve(grid, i+1, j1+dj1, j2+dj2, n, m));
                }
                else {
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] +  solve(grid, i+1, j1+dj1, j2+dj2, n, m));
                }
            }
        }

        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][m];
        for(int[][] i : dp){
            for(int[] j : i){
                Arrays.fill(j, -1);
            }
        }

        return solve(grid, 0, 0, m-1, n, m);
    }
}

// Approach 2: Tabulation
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // base case : reached destination --> i == n-1 for every possible j1 and j2
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
 
                if(j1 == j2)  dp[n-1][j1][j2] = grid[n-1][j1];
                else          dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i=n-2; i >= 0; i--){

            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){

                    int maxi = 0; // -1e8
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){

                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else         value = grid[i][j1] + grid[i][j2];

                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            }
                            else value += (int)-1e8;

                            maxi = Math.max(maxi, value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][m-1];
    }
}

//Approach 3 : Space Optimized Tabulation
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] front = new int[m][m];
        int[][] curr  = new int[m][m];

        // base case : reached destination --> i == n-1 for every possible j1 and j2
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
 
                if(j1 == j2)  front[j1][j2] = grid[n-1][j1];
                else          front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for(int i=n-2; i >= 0; i--){

            for(int j1 = 0; j1 < m; j1++){
                for(int j2 = 0; j2 < m; j2++){

                    int maxi = 0; // -1e8
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){

                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else         value = grid[i][j1] + grid[i][j2];

                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m){
                                value += front[j1+dj1][j2+dj2];
                            }
                            else value += (int)-1e8;

                            maxi = Math.max(maxi, value);
                        }
                    }
                    curr[j1][j2] = maxi;
                }
            }

            for(int k =0; k<m; k++) front[k] =  curr[k].clone();//(int[])(curr[k].clone());
        }

        return front[0][m-1];
    }
}
