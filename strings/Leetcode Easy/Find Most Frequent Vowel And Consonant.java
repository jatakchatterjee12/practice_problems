/*

  leetcode link  : https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description/
*/

class Solution {
    public int maxFreqSum(String s) {
        int maxV = 0;
        int maxC = 0;

        int[] freq = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;

            if("aeiou".indexOf(ch) != -1){
                maxV = Math.max(maxV, freq[ch-'a']);
            }
            else{
                maxC = Math.max(maxC, freq[ch-'a']);
            }
        }
        return maxV+maxC;

        
    }
}
