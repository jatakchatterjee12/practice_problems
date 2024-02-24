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
