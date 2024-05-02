//******************************************* C++ *********************************//
class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int n = nums.size();

        int i = 0;
        int j = n-1;

        while(i <= j) {
            int mid = i + (j-i)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) j = mid-1;
            else i = mid+1;
        }
        return -1;
    }
};



//************************************** JAVA ****************************************//
class Solution {
    public int search(int[] nums, int target) {

        int start = 0;

        int end  = nums.length -1;

        while(start<= end){

            int mid = start + (end-start/2);

            if(nums[mid] == target) return mid;

            if(nums[mid]> target) end = mid - 1;
            else
                start = mid + 1; 
        }

        return -1;

        
    }
}
