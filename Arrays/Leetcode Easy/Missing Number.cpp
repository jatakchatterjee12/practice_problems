//Using Xor
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;

        for(int num : nums) {
            ans = ans^num;
        }

        for(int i = 0; i <= n; i++) {
            ans = ans ^ i;
        }
        return ans;
    }
};

//Using Formula
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        
        int n = nums.size();
        int sum = (n*(n+1))/2;

        int cumSum = 0;
        for(int num : nums){
            cumSum += num;
        }
        return sum - cumSum;
    }
};
