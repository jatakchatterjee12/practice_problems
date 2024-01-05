//************************* Approach - 1. RECURSION

class Solution {
    int n;
    private int solve(int curr_idx, int prev_idx, int[] nums){

        if(curr_idx == n)
            return 0;

        int taken = 0;

        if(prev_idx == -1 || nums[curr_idx] > nums[prev_idx]){
            taken = 1 + solve(curr_idx+1, curr_idx, nums);
        }    

        int not_taken = solve(curr_idx+1, prev_idx, nums);

        return Math.max(taken, not_taken);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        return solve(0,-1,nums);
    }
}

//*********************Approach - 2. RECURSION + MEMOIZATION

class Solution {
    int n;
    int[][] dp;
    private int solve(int curr_idx, int prev_idx, int[] nums){

        if(curr_idx == n)
            return 0;

        if(prev_idx != -1 && dp[curr_idx][prev_idx] != -1){
            return dp[curr_idx][prev_idx];
        }    

        int taken = 0;

        if(prev_idx == -1 || nums[curr_idx] > nums[prev_idx]){
            taken = 1 + solve(curr_idx+1, curr_idx, nums);
        }    

        int not_taken = solve(curr_idx+1, prev_idx, nums);

        if(prev_idx != -1){
            dp[curr_idx][prev_idx] = Math.max(taken, not_taken);
        }

        return  Math.max(taken, not_taken);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[2501][2501];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0,-1,nums);
    }
}

//**************************Approach - 3. BOTTOM-UP

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxL = 1;

        // dp[i] => signifies the longest increasing subsequence that ends at index i of arr

        for(int curr_idx = 1; curr_idx < n; curr_idx++){
            for(int prev_idx = 0; prev_idx < curr_idx; prev_idx++){

                if(nums[prev_idx] < nums[curr_idx]){

                    dp[curr_idx] = Math.max(dp[curr_idx], 1 + dp[prev_idx]);
                }
            }
            maxL = Math.max(maxL, dp[curr_idx]);
        }
        return maxL;
    }
}
