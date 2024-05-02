//********************************************* C++ ****************************************//
class Solution {
public:
    int firstPos(vector<int> &nums,int target){

        int first_pos = -1;

        int high = nums.size()-1;
        int low = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                first_pos = mid;
                high = mid - 1;
            }
            else if(nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return first_pos;
    }

    int lastPos(vector<int> &nums,int target){

        int last_pos = -1;

        int high = nums.size()-1;
        int low = 0;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                last_pos = mid;
                low = mid + 1;
            }
            else if(nums[mid] > target) high = mid -1;
            else low = mid + 1;
        }

        return last_pos;
    }

    vector<int> searchRange(vector<int>& nums, int target) {
        int first = firstPos(nums,target);

        if(first == -1){
            return {-1,-1};
        }

        return {first, lastPos(nums,target)};
    }
};


//******************************************** JAVA *****************************************//
class Solution {

    int firstOccurance(int[] nums, int target){

        int low= 0;
        int high = nums.length -1;
        int first = -1;

        while(low <= high){
            int mid = (low+high)/2;

            if(nums[mid] == target){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            } 
            else {
                high = mid -1;
            }
        }

        return first;
    }

     int lastOccurance(int[] nums, int target){

         int low = 0;
         int high = nums.length -1;
         int last = -1;

         while(low <= high){

             int mid = (low+high)/2;

             if(nums[mid] == target){
                 last = mid;
                 low = mid +1;
             }
             else if(nums[mid] < target){
                low = mid + 1;
            } 
            else {
                high = mid -1;
            }
         }

         return last;
     }
    public int[] searchRange(int[] nums, int target) {


        int first = firstOccurance(nums,target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        return new int[] {first,lastOccurance(nums,target)};
        
    }
}
