/*
    LeetCode Link : https://leetcode.com/problems/binary-subarrays-with-sum/description/
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }

    private int atMost(int[] nums, int goal) {
        int n = nums.length;
        int i=0;
        int res = 0;

        for(int j=0; j<n; j++) {
            if(goal < 0) return 0;

            goal -= nums[j];
            while(goal < 0) {
                goal += nums[i];
                i++;
            }

            res += j-i+1;
        }
        return res;
    }
}
