/*
   
    Company Tags                  : Google
    Leetcode Link                 : https://leetcode.com/problems/domino-and-tromino-tiling/
*/

/////////////////////////////////////////// C++ /////////////////////////////////////////////

//Approach-1 (Recur + Memo) : O(n)
class Solution {
public:
    int M = 1000000007;
    int t[1001];
    int solve(int n) {
         if(n == 1 || n == 2)
            return n;
        if(n == 3)
            return 5;
        
        if(t[n] != -1)
            return t[n];
        
        return t[n] = (2*solve(n-1)%M + solve(n-3)%M)%M;
    }
    
    int numTilings(int n) {
       
        memset(t, -1, sizeof(t));
        
        
        return solve(n);
        
    }
};

//Approach-2 (Bottom Up) : O(n)
class Solution {
public:
    int M = 1000000007;
    int numTilings(int n) {
        if(n == 1 || n == 2)
            return n;
        
        vector<int> t(n+1, 0);
        
        t[1] = 1;
        t[2] = 2;
        t[3] = 5;
        
        for(int i = 4; i<=n; i++) {
            t[i] = (2*t[i-1]%M + t[i-3]%M) % M;
        }
        
        return t[n];
        
        
    }
};


////////////////////////////////////////// JAVA ///////////////////////////////////////////////
//Approach-1 (Recur + Memo) : O(n)
class Solution {
    int M = (int)1e9 + 7;
    int[] dp = new int[1001];

    int solve(int n){
        if(n == 1 || n == 2){
            return n;
        }

        if(n == 3){
            return 5;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n] = (2* solve(n-1) % M + solve(n-3) % M) % M;


    }

    public int numTilings(int n) {
        Arrays.fill(dp, -1);

        return solve(n);
    }
}

////Approach-2 (Bottom Up) : O(n)
class Solution {
    int M = (int)1e9 + 7;

    public int numTilings(int n) {
        
        if(n == 1 || n == 2) return n;

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for(int i = 4; i <= n; i++) {
            dp[i] = (2*dp[i-1] % M + dp[i-3]%M) % M;
        }

        return dp[n];
    }
}
