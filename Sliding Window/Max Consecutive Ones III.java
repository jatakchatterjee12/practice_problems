// the qstn boils down to ---> longest subarray with atmost k zeros


// TC - O(2n) -> while loops 2 times
class Solution {
    public int longestOnes(int[] nums, int k) {

        int result = 0;
        int n = nums.length;

        int i = 0, j = 0;
        int countZero = 0;

        while(j < n){

            if(nums[j] == 0) countZero++;

            while(countZero > k){
                if(nums[i] == 0){
                    countZero--;
                }
                i++;
            }

            result = Math.max(result, j-i+1);
            j++;

        }
        return result;
        
    }
}


// TC - O(N) -> change the inner while loops with if statement
class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int n = nums.length;

        int l = 0;
        int r = 0;
        int maxLen = 0;

        int zeros = 0;

        while(r < n) {

            if(nums[r] == 0){
                zeros++;
            }

            if(zeros > k){
                if(nums[l] == 0) zeros--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }
        return maxLen;
    }
}
