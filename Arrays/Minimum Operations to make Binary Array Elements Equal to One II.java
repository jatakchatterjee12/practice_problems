class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int flips = 0;
        int flipCntFori =0;

        for(int i = 0; i < n; i++){

            if(flipCntFori%2 == nums[i]){
                //flip needed
                flipCntFori++;
                flips++;

            }
        }
        return flips;
    }
}
