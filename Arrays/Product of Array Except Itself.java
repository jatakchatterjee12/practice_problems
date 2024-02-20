class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        int temp = 1;

        //  ith value = (prod of 0 to i-1) * (prod of i+1 to n)

        //1. traverse left to right 
        for(int i  = 0; i < n; i++){

            result[i] = temp;
            temp = temp * nums[i];
        }

        temp = 1;

        //2. traverse from right to left and generate the final output
        for(int i = n-1; i >= 0; i--){

            result[i] = result[i] * temp;
            temp = temp * nums[i];
        }

        return result;
        
    }
}
