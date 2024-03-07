/*
    LeetCode Link : https://leetcode.com/problems/subarrays-with-k-different-integers/
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>(); // count
        int i = 0;
        int res = 0;

        for(int j=0; j<n; j++) {

            //if i see this item first time, k--
            if(mp.getOrDefault(nums[j],0) == 0) k--;

            mp.put(nums[j], mp.getOrDefault(nums[j],0) + 1); // mp[item]++

            while(k < 0) { // shringking i
                //k<0 ---> i have seen a new item and that exceeds the count (> k)

                mp.put(nums[i], mp.getOrDefault(nums[i],0) - 1);
                if(mp.get(nums[i]) == 0) k++;
                i++;
            }

            res += j - i + 1;

        }
        return res;
    }
}
