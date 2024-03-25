class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res;

        for(int i = 0; i < n; i++) {

            int num = abs(nums[i]);
            int idx = num - 1;

            nums[idx] = -(abs(nums[idx]));
        }

        for(int i =0; i < n; i++) {
            if(nums[i] > 0) {
                res.push_back(i+1);
            }
        }

        return res;
    }
};
