//Recursion + Memo
class Solution {
public:
    int t[2001][2001];
    bool solve(int i, int j, string s, string p) {

        if(i < 0 && j < 0) return true; // s & p both exhausted

        if(i >= 0 && j < 0) return false; // s pe char bacha hai lekin p khatam ho gya

        if(i < 0 && j >= 0) { // s khatam lekin p pe char bacha hai to check karlo woh sare char * hai ki nehi..sare  '*' hua to return true
            for(int k = 0; k <= j; k++){
                if(p[k] != '*'){
                    return false;
                }
            }
            return true;
        }

        if(t[i][j] != -1) return t[i][j];

        if(s[i] == p[j] || p[j] == '?'){
            return t[i][j] = solve(i-1, j-1, s, p);
        }

        if(p[j] == '*') {
            bool take_char = solve(i-1, j, s, p); // * match with the s[i]
            bool take_no_char = solve(i, j-1, s, p); // * = ' ' taking no character 
            return t[i][j] = (take_char | take_no_char); 
        }
        return t[i][j] = false; // s[i] does not match with p[j]
    }
    bool isMatch(string s, string p) {
        int n = s.length();
        int m = p.length();
        memset(t, -1, sizeof(t));
        return solve(n-1, m-1, s, p);
    }
};

// Tabulation
class Solution {
public:
    bool isMatch(string s, string p) {
        int n = s.length();
        int m = p.length();
        vector<vector<bool>> dp(2001,vector<bool>(2001));

        // i == 0 && j == 0  (Making it 1 based indexing)
        dp[0][0] = true; 

        // p khtaam lekin s ke chars bacha hai
        for(int i = 1; i <= n; i++) dp[i][0] = false;

        //s khatam lekin p pe chars bacha hai to check karlo sare '*' hai ki nehi
        for(int j = 1; j <= m; j++){
            bool fl = true;
            for(int k = 1; k<=j; k++) {
                if(p[k-1] != '*') {
                    fl = false;
                    break;
                }
            }
            dp[0][j] = fl;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s[i-1] == p[j-1] || p[j-1] == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p[j-1] == '*') {
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
};
