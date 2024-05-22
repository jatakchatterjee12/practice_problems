/*
    Company Tags                : Google, Microsoft, Amazon, Ebay, Meta
    Leetcode Link               : https://leetcode.com/problems/jump-game/
*/


//OPTIMAL Solution (ACCEPTED)
class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxReachable = 0;
        int n            = nums.size();
        
        for(int i = 0; i<n; i++) {
            if(i > maxReachable) {
                return false;
            }
            maxReachable = max(maxReachable, nums[i]+i);
        }
        
        return true;
    }
};

//Recursion+Memoization (ACCEPTED)
class Solution {
public:
    int t[10001];
    bool solve(vector<int>& nums, int n, int idx) {
        if(idx == n-1)
            return true;
        
        if(t[idx] != -1)
            return t[idx];
        
        for(int i = 1; i <= nums[idx]; i++) {
            if(solve(nums, n, idx+i))
                return t[idx] = true;
        }
    
        return t[idx] = false;
    }
    
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        memset(t, -1, sizeof(t));
        return solve(nums, n, 0);
    }
};

//Bottom Up : O(n^2)
class Solution {
public:
    
    bool canJump(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> t(n, false);
        //t[i] = True means, you can reach index i
        
        t[0] = true; //Already at starting index
        
        for(int i = 1; i<n; i++) {
            for(int j = i-1; j>=0; j--) {
                if(j + nums[j] >= i && t[j]) { //here t[j] == true means you should be able to reach j also, 
                                               //then only you can plan to jump(j+nums[i])  from this jth index
                    t[i] = true;
                    break;
                }
            }
        }
        
        
        return t[n-1];

    }
};


//************************************************ JAVA **************************************************//
//Approach 1 : Greedy (OPTIMIZED)
class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int maxReachable = 0;

        for(int i = 0; i < n; i++) {

            if(i > maxReachable){
                return false;
            }

            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}



//Approach 2 : Recursion + Memo
class Solution {
    boolean solve(int[] nums, int i, int n, Boolean[] dp) {

        if(i >= n-1) return true;

        if(dp[i] != null) return dp[i];

        for(int jump = 1; jump <= nums[i]; jump++) {

            if(solve(nums, i + jump, n, dp) == true){
                return dp[i] = true;
            }
        }

        return dp[i] = false;
    }
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        Boolean[] dp = new Boolean[n+1]; // default value null
        
        return solve(nums, 0, n, dp);
    }
}
