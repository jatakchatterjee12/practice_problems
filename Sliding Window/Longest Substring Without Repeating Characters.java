//***************************************** C++ ********************************************//
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.length();
        vector<bool> count(256,0);

        int i=0,j=0;
        int maxL = 0;

        while(j<n){

            while(count[s[j]] == 1){
               //shrinking
                count[s[i]] = 0;
                i++;
            }
            maxL = max(maxL, j-i+1);

            count[s[j]] = 1;
            j++;
        }
        return maxL;
    }
};
//******************************************** JAVA ******************************************//
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] count = new int[256];

        int i = 0;
        int j = 0;
        int maxL = 0;

        while(j < n){
            while(count[s.charAt(j)] == 1){
                // shrinking
                count[s.charAt(i)] = 0;
                i++;
            }

            maxL = Math.max(maxL, j-i+1);
            count[s.charAt(j)] = 1;
            j++;
        }
        return maxL;
        
    }
}
