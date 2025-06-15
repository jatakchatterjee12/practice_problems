
/*    
    Company Tags          : Google, Meta
    Leetcode Link         : https://leetcode.com/problems/target-sum/
*/


/*************************************************************** C++ ******************************************************/
//Approach-1 (Normal Recursion & Memoization using unordered_map)
//T.C : O(n*totalSum)
//S.C : O(n*totalSum)
class Solution {
public:
    int solve(vector<int>& nums, int &target, int i, int sum, unordered_map<string, int>& memo) {
        if (i == nums.size()) {
            return sum == target ? 1 : 0;
        }

        // Create a unique key for the current state
        string key = to_string(i) + "," + to_string(sum);

        // Check if the result is already computed
        if (memo.find(key) != memo.end()) {
            return memo[key];
        }

        // Compute the result recursively
        int plus = solve(nums, target, i + 1, sum + nums[i], memo);
        int minus = solve(nums, target, i + 1, sum - nums[i], memo);

        // Store the result in the memo
        memo[key] = plus + minus;

        return memo[key];
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        unordered_map<string, int> memo;
        return solve(nums, target, 0, 0, memo);
    }
};


//Approach-2 (Normal Recursion & Memoization using vector)
//T.C : O(n*totalSum)
//S.C : O(n*totalSum)
class Solution {
public:
    int S;
    int solve(vector<int>& nums, int &target, int i, int sum, vector<vector<int>>& t) {
        if(i == nums.size()) {
            return sum == target ? 1 : 0;
        }

        if(t[i][sum+S] != INT_MIN) {
            return t[i][sum+S];
        }
        int plus  = solve(nums, target, i+1, sum+nums[i], t);
        int minus = solve(nums, target, i+1, sum-nums[i], t);

        return t[i][sum+S] = plus+minus;
    }

    int findTargetSumWays(vector<int>& nums, int target) {
        int n = nums.size();
        S = accumulate(begin(nums), end(nums), 0);
        vector<vector<int>> t(n, vector<int>(2*S+1, INT_MIN));
        return solve(nums, target, 0, 0, t);
    }
};

//Approach-3 (Recursion + Memoization) - Using concept of SubsetSum and Partition Equal Subset Sum
//T.C : O(n*target)
//S.C : O(n*target)
class Solution {
public:
    int t[21][1001];
    int subsetSum(vector<int>& nums, int n, int s) {
        if(t[n][s] != -1)
            return t[n][s];
        if(s == 0)
            return 1;
        if(n == 0)
            return 0;
        if(nums[n-1] == 0)
            return t[n][s] = subsetSum(nums, n-1, s);
        
        if(nums[n-1] <= s)
            return t[n][s] = subsetSum(nums, n-1, s-nums[n-1]) + subsetSum(nums, n-1, s);
        else
            return t[n][s] = subsetSum(nums, n-1, s);
    }
    
    int findTargetSumWays(vector<int>& nums, int target) {
        memset(t, -1, sizeof(t));
        int sum   = accumulate(begin(nums), end(nums), 0);
        auto lambda = [&](const int& x) {
            return x == 0;
        };
        int zeros = count_if(begin(nums), end(nums), lambda);
        if(target > sum)
            return 0;
        
        if((sum-target) %2 != 0)
            return 0;
        
        int s1 = (sum-target)/2;
        return pow(2, zeros)*subsetSum(nums, nums.size(), s1);
    }
};


//Approach-4 (Bottom Up DP) - Using concept of SubsetSum and Partition Equal Subset Sum
//T.C : O(n*target)
//S.C : O(n*target)
class Solution {
public:
    int subsetSum(vector<int>& nums, int s) {
        int n = nums.size();
        vector<vector<int>> t(n+1, vector<int>(s+1));
        
        for(int col = 0; col < s+1; col++) t[0][col] = 0;
        for(int row = 0; row < n+1; row++) t[row][0] = 1;
        
        for(int i = 1; i<n+1; i++) {
            for(int j = 1; j<s+1; j++) {
                if(nums[i-1] == 0)
                    t[i][j] = t[i-1][j];
                else if(nums[i-1] <= j)
                    t[i][j] = t[i-1][j-nums[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];
            }
        }
        
        return t[n][s];
    }
    
    int findTargetSumWays(vector<int>& nums, int target) {
        int sum   = accumulate(begin(nums), end(nums), 0);
        auto lambda = [&](const int& x) {
            return x == 0;
        };
        int zeros = count_if(begin(nums), end(nums), lambda);
        if(target > sum)
            return 0;
        
        if((sum-target) %2 != 0)
            return 0;
        
        int s1 = (sum-target)/2;
        /*
            You could also do like this :
            if((sum + target)%2 != 0)
                return 0;
        
            int s1 = (sum + target)/2;
            But since, target can be negative also as per Leetcode (they have recently changed the constraints), 
            you need to do :
            target = abs(target); before finding s1 and the if condition above
        */
        return pow(2, zeros)*subsetSum(nums, s1);
    }
};




/*************************************************************** JAVA ******************************************************/
//Approach-1 (Normal Recursion & Memoization using unordered_map)
//T.C : O(n*totalSum)
//S.C : O(n*totalSum)
/*
    The first approach that comes to our mind is to generate all subsequences and try both options of placing ‘-’ and ‘+’ signs and count the expression if it evaluates the answer.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> memo = new HashMap<>();
        return solve(nums, target, 0, 0, memo);
    }

    private int solve(int[] nums, int target, int i, int sum, HashMap<String, Integer> memo) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        // Create a unique key for the current state
        String key = i + "," + sum;

        // Check if the result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Compute the result recursively
        int plus = solve(nums, target, i + 1, sum + nums[i], memo);
        int minus = solve(nums, target, i + 1, sum - nums[i], memo);

        // Store the result in the memo
        memo.put(key, plus + minus);

        return memo.get(key);
    }
}


//Approach-2 (Normal Recursion & Memoization)
//T.C : O(n*totalSum)
//S.C : O(n*totalSum)
/*
    The first approach that comes to our mind is to generate all subsequences and try both options of placing ‘-’ and ‘+’ signs and count the expression if it evaluates the answer.
*/
class Solution {
    private int S;

