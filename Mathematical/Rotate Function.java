/*
   Leetcode link  -  https://leetcode.com/problems/rotate-function/description/
*/
// TC - O(n)
// SC - O(1)
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int F = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            F   += (i * nums[i]);
        }

        int maxi = F;
        for(int i = n-1; i>0; i--){
            F = F + sum - (n * nums[i]);
            maxi = Math.max(maxi, F);
        }
        return maxi;
    }
}
