/*
    Leetcode Link       : https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
*/


class Solution {
    public int countKDifference(int[] nums, int k) {
        
        Map<Integer, Integer> mp = new HashMap<>();

        int ans = 0;

        for(int num : nums){
  
            if(mp.containsKey(num+k)){
                ans += mp.get(num+k);
            }
            if(mp.containsKey(num-k)){
                ans += mp.get(num-k);
            }

            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        return ans;
    }
}
