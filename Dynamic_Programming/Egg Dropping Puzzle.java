/*
      Company   : VMWare, Amazon, Microsoft, Samsung, D-E-Shaw, Hike, MakeMyTrip, Oracle, Goldman Sachs, MAQ Software, Google, Myntra, nearbuy, Opera, Philips, Service Now, Unisys
      GFG Link  : https://www.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
*/



class Solution 
{
    static int[][] dp;
    static int solve(int n, int k) {
        if(k ==0 || k == 1 || n == 1){
            return k;
        }
        
        if(dp[n][k] != -1) return dp[n][k];
        
        int ans = Integer.MAX_VALUE;
        
        for(int f = 1; f <= k; f++) {
            
            int break_ = solve(n-1, f-1);
            int not_break = solve(n, k-f);
            
            int tmp = 1 + Math.max(break_, not_break); // considering the worst case
            
            ans  = Math.min(ans, tmp);
            
        }
        return dp[n][k] = ans;
    }
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    dp = new int[n+1][k+1];
	    
	    for(int[] row : dp) {
	        Arrays.fill(row, -1);
	    }
	    return solve(n,k);
	}
}
