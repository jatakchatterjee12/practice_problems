/*
    codestorywithMIK YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=_cBWWebTVpI&list=PLpIkg8OmuX-K6A0sEPFxOSJh4_AjCGAFf&index=4
    Company Tags                : Amazon, Facebook, Google
    Question on GfG             : Find triplets with zero sum (https://practice.geeksforgeeks.org/problems/find-triplets-with-zero-sum/1)
    Leetcode Qn Link            : https://leetcode.com/problems/3sum/
*/
// ****************************************** CPP ***********************************************************************

class Solution {
public:
    void twoSum(vector<int>& nums, int k, vector<vector<int>>& result, int target) {
        //Two pointer technique (Sorted array) Things you must not forget in interviews
        
        int i = k, j = nums.size()-1;
        while(i < j) {
            if(nums[i]+nums[j] > target)
                j--;
            else if(nums[i] + nums[j] < target)
                i++;
            else {
                result.push_back({-target, nums[i], nums[j]});
                while(i < j && nums[i] == nums[i+1]) i++;
                while(i < j && nums[j] == nums[j-1]) j--;
                i++; //Things you must not forget in interviews
                j--; //Things you must not forget in interviews
            }
        }
    }
    vector<vector<int>> threeSum(vector<int>& nums) {
        if(nums.size() < 3) //Things you must not forget in interviews
            return {};
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        for(int i = 0; i<nums.size()-2; i++) {  //(i<nums.size()-2)Things you must not forget in interviews
            if(i!= 0 && nums[i] == nums[i-1]) { //Things you must not forget in interviews
                continue;
            }
            twoSum(nums, i+1, result, -nums[i]);
        }
        return result;
    }
};

// ********************************************** JAVA **************************************************************
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i < n-2; i++){

            if((i > 0 && nums[i] == nums[i-1])){
                continue;
            }

            int left = i+1;
            int right = n-1;
            int sum = 0 - nums[i];

            while(left < right){

                if(nums[left] + nums[right] == sum){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while( left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    
                    while( left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] < sum){
                    left++;
                }
                else right--;
            }
        }

        return res;
    }
 
}

 //TECHNIQUE 2
  class Solution {
    List<List<Integer>> res = new ArrayList<>();
    void twoSum(int[] nums, int target, int left, int right){

        while(left < right){

            if(nums[left] + nums[right] > target) right--;
            else if(nums[left] + nums[right] < target) left++;

            else{
                // first we will remove the duplicates
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;

                res.add(Arrays.asList(-target, nums[left], nums[right]));

                left++;
                right--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        if(n<3) return new ArrayList<>();

        //sort
        Arrays.sort(nums);

        //fixing one element
        for(int i=0; i<n-2; i++){

            if(i>0 && nums[i] == nums[i-1]) continue;

            int n1 = nums[i];
            int target = 0 - n1;

            twoSum(nums,target,i+1,n-1);// it will find the n2 and n3

        }
        return res;
    }
}