    private int solve(int[] nums, int target, int i, int sum, int[][] t) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (t[i][sum + S] != Integer.MIN_VALUE) {
            return t[i][sum + S];
        }

        int plus = solve(nums, target, i + 1, sum + nums[i], t);
        int minus = solve(nums, target, i + 1, sum - nums[i], t);

        return t[i][sum + S] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        S = Arrays.stream(nums).sum();
        int[][] t = new int[n][2 * S + 1];

        for (int[] row : t) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(nums, target, 0, 0, t);
    }
}

//Approach-3 (Recursion + Memoization) - Using concept of SubsetSum and Partition Equal Subset Sum
//T.C : O(n*target)
//S.C : O(n*target)
/*
  If we think, the given ‘target’ can be expressed as addition of two integers (say Sum1 and Sum2). 
  Sum1 + Sum2 = target   – (i)
  
  We divide the elements in two sections 1) positives one and 2) negative ones 
  
  Sum1 -> sum of all positive integers in the array
  Sum2 -> sum of all negative integers in the array
  
  so, Sum1 - Sum2 = target   - (ii)
  
  now, totalSum = total sum of all elements in the array.
  
  Sum1 = totalSum - Sum2      – (iii)
  
  Now, it means Sum2 = (totalSum - target)/2;
  
  Now the Question boils down to : "Count Number of subsets with sum (totSum - target)/2"
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums) totalSum += num;

        if((totalSum-target) < 0 || (totalSum - target)%2 != 0){
            return 0;
        }
        int s1 = (totalSum - target)/2;

        int[][] dp = new int[n+1][s1+1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }

        return solve(nums, 0, s1, n, dp);
    }

    int solve(int[] nums, int i, int targetSum, int n, int[][] dp){

        if(i == n-1){
            if(targetSum == 0 && nums[n-1] == 0) return 2; //  targetSum = 0,nums[n-1]= 0, even we pick n-1th element or not pick we getv our answer so pick+not_pick = 2 ways
            if(targetSum == 0 || nums[n-1] == targetSum) return 1;
            return 0;
        }

        if(dp[i][targetSum] != -1){
            return dp[i][targetSum];
        }
        
        int not_pick = solve(nums, i+1, targetSum, n, dp);

        int pick = 0;

        if(nums[i] <= targetSum){
            pick = solve(nums, i+1, targetSum - nums[i], n, dp);
        }

        return dp[i][targetSum] = pick + not_pick;

    }
}



//Approach-4 (Bottom Up DP) - Using concept of SubsetSum and Partition Equal Subset Sum
//T.C : O(n*target)
//S.C : O(n*target)
class Solution {
    private int subsetSum(int[] nums, int s) {
        int n = nums.length;
        int[][] t = new int[n + 1][s + 1];

        // Initialize the first row to 0 and the first column to 1
        for (int col = 0; col <= s; col++) {
            t[0][col] = 0;
        }
        for (int row = 0; row <= n; row++) {
            t[row][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                if (nums[i - 1] == 0) {
                    t[i][j] = t[i - 1][j];
                } else if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][s];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        long zeros = Arrays.stream(nums).filter(x -> x == 0).count();

        if (target > sum) {
            return 0;
        }

        if ((sum - target) % 2 != 0) {
            return 0;
        }

        int s1 = (sum - target) / 2;

        // Optional: Adjust for negative targets (if required by constraints)
        // target = Math.abs(target);
        // if ((sum + target) % 2 != 0) return 0;
        // int s1 = (sum + target) / 2;

        return (int) Math.pow(2, zeros) * subsetSum(nums, s1);
    }
}
