/*
    Company Tags                : Amazon, Microsoft
    Leetcode Link               : https://leetcode.com/problems/maximum-sum-circular-subarray/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
*/

//********************************************************* C++ *****************************************************//
//Approach-1 (Using Kadane's Algo) - O(N)
class Solution {
public:
    
    int kadanesMax(vector<int>& nums, int n) {
        int sum     = nums[0];
        int maxSum  = nums[0];
        
        for(int i = 1; i<n; i++) {
            sum     = max(sum + nums[i], nums[i]);
            maxSum  = max(maxSum, sum);
        }
        
        return maxSum;
    }
    
    int kadanesMin(vector<int>& nums, int n) {
        int sum     = nums[0];
        int minSum  = nums[0];
        
        for(int i = 1; i<n; i++) {
            sum     = min(sum + nums[i], nums[i]);
            minSum  = min(minSum, sum);
        }
        
        return minSum;
    }
    
    int maxSubarraySumCircular(vector<int>& nums) {
        int n = nums.size();
        int SUM = accumulate(begin(nums), end(nums), 0);
        
        int minSum = kadanesMin(nums, n);
        
        int maxSum = kadanesMax(nums, n);
        
        int circSum = SUM - minSum;
        
        if(maxSum > 0) {
            return max(maxSum, circSum);
        }
        
        return maxSum;
    }
};

//Approach-2 (Writing everything in one loop) - O(N)
class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int n   = nums.size();
        int SUM = accumulate(begin(nums), end(nums), 0);
        
        int k_sum_min = nums[0];
        int min_sum   = nums[0];
        
        int k_sum_max = nums[0];
        int max_sum   = nums[0];
        
        for(int i = 1; i<nums.size(); i++) {
            
            min_sum   = min(nums[i]+min_sum, nums[i]);
            k_sum_min = min(k_sum_min, min_sum);
            
            max_sum = max(nums[i]+max_sum, nums[i]);
            k_sum_max = max(k_sum_max, max_sum);
         
        }
        
        int circular_sum = SUM - k_sum_min;
        
        if(k_sum_max > 0) {
            return max(k_sum_max, circular_sum);
        }
        
        return k_sum_max;
        
    }
};

//******************************************************** JAVA *******************************************************//
//Approach-1 (Using Kadane's Algo) - O(N)
class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int kadanesMin(int[] a, int n) {
        int currMin = a[0];
        int minSum = a[0];
        
        for(int i=1; i<n; i++) {
            currMin = Math.min(currMin + a[i], a[i]);
            minSum = Math.min(minSum, currMin);
        }
        return minSum;
    }
    static int kadanesMax(int[] a, int n) {
        int currMax = a[0];
        int maxSum = a[0];
        
        for(int i=1; i<n; i++) {
            currMax = Math.max(currMax + a[i], a[i]);
            maxSum = Math.max(maxSum, currMax);
        }
        return maxSum;
    }
    static int circularSubarraySum(int a[], int n) {
        
       int totSum = 0;
       for(int num : a){
           totSum += num;
       }
       
       int minSum = kadanesMin(a,n);
       int maxSum = kadanesMax(a,n); // case 1
       int cir_sum = totSum - minSum; // case 2
       
       return maxSum > 0 ? Math.max(maxSum, cir_sum) : maxSum;
       
    }
    
}

//Approach-2 (Writing everything in one loop) - O(N)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int maxSum = nums[0];
        int currMin = 0;
        int minSum = nums[0];
        int totSum = 0;

        for(int num : nums) {
            currMax += num;
            currMax = Math.max(currMax, num);
            maxSum = Math.max(maxSum, currMax);

            currMin += num;
            currMin = Math.min(currMin, num);
            minSum = Math.min(minSum, currMin);

            totSum += num;
        }

        return maxSum > 0 ? Math.max(maxSum, totSum - minSum) : maxSum;
    }
}
