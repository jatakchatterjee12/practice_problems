//Simpler verion of Leetcode 995 

class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;

        int currFlip = 0;
        int[] isFlipped = new int[n]; // 1 = true, 0 = false

        for(int i = 0; i < n; i++){

            if(i-3 >= 0 && isFlipped[i-3] == 1){
                currFlip -= 1;
            }

            if(currFlip%2 == nums[i]){
                // flip needed
                if(i+3 > n) return -1;

                currFlip++;
                count++;
                isFlipped[i] = 1;
            }
        }
        return count;
    }
}
