class Solution {
public:
    int minimumLength(string s) {
        int result = s.length();

        unordered_map<char, int> mp;
        for(char ch : s){
            mp[ch]++;

            if(mp[ch] > 2){
                mp[ch] = 1;
                result -= 2;
            }
        }
        return result;
    }
};
