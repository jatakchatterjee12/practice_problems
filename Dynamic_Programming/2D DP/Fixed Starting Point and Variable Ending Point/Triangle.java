//Recur + Memo
class Solution {
    int solve(int i, int j, int n, List<List<Integer>> triangle, int[][] dp){

        if( i == n-1) return triangle.get(n-1).get(j);

        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle.get(i).get(j) + solve(i+1, j, n, triangle, dp);
        int diag = triangle.get(i).get(j) + solve(i+1, j+1, n, triangle, dp);

        return dp[i][j] = Math.min(down, diag);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0,0, n, triangle, dp);
    }
}


//Bottom-Up
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        
        int[][] dp = new int[n+1][m+1];

        for(int j = 0; j < m; j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--) {

            for(int j = i; j >= 0; j--) {

                
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diag);
            }
        }

        return dp[0][0];
    }
}




//Space-Optimized 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[] front = new int[m];
        for(int j = 0; j < m; j++) {
            front[j] = triangle.get(n-1).get(j);
        }

        for(int i = n-2; i >= 0; i--) {

            int[] cur = new int[n];

            for(int j = i; j >= 0; j--) {

                int up = triangle.get(i).get(j) + front[j];
                int diag = triangle.get(i).get(j) + front[j+1];

                cur[j] = Math.min(up, diag); 
            }

            front = cur;
        }
        return front[0];

    }
}
