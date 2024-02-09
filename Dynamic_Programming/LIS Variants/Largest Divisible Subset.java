/*
    1. sort the array ---> 1, 4, 8, 16 => checking only prev_idx ensures checking for all previous indices(16%8 == 16%4 == 16%1)
    2. ques boils down to lis
    3. here we have to print the lis or lds(longest divisible subsequence)
    4. youtube solution : takeUForward DP series
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int[] dp = new int[n+1];    // dp[i] = count the max length of the lds that ends at i 
        int[] hash = new int[n+1];  // storing the prev_idx

       // initially count_dp all set to 1;
       // initially hash[i] = i for all i;

        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++){
            hash[i] = i;

            for(int prev = 0; prev < i; prev++){

                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){  // only change the formula and rest are same as printing lis
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
        }

      // length of longest sebsequence is   : maxi;
      // the lds ends at index              : lastIndex;
        int lastIndex =  0;
        int maxi = 1;
        for(int i=0;i<n;i++){
            if(dp[i] > dp[lastIndex]){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        // int maxi = dp[lastIndex];
        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIndex]);

        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            res.add(nums[lastIndex]);
        }

        return res; // or reverse of res also accepted as order doesnot matter

    }
}
