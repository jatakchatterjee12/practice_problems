 /* Qn. Given an integer array nums, rotate the array to the right by k steps, where k is non-negative. */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1); // reverse whole array
        reverse(nums, 0, k-1); // reverse first k elements
        reverse(nums, k, n-1); // reverse last n-k elements
    }

    void reverse(int[] nums, int start, int end){
        while(start < end){

            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}

/* Qn. Given an integer array nums, rotate the array to the left by k steps, where k is non-negative. */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1); // reverse whole array
        reverse(nums, n-k, n-1); // reverse last k elements
        reverse(nums, 0, n-k-1); // reverse first n-k elements
    }

    void reverse(int[] nums, int start, int end){
        while(start < end){

            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
