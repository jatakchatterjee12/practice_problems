/*
    GFG Link   : https://www.geeksforgeeks.org/problems/maximum-sum-problem2211/1
*/

class Solution
{
    int dp[];
    int solve(int n) {
        if(n == 0 || n == 1) return dp[n] = n;
        
        if(dp[n] != -1)return dp[n];
        
        return dp[n] = Math.max(n, solve(n/2) + solve(n/3) + solve(n/4));
    }
    public int maxSum(int n) 
    { 
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n);
    } 
}
