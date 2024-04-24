/*
    
    Company Tags                : Google, Amazon, Microsoft, Uber
    Leetcode Link               : https://leetcode.com/problems/restore-the-array/
*/

//****************************************************************** C++ ************************************************************//

//Approach-1 (Recur + Memo)
class Solution {
public:
    
    int n;
    
    const int MOD = 1e9+7;
    
    int solve(int start, string &s, int &k, vector<int>& t) {
        
        if(start >= n)
            return 1;
        
        if(t[start] != -1)
            return t[start];
        
        if(s[start] == '0')
            return t[start] = 0;
        
        long ans = 0;
        
        long long num = 0;
        
        for(int end = start; end < n; end++) {
            
            num = (num*10) + (s[end] - '0');
            
            if(num > k)
                break;
            
            ans = (ans%MOD + solve(end+1, s, k, t)%MOD)%MOD;
            
        }
        
        return t[start] = ans;
    }
    
    
    int numberOfArrays(string s, int k) {
        n = s.length();
        
        vector<int> t(n, -1);
        
        return solve(0, s, k, t);
    }
};


//Approach-2 (Bottom Up)
//Soon




//***************************************************************** Java ******************************************************************//
class Solution {
    int n;
    int M = (int)1e9+7;
    int[] dp;

    int solve(int start, String s, int k) {

        if(start >= n) return 1;

        if(dp[start] != -1) return dp[start];

        if(s.charAt(start) == '0') return dp[start] =  0;

        long ans = 0;
        long num = 0;

        for(int end = start; end < n; end++) {

            num = (num*10) + (s.charAt(end) - '0');
            if(num > k) break;

            ans = (ans%M + solve(end+1, s, k)%M)%M;
        }
        return dp[start] = (int)ans;
    }
    public int numberOfArrays(String s, int k) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(0, s, k);
    }
}
