/*
    Company Tags : Zoho
    GFG Link     :  https://www.geeksforgeeks.org/problems/check-frequencies4211/1
*/

class Solution {
    boolean allSame(int[] freq) {
        int curr = -1;
        for(int it : freq) {
            if(it == 0) continue;
            else if(curr == -1) curr = it;
            else if(curr != it) return false;
        }
        return true;
    }
  
    boolean sameFreq(String s) {
        
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        if(allSame(freq)) return true;
        
        for(int i=0; i<26; i++) {
            if(freq[i] != 0 ) {
                
                freq[i]--;
                
                if(allSame(freq)) return true;
                
                freq[i]++;
            }
        }
        
        return false;
    }
}
