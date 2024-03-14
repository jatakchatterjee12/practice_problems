class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int n = nums.length;

        int maxOnes = 0;
        int count = 0;

        for(int i=0; i<n; i++) {

            count = nums[i] == 1 ? count+1 : 0;

            maxOnes = Math.max(maxOnes, count);
        }
        return maxOnes;
    }
}
