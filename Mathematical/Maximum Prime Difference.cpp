class Solution {
public:
    bool isPrime(int x) {
    
        if(x == 0 || x == 1){
            return false;
        }
        for(int i = 2; i*i <= x; i++){
            if(x%i == 0){
                return false;
            }
        }

        return true;
    }
    int maximumPrimeDifference(vector<int>& nums) {
        
        int n = nums.size();
        int minI = n;
        int maxI = -1;
        for(int i = 0; i < n; i++) {
            if(isPrime(nums[i])) {
                minI = min(minI, i);
                maxI = max(maxI, i);
            }
        }

        return maxI - minI;
    }
};
