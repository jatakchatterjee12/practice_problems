/*
    Company Tag           :  will update soon
    LeetCode Link         :  https://leetcode.com/problems/find-the-integer-added-to-array-ii/
*/


// O(n^2) 
class Solution {
    boolean check(int[] nums1, int[] nums2, int val){
        int count = 0;
        int j = 0;

        for(int i = 0; i < nums1.length && j < nums2.length; i++) {

            if(nums1[i] + val != nums2[j]){
                count++;
            }
            else{
                j++; // if nums1[i] + val == nums2[j] then only increase the j pointer
            }
        }

        if(count > 2) return false; // As maximum 2 element can be removed
        return true;
    }
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int minEl = Integer.MAX_VALUE;
        for(int i = 0; i < nums1.length; i++){
            int val = nums2[0] - nums1[i];
            if(check(nums1, nums2, val)){
                minEl = Math.min(minEl, val);
            }
        }
        return minEl;
    }
}



// Can be more Optimised Tc- O(n*logn)
/*
       1.We only have the possibility of choosing nums1[0], [1], or [2] because we can exclude any two of them.
        
       2.Why can't we exclude more? Because if we were to choose nums1[3], or elements greater then the condition of obtaining identical vectors will be satisfied but since nums1[i + 1] > nums[i] hence the answer wouldn't be the minimum possible number as required in the problem.
       
       3.Hence we wouldn't be able to satisfy the mathematical requirements of nums2.

*/
//Small change in th for loop
for(int i = 0; i < 3; i++){
   int val = nums2[0] - nums1[i];
   if(check(nums1, nums2, val)){
       minEle = min(minEle, val);
   }    
}
