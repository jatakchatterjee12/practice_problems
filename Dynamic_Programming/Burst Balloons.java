/*
    leetcode link     :   https://leetcode.com/problems/burst-balloons/description/
*/

//******************************************** JAVA ******************************************************************
//Recur + Memo
class Solution {
    private int solve(List<Integer> list, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++){
            int cost = list.get(i-1) * list.get(ind) * list.get(j+1)+
                       solve(list, i, ind-1, dp) + solve(list, ind+1, j, dp);

            maxi = Math.max(maxi, cost);           
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        list.add(1);
        list.add(0,1);

        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(list, 1, n, dp);
    }
}

// Bottom up
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        list.add(1);
        list.add(0,1);

        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp){
            Arrays.fill(row, 0);
        }

        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){

                if(i > j) continue;

                int maxi = Integer.MIN_VALUE;

                for(int ind = i; ind <= j; ind++){
                    int cost = list.get(i-1) * list.get(ind) * list.get(j+1)+
                            dp[i][ind-1] + dp[ind+1][j];

                    maxi = Math.max(maxi, cost);           
                }
                dp[i][j] = maxi;

            }
        }

        return dp[1][n];
    }
}
