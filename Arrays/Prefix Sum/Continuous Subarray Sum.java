/*
    Company Tags                : Amazon, Facebook, Paytm
    Leetcode Link               : https://leetcode.com/problems/continuous-subarray-sum/
*/


//*************************************************** C++ ***********************************************************//
class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        
        unordered_map<int, int> mp;
        
        mp[0] = -1;
        
        int sum = 0;
        
        for(int i = 0; i<n; i++) {
            sum += nums[i];
            
            int remainder = sum%k;
            
            if(mp.find(remainder) != mp.end()) {
                
                if(i - mp[remainder] >= 2)
                    return true;
                
            } else {
                mp[remainder] = i;
            }
        }
        return false;
    }
};


//************************************************************ JAVA ******************************************************8//
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int n = nums.length;

       int sum = 0;

        Map<Integer, Integer> mp  = new HashMap<>();
        
        mp.put(0,-1);

      
        for(int i = 0; i < n; i++) {

            sum += nums[i];                  
           
            int remainder = sum % k;
            if(mp.containsKey(remainder))
            {
                if((i - mp.get(remainder) >= 2))
                    return true;
            }
            else mp.put(remainder, i);
        }
        return false;

    }
}
