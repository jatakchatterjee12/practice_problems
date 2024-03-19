/*
    Intuition : Sort the input array A
                Sliding window prolem actually,
                the key is to find out the valid condition:
                k + sum >= size * max
                which is
                k + sum >= (j - i + 1) * A[j]

                For every new element A[j] to the sliding window,
                Add it to the sum by sum += A[j].
                Check if it'a valid window by
                sum + k < (long)A[j] * (j - i + 1)
                
                If not, removing A[i] from the window by
                sum -= A[i] and i += 1.
*/
class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 1;
        int i = 0;
        long sum = 0;

        for(int j = 0; j < nums.length; j++) {

            sum += nums[j];

            while(sum + k < ((long)nums[j] * (j-i+1))){
                sum -= nums[i];
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
