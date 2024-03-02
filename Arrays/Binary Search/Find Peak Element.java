//Approach 1 :
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;

        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int left = 1;
        int right = n-2;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }

            if(nums[mid] > nums[mid-1]) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    
}

// Approach 2 : 
class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while(start<end){
            int mid = start + (end-start)/2;

            if(nums[mid] < nums[mid+1]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }

        return start;
    }
}
