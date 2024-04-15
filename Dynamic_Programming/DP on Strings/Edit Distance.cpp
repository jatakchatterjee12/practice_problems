
/*    
    Company Tags                : Amazon, Goldman Sachs, Microsoft, Google
    Leetcode Qn Link            : https://leetcode.com/problems/edit-distance/
*/         


//****************************************** C++ ***************************************************//
//Recur + Memo
class Solution {
public:
    int m,n;
    int t[501][501];
    int solve(int i, int j, string &word1, string &word2){
        
        if(i==0) return j;
        if(j==0) return i;

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(word1[i-1] == word2[j-1]){
            return  t[i][j] = 0 + solve(i-1,j-1,word1,word2);
        }

        int insert = 1 + solve(i, j-1,word1,word2);
        int del = 1 + solve(i-1, j,word1,word2);
        int replace = 1 + solve(i-1, j-1,word1,word2);

        return t[i][j] = min(insert,min(del,replace));
    }
    int minDistance(string word1, string word2) {

        m = word1.length();
        n = word2.length();
        memset(t,-1,sizeof(t));

        return solve(m,n,word1,word2);
        
    }
};

//Tabulation
class Solution {
public:
    int m,n;
    
    int minDistance(string word1, string word2) {

        m = word1.length();
        n = word2.length();
        vector<vector<int>> dp(501, vector<int>(501,0));

        for(int j = 0; j<= n; j++){
            dp[0][j] = j;
        }

        for(int i = 0; i<= m; i++){
            dp[i][0] = i;
        }

        for(int i = 1;i<=m;i++){
            for(int j= 1; j <= n; j++){

                if(word1[i-1] == word2[j-1]){
                      dp[i][j] = 0 + dp[i-1][j-1];
                }
                else {
                    int insert = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = min(insert,min(del,replace));
                }
                
            }
        }

        return dp[m][n];
    }
};


//Approach-1 (Recur + Memo, starting from m, n)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int t[501][501];
    int solve(string& s1, string& s2, int m, int n) {
        if(m == 0 || n == 0)
            return m+n;
        
        if(t[m][n] != -1)
            return t[m][n];
        
        if(s1[m-1] == s2[n-1])
            return t[m][n] = solve(s1, s2, m-1, n-1);
        else {
            int insertC  = 1 + solve(s1, s2, m, n-1);
            int deleteC  = 1 + solve(s1, s2, m-1, n);
            int replaceC = 1 + solve(s1, s2, m-1, n-1);
            
            return t[m][n] = min({insertC, deleteC, replaceC});
        }
        
    }
    
    int minDistance(string s1, string s2) {
        int m = s1.length();
        int n = s2.length();
        memset(t, -1, sizeof(t));
        return solve(s1, s2, m, n);
    }
};

//Approach-2 (Recur + Memo, starting from i = 0, j = 0)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int t[501][501];
    int m, n;
    int solve(string& s1, string& s2, int i, int j) {
        if(i == m)
            return n-j;
        else if(j == n)
            return m-i;
        
        if(t[i][j] != -1)
            return t[i][j];
        
        if(s1[i] == s2[j])
            return t[i][j] = solve(s1, s2, i+1, j+1);
        else {
            int insertC  = 1 + solve(s1, s2, i, j+1);
            int deleteC  = 1 + solve(s1, s2, i+1, j);
            int replaceC = 1 + solve(s1, s2, i+1, j+1);
            
            return t[i][j] = min({insertC, deleteC, replaceC});
        }
        
    }
    
    int minDistance(string s1, string s2) {
        m = s1.length();
        n = s2.length();
        memset(t, -1, sizeof(t));
        return solve(s1, s2, 0, 0);
    }
};


//Approach-3 (Using Bottom Up derived from Approach-1)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
public:
    int editDistance(string s1, string s2, int m, int n) {
        vector<vector<int>> t(m+1, vector<int>(n+1));
        
        for(int i = 0; i<m+1; i++) {
            for(int j = 0; j<n+1; j++) {
                if(i == 0 || j == 0)
                    t[i][j] = i+j;
                else if(s1[i-1] == s2[j-1])
                    t[i][j] = t[i-1][j-1];
                else
                    t[i][j] = 1 + min({t[i][j-1], t[i-1][j], t[i-1][j-1]});
            }
        }
        return t[m][n];
    }
    int minDistance(string s1, string s2) {
        int m = s1.length();
        int n = s2.length();
        
        return editDistance(s1, s2, m, n);
    }
};




//************************************************* JAVA ******************************************************//
//Tabulation
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int j = 0; j<= n; j++){
            dp[0][j] = j;
        }

        for(int i = 0; i<= m; i++){
            dp[i][0] = i;
        }

        for(int i = 1;i<=m;i++){
            for(int j= 1; j <= n; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                      dp[i][j] = 0 + dp[i-1][j-1];
                }
                else {
                    int insert = 1 + dp[i][j-1];
                    int del = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert,Math.min(del,replace));
                }
                
            }
        }

        return dp[m][n];
    }
}


//Approach-1 (Recur + Memo, starting from m, n)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int[][] t = new int[501][501];

    public int solve(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return m + n;

        if (t[m][n] != -1)
            return t[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return t[m][n] = solve(s1, s2, m - 1, n - 1);
        else {
            int insertC = 1 + solve(s1, s2, m, n - 1);
            int deleteC = 1 + solve(s1, s2, m - 1, n);
            int replaceC = 1 + solve(s1, s2, m - 1, n - 1);

            return t[m][n] = Math.min(Math.min(insertC, deleteC), replaceC);
        }
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(s1, s2, m, n);
    }
}

//Approach-2 (Recur + Memo, starting from i = 0, j = 0)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    int[][] t = new int[501][501];
    int m, n;

    public int solve(String s1, String s2, int i, int j) {
        if (i == m)
            return n - j;
        else if (j == n)
            return m - i;

        if (t[i][j] != -1)
            return t[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            return t[i][j] = solve(s1, s2, i + 1, j + 1);
        else {
            int insertC = 1 + solve(s1, s2, i, j + 1);
            int deleteC = 1 + solve(s1, s2, i + 1, j);
            int replaceC = 1 + solve(s1, s2, i + 1, j + 1);

            return t[i][j] = Math.min(Math.min(insertC, deleteC), replaceC);
        }

    }

    public int minDistance(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        for (int[] row : t)
            Arrays.fill(row, -1);

        return solve(s1, s2, 0, 0);
    }
}


//Approach-3 (Using Bottom Up derived from Approach-1)
//T.C : O(m*n)
//S.C : O(m*n)
class Solution {
    public int editDistance(String s1, String s2, int m, int n) {
        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = t[i - 1][j - 1];
                else
                    t[i][j] = 1 + Math.min(Math.min(t[i][j - 1], t[i - 1][j]), t[i - 1][j - 1]);
            }
        }
        return t[m][n];
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        return editDistance(s1, s2, m, n);
    }
}
