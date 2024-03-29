//Approach 1 : Brute Force
class Solution {
public:
    int maximumLengthSubstring(string s) {
        
        int n = s.size();
        int ans = 0;

        for(int i = 0;  i <n; i++) {

            unordered_map<char, int> mp;
            for(int j = i; j < n; j++) {

                mp[s[j]]++;
                if(mp[s[j]] > 2) break;

                ans = max(ans, j - i + 1);
            }
        }
        return ans;


    }
};

//Approach 2 : Sliding Window
class Solution {
public:
    int maximumLengthSubstring(string s) {
        
        int n = s.size();
        int ans = 0;
        int left = 0;
        int right = 0;

        unordered_map<char, int> mp;

        while(right < n) {

            mp[s[right]]++;

            while(mp[s[right]]  > 2) {
                mp[s[left]]--;
                left++;
            }

            ans = max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
};
