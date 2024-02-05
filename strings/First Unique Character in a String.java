//**************************************** JAVA ********************************************//
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();

        int freq[] = new int[26];

        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        for(int i=0;i<n;i++){
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}

//*********************************************** C++ ****************************************************888//
class Solution {
public:
    int firstUniqChar(string s) {
        int n = s.length();
        unordered_map<char, int> mp;
        for(int i=0;i<n;i++){
            mp[s[i]]++;
        }

        for(int i=0;i<n;i++){
            if(mp[s[i]] == 1){
                return i;
            }
        }
        return -1;
    }
};
