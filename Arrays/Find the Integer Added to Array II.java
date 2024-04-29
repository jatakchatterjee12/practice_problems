/*
    Company Tag           :  will update soon
    LeetCode Link         :  https://leetcode.com/problems/find-the-integer-added-to-array-ii/
*/

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
