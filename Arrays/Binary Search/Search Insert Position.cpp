//************************************** C++ **************************************//
//Lower bound Concept
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {

        // lower bound code

        int n = nums.size();
        int l = 0;
        int h = n-1;
        int ans = n;

        while(l<=h){

            int mid = (l+h)/2;

            if(nums[mid] >= target){
                ans = mid;
                h = mid-1;
            }
            else
                l = mid + 1;
        }

        return ans;
        
    }
};


//Advancement of upper Approach
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        
        int low = 0;
        int high = nums.size() - 1;

        while(low <= high) {

            int mid = low + (high - low)/2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] > target) high = mid-1;
            else low = mid + 1;;
        }
        return low;
    }
};


//********************************** JAVA  **************************************//
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
      
        while(l<=h){
            int mid= l + (h-l)/2;
            if(nums[mid]==target) return mid;
            if(target<nums[mid]) h=mid-1;
            else
                l=mid+1;

        }
        return l;
        
    }
}
