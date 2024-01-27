// Approach 1. Recur + Memo

class Solution 
{ 
    static int[][] dp;
    static int solve(int wt[], int[] val, int i, int W){
        if(i < 0 || W == 0){
            return 0;
        }
        if(dp[i][W] != -1)return dp[i][W];
        
        int not_taken = solve(wt,val,i-1,W);
        int taken = 0;
        if(wt[i] <= W){
            taken = val[i] + solve(wt,val,i-1, W - wt[i]);
        }
        return dp[i][W] = Math.max(taken, not_taken);
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        dp = new int[n+1][W+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(wt, val,n-1, W);
        
    } 
}
