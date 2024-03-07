/*
    LeetCode Link  : https://leetcode.com/problems/count-number-of-nice-subarrays/
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        int res = 0;

        for(int j=0; j<n; j++) {

            k -= nums[j] % 2; // if the nums[j] is odd then  k will be decreased by 1
          
            while(k < 0) {
                k += nums[i] % 2;
                i++;
            }
            res += j-i+1;

        }
        return res;
    }
}
