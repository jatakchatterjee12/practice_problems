/*
    Company Tags  : Microsoft, Google, Amazon
    Leetcode Link : https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

//********************************************************** C++ ****************************************************//

//Similar to normal sliding window qns
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> arr(26, 0);
        
        int m = s.length();
        int n = p.length();
        
        for(char &ch : p)
            arr[ch-'a']++;
        
        int i = 0, j = 0;
        vector<int> result;
        
        while(j < m) {
            arr[s[j] - 'a']--;
            
            if(j-i+1 == n) {
                if(arr == vector<int>(26, 0)) {
                    result.push_back(i);
                }
                
                arr[s[i]-'a']++;
                i++;
            }
            j++;
        }
        
        return result;
    }
};

//******************************************************** JAVA *******************************************************//
class Solution {
    private boolean isAllZero(int[] count){
        for(int cnt : count){
            if(cnt != 0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        
        int m = s.length();
        int n = p.length();

        int[] count = new int[26];
        //storing p chars count
        for(char ch : p.toCharArray()){
            count[ch-'a']++;
        }

        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        while(j < m){

            count[s.charAt(j)-'a']--;

            if(j-i+1 == n) { // current window size is equal to our p length

                if(isAllZero(count)){
                    result.add(i); // i is the starting index of current window
                }

                count[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return result;
    }
}
