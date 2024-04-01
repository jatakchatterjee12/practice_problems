/*
  No of characters change ====>>  total length of substring - maxFreqElement
  why?  cz we try to put the max freq element in the substring and try to change the other characters into the maxFreqElement
  
*/
  /


/// Brute Force
class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.size();

        int result = 0;

        for(int i = 0; i < n; i++) {
            int hash[26] = {0};
            int maxFreq = 0;

            for(int j = i; j < n; j++) {

                hash[s[j] - 'A']++;

                maxFreq = max(maxFreq, hash[s[j] -'A']);

                int changes = (j-i+1) - maxFreq;

                if(changes <= k){
                    result = max(result, j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return result;

    }
};



//Better With Sliding Window -- TC -> O(2N * 26)
class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.length();

        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int freq[26] = {0};

        int result = 0;

        while(j < n) {

            freq[s[j] - 'A']++;

            maxFreq = max(maxFreq, freq[s[j] - 'A']);

            // changes_required = (j-i+1) - maxFreq;

            while((j-i+1) - maxFreq > k) {

                freq[s[i] - 'A']--;
                maxFreq = 0;
                for(int el : freq){
                    maxFreq = max(maxFreq, el);
                }
                i++;
            }

            if((j-i+1) - maxFreq <= k){
                result = max(result, j-i+1);
            }
            j++;
        }
        return result;
        
    }
};



//Best Approcah with Sliding Window -- TC -> O(n)
class Solution {
public:
    int characterReplacement(string s, int k) {
        
        int n = s.length();

        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int freq[26] = {0};

        int result = 0;

        while(j < n) {

            freq[s[j] - 'A']++;

            maxFreq = max(maxFreq, freq[s[j] - 'A']);

            // changes_required = (j-i+1) - maxFreq;

            if((j-i+1) - maxFreq > k) {

                freq[s[i] - 'A']--;
               
                i++;
            }

            if((j-i+1) - maxFreq <= k){
                result = max(result, j-i+1);
            }
            j++;
        }
        return result;
        
    }
};
