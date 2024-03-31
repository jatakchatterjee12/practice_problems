/*
    Company Tags                : Microsoft
    Leetcode Link               : https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
*/

//Approach-1 (Brute Force)
//Find all subarrays and check if min is minK and max is maxK
//Code will be provided soon for brute force

//Approach-2 (Optimal O(n)) - Sliding Window

//******************************************************************* C++ ***********************************************************//
class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        long long ans = 0;
        
        int minPosition = -1;
        int maxPosition = -1;
        int culpritIdx   = -1;
        
        for(int i = 0; i < nums.size(); i++) {
            
            if(nums[i] < minK || nums[i] > maxK)
                culpritIdx = i;
            
            if(nums[i] == minK)
                minPosition = i;
            if(nums[i] == maxK)
                maxPosition = i;
            
            int count = min(maxPosition, minPosition) - culpritIdx;
            
            ans += (count <= 0) ? 0 : count;
            
        }
        
        return ans;
    }
};


//***************************************************************** JAVA ******************************************************************//
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        int minKind = -1;
        int maxKind = -1;
        int culpritind = -1;
        long ans = 0;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] < minK || nums[i] > maxK){
                culpritind = i;
            }

            if(nums[i] == minK) minKind = i;
            if(nums[i] == maxK) maxKind = i;

            long temp = Math.min(minKind,maxKind) - culpritind;

            ans += temp <= 0 ? 0 : temp;
        }

        return ans;
        
    }
}
