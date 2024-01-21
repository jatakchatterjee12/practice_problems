/*
    Company Tags                : Amazon, OYO Rooms, Paytm, Walmart, Google, Flipkart, LinkedIn, Airbnb
    Leetcode Link               : https://leetcode.com/problems/house-robber/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
    Also Famouse as             : Stickler Thief
*/

//Approach-1 (Recur + Memo)
class Solution {
public:
    int t[101];
    int solve(vector<int>& nums, int i, int& n) {
        if(i >= n)
            return 0;
        
        if(t[i] != -1)
            return t[i];
        
        int take = nums[i] + solve(nums, i+2, n); //steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i+1, n); //skips this house, now we can move to adjacent next house
        
        return t[i]=max(take, skip);
    }
    
    int rob(vector<int>& nums) {
        int n = nums.size();
        memset(t, -1, sizeof(t));
        return solve(nums, 0, n);
    }
};


//Approach-2 (Bottom up)
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        
        if(n == 1)
            return nums[0];
        
        vector<int> t(n+1);
        //t[i] = max profit till house i
        
        t[0] = 0;
        t[1] = nums[0];
        
        for(int i = 2; i<=n; i++) {
            
            int skip  = t[i-1];
            int steal = nums[i-1] + t[i-2];
          
            t[i] = max(skip, steal); //max(skip, steal)
            /*
                SKIP  : If we skip this house,  then we have money till previous house  =  t[i-1]
                STEAL : If we steal this house, then we can't take prev profit, we can take till (i-2)th house profit = t[i-2]
            */
        }
        
        return t[n];
        
    }
};

// Another way to implement bottom-up
  int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 0 ) return 0;
        vector<int> dp(n+1);

        dp[n] = 0;
        dp[n-1] = nums[n-1];
        //dp[n-2] = nums[n-2];
        for(int i = n-2; i>=0; i--){
            dp[i] = max(dp[i+1], nums[i] + dp[i+2]);
        }
        return dp[0];
    }


//Approach-3 (Space Optimized Bottom Up - Converting Approach-2)
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        
        int prevPrev = 0;
        int prev     = nums[0];
        
        for(int i = 2; i<=n; i++) {
            int skip = prev;
            
            int take = nums[i-1] + prevPrev;
                
            int temp = max(skip, take);
            
            prevPrev = prev;
            prev     = temp;
        }
        
        return prev;
    }
};

//*************************************** JAVA **********************************************//
// Recur + Memo
class Solution {

    int solve(int[] nums, int i, int n,int[] dp){

        if(i >= n) return 0;
        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(nums, i+2, n,dp);
        int not_steal = 0 + solve(nums, i+1 , n,dp);

        return dp[i] = Math.max(steal,not_steal);
    }
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[100];
        Arrays.fill(dp,-1);

        return solve(nums,0,n,dp);
        
    }
}
// Bottom-Up
class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n+1];

        // dp[i] = max stolen money till  i house 

        dp[0] = 0; // 0 house i.e- no profit
        dp[1] = nums[0]; // 1 house i.e- max profit will be the  house 1 money => nums[0] ;

        for(int i = 2; i <= n; i++){

            int steal = nums[i-1] + dp[i-2];
            int not_steal = dp[i-1];

            dp[i] = Math.max(steal,not_steal);
        }

        return dp[n];
    }
}

//Approach-3 (Space Optimized Bottom Up - Converting Approach-2)
class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        int prev_prev = 0; // t[0]
        int prev = nums[0]; // t[1]

        for(int i=1; i<n;i++){
            
            int take = nums[i] + prev_prev;
            int skip = prev;

            int maxi = Math.max(take, skip);

            prev_prev = prev;
            prev = maxi;
        }
        return prev;
    }
}
