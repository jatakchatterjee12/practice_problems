// DP Solution
/*********************************************** C++ ************************************************/
class Solution { // 344 ms, faster than 21.07%
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        vector<vector<int>> dp(m+1, vector<int>(n+1));
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i-1] == nums2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;
                ans = max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}; // TC - O(n*m) SC - O(n*m)

//  Approach 2. Dynamic Programming (Space Optimized)
class Solution { // 272 ms, faster than 48.13%
public:
    int findLength(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        if (m < n) return findLength(nums2, nums1); // Make sure len(nums1) > len(nums2) to optimize space
        vector<int> dp(n+1), prevDP(n+1);
        int ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (nums1[i-1] == nums2[j-1])
                    dp[j] = prevDP[j-1] + 1;
                else dp[j] = 0;
                ans = max(ans, dp[j]);
            }
            dp.swap(prevDP);
        }
        return ans;
    }
};
// TC - O(n*m)
// Sc - O(n)

/**************************************************** JAVA ********************************************/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // DP - LCS problem
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+1][n+1];
        // dp[i][j] = longest common suffix between nums1[0..i-1] ans nums2[0..j-1]
        int result = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else dp[i][j] = 0;

                result = Math.max(result, dp[i][j]);
            }
        }
        return result;

    }
}

// 
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // DP - LCS problem
        int m = nums1.length;
        int n = nums2.length;

        if(m < n) return findLength(nums2,nums1); //Make sure len(nums1) > len(nums2) to optimize space

        int[] dp = new int[n+1];
        int[] prev = new int[m+1];
        
        int result = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){

                if(nums1[i-1] == nums2[j-1]){
                    dp[j] = prev[j-1] + 1;
                }
                else dp[j] = 0;

                result = Math.max(result, dp[j]);
            }
            prev = dp.clone();
        }
        return result;

    }
}
