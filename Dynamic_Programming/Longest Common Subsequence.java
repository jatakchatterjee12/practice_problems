/*
    Company Tags                : Microsoft, Amazon, FactSet, Hike, Citrix, MakeMyTrip, Paytm, VMWare
    Leetcode Link               : https://leetcode.com/problems/longest-common-subsequence/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
*/

//Approach-1 (Recursion + Memoization (start from end to 0)
class Solution {
public:
    int t[1001][1001];
    int LCS(string& s1, string& s2, int m, int n) {
        if(m == 0 || n == 0)
            return t[m][n] = 0;
        
        if(t[m][n] != -1)
            return t[m][n];
        
        if(s1[m-1] == s2[n-1])
            return t[m][n] = 1 + LCS(s1, s2, m-1, n-1);
        
        return t[m][n] = max(LCS(s1, s2, m, n-1), LCS(s1, s2, m-1, n));
    }
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        
        memset(t, -1, sizeof(t));
        
        return LCS(text1, text2, m, n);
    }
};
// Recur + Memo (start from 0 to end of length)
class Solution {
public:
    int n,m;
    int t[1001][1001];


    int solve(string &s1, string &s2, int i, int j){
        if(i >= n || j >= m)
            return 0;

        if(t[i][j] != -1) return t[i][j];    

        if(s1[i] == s2[j]){
            return t[i][j] = 1 + solve(s1,s2,i+1,j+1);
        }    
        
        return t[i][j] = max(solve(s1,s2,i,j+1), solve(s1,s2,i+1,j));
        
    }
    int longestCommonSubsequence(string text1, string text2) {
        n=text1.size();
        m=text2.size();
        memset(t,-1,sizeof(t));
        return solve(text1,text2,0,0);
    }
};

//Approach-2 (Bottom Up)
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        
        vector<vector<int>> t(m+1, vector<int>(n+1));
        
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i == 0 || j == 0)
                    t[i][j] = 0;
                else if(text1[i-1] == text2[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = max(t[i][j-1], t[i-1][j]);
            }
        }
        
        return t[m][n];
    }
};

//Approach-2 (Bottom Up space optmized)
/*
Since, in bottm up approach, we are using results of only two rows, t[i] and t[i-1]. So, we can take only two rows.
*/
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int m = text1.length();
        int n = text2.length();
        
        vector<vector<int>> t(2, vector<int>(n+1));
        
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i == 0 || j == 0)
                    t[i%2][j] = 0;
                else if(text1[i-1] == text2[j-1])
                    t[i%2][j] = 1 + t[(i+1)%2][j-1];
                else
                    t[i%2][j] = max(t[i%2][j-1], t[(i+1)%2][j]);
            }
        }
        
        return t[m%2][n];
    }
};

//******************************************* JAVA ********************************************//
// Recur + Memo
class Solution {
    int n,m;
    int[][] dp;

    int solve(String s1, String s2, int i, int j){
        if(i >= n || j >= m)return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(s1,s2,i+1,j+1); 
        }
        return dp[i][j] = Math.max(solve(s1,s2,i,j+1), solve(s1,s2,i+1,j));
    }
    public int longestCommonSubsequence(String s1, String s2) {
        n = s1.length();
        m = s2.length();
        dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        return solve(s1,s2,0,0);
    }
}

// Bottom up
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int row=0;row<=m;row++){
            dp[row][0] = 0;
        }
        for(int col=0;col<=n;col++){
            dp[0][col] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
