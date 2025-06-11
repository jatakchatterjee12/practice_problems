
/*
      Company Tags                : Amazon, Google, Meta
      Leetcode Link               : https://leetcode.com/problems/frog-jump/
*/

**************************************** C++ ****************************************
//Approach-1 (Recursion + Memo) - T.C : O(N^2)
class Solution {
public:
    int n;
    unordered_map<int, int> mp;
    int t[2001][2001];
    
    bool solve(vector<int>& stones, int curr_stone_index, int prevJump) {
        if(curr_stone_index == n-1)
            return true;
        
        bool result = false;
        
        if(t[curr_stone_index][prevJump] != -1)
            return t[curr_stone_index][prevJump];
        
        for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++) {
            
            if(nextJump > 0) {
                int next_stone = stones[curr_stone_index] + nextJump;
                
                if(mp.find(next_stone) != mp.end()) {
                    result = result || solve(stones, mp[next_stone], nextJump);
                }
            }
            
        }
        
        return t[curr_stone_index][prevJump] = result;
        
    }
    
    bool canCross(vector<int>& stones) {
        
        if(stones[1] != 1)
            return false;
        
        n = stones.size();
        for(int i = 0; i<n; i++) {
            mp[stones[i]] = i;
        }
        
        memset(t, -1, sizeof(t));
        
        return solve(stones, 0, 0);
    }
};

//Approach-2 (Soon comming - BOTTOM UP)


**************************************** JAVA ****************************************
//Approach-1 (Recursion + Memo) - T.C : O(N^2)
class Solution {
    int n;
    private boolean solve(int curr_ind, int lastJump, int[] stones, Map<Integer, Integer> mp, Boolean[][] dp){

        if(curr_ind == n-1){
            return true;
        }

        if(dp[curr_ind][lastJump] != null){
            return dp[curr_ind][lastJump];
        }

        boolean result = false;

        for(int nextJump = lastJump-1; nextJump <= lastJump+1; nextJump++){

            if(nextJump > 0){

                int nextStone = stones[curr_ind] + nextJump;

                if(mp.containsKey(nextStone)){
                    result = result || solve(mp.get(nextStone), nextJump, stones, mp, dp);
                }
            }
        }
        return dp[curr_ind][lastJump] =  result;
    }
    public boolean canCross(int[] stones) {
        n = stones.length;
        if(stones[1] - stones[0] != 1){
            return false;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[n+1][n+1];

        return solve(0, 0, stones, mp, dp);
    }
}
