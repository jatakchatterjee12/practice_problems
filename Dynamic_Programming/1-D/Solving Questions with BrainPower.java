
/*
    
    Company Tags                : GOOGLE
    Leetcode Link               : https://leetcode.com/problems/solving-questions-with-brainpower/
*/
/************************************************** C++ ***************************************************//

//Approach-1 (Using Simple Recursion + Memo) - Knapsack variant
class Solution {
public:
    
    int n;
    
    long long solve(int i, vector<vector<int>>& questions, vector<long long> &t) {
        
        if(i >= n)
            return 0;
        
        if(t[i] != -1)
            return t[i];
        
        long long taken     = questions[i][0] + solve(i+questions[i][1]+1, questions, t);
        
        long long not_taken = solve(i+1, questions, t);
        
        return t[i] = max(taken, not_taken);
        
    }
    
    long long mostPoints(vector<vector<int>>& questions) {
        n = questions.size();
        vector<long long> t(n+1, -1);
        return solve(0, questions, t);
    }
};


//Approach-2 (Using Bottom Up DP)
class Solution {
public:

    long long mostPoints(vector<vector<int>>& questions) {
        int n = questions.size();
        
        if(n == 1)
            return questions[0][0];
        
        vector<long long> t(200001);
        //t[i] = Max points gained by Questions from questions[i to n-1]
        //return t[0] - from 0 to n-1

        
        for(int i = n-1; i >= 0; i--) {
            t[i] = max(questions[i][0] + t[i + questions[i][1] + 1], t[i+1]);
        }
        
        return t[0];
    }
};

//*********************************************************** JAVA *************************************************//
//Approach-1 (Using Simple Recursion + Memo) - Knapsack variant
class Solution {
    int n;
    private long solve(int i, int[][] q, long[] dp){

        if(i >= n) return 0;
        if(dp[i] != -1){
            return dp[i];
        }

        long taken = q[i][0] + solve(i+q[i][1]+1, q, dp);
        long not_taken = solve(i+1, q, dp);

        return dp[i] = Math.max(taken, not_taken);
    }
    public long mostPoints(int[][] q) {
        n = q.length;
        long[] dp = new long[n+1];
        Arrays.fill(dp, -1);
        return solve(0, q, dp);
    }
}

//Approach-2 (Using Bottom Up DP)
 public long mostPoints(int[][] q) {
        n = q.length;
        long[] dp = new long[200001];
        //dp[i] = Max points gained by Questions from questions[i to n-1]
        //return dp[0] - from 0 to n-1
        
        for(int i = n-1; i >= 0; i--){
            dp[i] = Math.max(q[i][0] + dp[i + q[i][1] + 1], dp[i+1]);
        }
        return dp[0];

    }
}

