/*
                        LeetCode Qn Link           :  https://leetcode.com/problems/longest-consecutive-sequence/
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        int longest_streak = 0;
        for(int num : st){
            if(!st.contains(num-1)){ // means yehi streak ka first element hai
                int curr_streak = 1;
                while(st.contains(num+1)){
                    curr_streak++;
                    num = num + 1;
                }
                longest_streak = Math.max(longest_streak, curr_streak);
            }
        }
        return longest_streak;
        
    }
}
