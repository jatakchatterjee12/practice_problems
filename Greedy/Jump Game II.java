/*
    Company Tags  : Adobe, Amazon, Housing.com, Moonfrog Labs, OYO Rooms, Saplabs, Walmart
    Leetcode Link : https://leetcode.com/problems/jump-game-ii/
*/


//Approach 1 : Recursion + Memo
class Solution {
    int solve(int[] nums, int i,  int n, int[] dp) {

        if(i >= n-1) return 0;

        if(dp[i] != -1) return dp[i];

        int result = 10000001;

        for(int idx = 1; idx <= nums[i]; idx++) {

            result = Math.min(result, 1 +  solve(nums, i + idx,  n, dp));
        }

        return dp[i] = result;
    }
    public int jump(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n+1];
        
        Arrays.fill(dp, -1);
        

        return solve(nums, 0, n, dp);
    }
}



// Greedy _ OPTIMAL
//TC - O(n)
class Solution {
    public int jump(int[] nums) {
        
        int n = nums.length;
        int steps = 0;
        int l = 0;
        int r = 0;

        while(r < n-1) {

            int farthest = 0;
            for(int idx = l; idx <= r; idx++) {

                farthest = Math.max(farthest, nums[idx] + idx);
            }

            l = r+1;
            r = farthest;

            steps++;
        }
        return steps;
    }
}
