/*
    Leetcode link    :    https://leetcode.com/problems/maximum-total-reward-using-operations-i/

*/


class Solution {
    
    int[][] dp = new int[2001][4001];
    int solve(int[] arr, int i, int x) {
        
        if(i >= arr.length){
            return 0;
        }
        
        if(dp[i][x] != -1) return dp[i][x];
        
        int take = 0;
        
        if(x < arr[i]){
            take = arr[i] + solve(arr,   i+1, x + arr[i]);
        }
        
        int not_take = solve(arr, i+1, x);
        return dp[i][x] = Math.max(take, not_take);
    }
    public int maxTotalReward(int[] arr) {
        
        Arrays.sort(arr);
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(arr, 0, 0);
        
    }
}
