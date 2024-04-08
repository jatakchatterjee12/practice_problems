class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        
        int n = nums.length;
        int incLength = 1;
        int decLength = 1;
        int ans = 1;

        for(int i = 1; i < n; i++) {

            if(nums[i] > nums[i-1]) {
                incLength++;
                decLength = 1;
            }
            else if(nums[i] < nums[i-1]) {
                decLength++;
                incLength = 1;
            }
            else {
                incLength = 1;
                decLength = 1;
            }

            ans = Math.max(ans, Math.max(incLength, decLength));
        }
        return ans;
    }
}
