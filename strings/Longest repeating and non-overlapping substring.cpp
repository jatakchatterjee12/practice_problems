/*
    Company tags : MakeMyTrip, Walmart
    GFG Link     : https://www.geeksforgeeks.org/problems/longest-repeating-and-non-overlapping-substring3421/1
*/

class Solution {
  public:
    string longestSubstring(string s, int n) {
        
        //dp[i][j] -> substring ends at i and another substring ends at j with the max length
        
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        int res_length = 0;
        int i;
        int index = 0;
        
        for(int i=1; i <= n; i++) {
            for(int j=i+1; j<=n; j++) {
                
                if(j-i > dp[i-1][j-1] && s[i-1] == s[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                    if(dp[i][j] > res_length) {
                        res_length = dp[i][j];
                        index = max(index, i);
                    }
                }
                else{
                    dp[i][j] = 0;
                }
                
            }
        }
        string ans="";
        if(res_length > 0) {
            for(i = index-res_length+1; i <= index; i++) {
                ans += s[i-1];
            }
            return ans;
        }
        return "-1";
    }
};

