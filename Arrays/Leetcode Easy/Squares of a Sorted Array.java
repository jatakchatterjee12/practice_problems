// Approach - the absolute value of first element or the last element will be the largest as it is sorted.
// but we cannot detect the smallest element as it can be anything in the array. so we select the largest one first and then reverse 
// the result array

// -4, -1, 0, 3, 10  ---> 0, 1, 9, 16, 100   Here 10 is the larger bw 10 & 4 (Abs value)
// -9, -3, 0, 3, 7   ---> 0, 9, 9, 49, 81    here 9 is larger bw 9 & 7 and minimum(0) can be anywhere in the array

class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n-1;
        int i=0;

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[i++] = (nums[left]*nums[left]);
                left++;
            }
            else {
                res[i++] = (nums[right]*nums[right]);
                right--;
            }
        }
        for(int j = 0; j < n/2; j++){
            int t = res[n-j-1];
            res[n-j-1] = res[j];
            res[j] = t;
        }
        return res;
    }
}

// Directly push the largest element at the end of the result array
class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n-1;
        int i = n-1;

        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                res[i--] = (nums[left]*nums[left]);
                left++;
            }
            else {
                res[i--] = (nums[right]*nums[right]);
                right--;
            }
        }
        
        return res;
    }
}
