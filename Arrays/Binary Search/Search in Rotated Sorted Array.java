class Solution {
    public int search(int[] nums, int target) {
      
      int n = nums.length;
      int left = 0;
      int right = n-1;
      
      while(left <= right){

        int mid= left + (right - left) / 2;
        if(nums[mid] == target)
           return mid;
        
        if(nums[mid] >= nums[left]) { // left half is sorted
          if(target >= nums[left] && target <= nums[mid]) // target lies in the left half
            {
                right = mid - 1;
            }
           else left = mid + 1; // otherwise target lies on the other half
        } 
        else { // right half is sorted
          if(target >= nums[mid] && target <= nums[right]) 
            left = mid + 1;
          else right = mid - 1;
        }
        
      }
      return -1;
    }
}
