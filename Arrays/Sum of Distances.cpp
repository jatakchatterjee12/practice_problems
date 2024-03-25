class Solution {
public:
    vector<long long> distance(vector<int>& nums) 
    {
        int n = nums.size();
        vector<long long>ans(n);
        unordered_map<int, vector<int>>mp;
        for (int i = 0; i < n; i++) mp[nums[i]].push_back(i);
        for (auto it : mp)
        {
            int num = it.first;
            vector<int>& indexes = it.second;
            //======================================================
            long long totalSum = 0;
            for (int index : indexes) totalSum += (long long)index;
            
            long long preSum = 0;
            for (int i = 0; i < indexes.size(); i++)
            {
                int index = indexes[i];
                long long postSum = totalSum - preSum - index;
                
                ans[index] += (index * (long long)i);
                ans[index] -= (preSum);
                ans[index] -= (index * (long long)(indexes.size() - i - 1));
                ans[index] += (postSum);
                
                preSum += index;
            }
            //======================================================
        }
        return ans;
        
        
    }
};


//************************************************************* JAVA *******************************************************//
class Solution {
    public long[] distance(int[] nums) {
        
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            mp.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);

        }

        for(Map.Entry<Integer, List<Integer>> it : mp.entrySet()) {

            int num = it.getKey();
            List<Integer> indices = it.getValue();

            long totSum = 0;
            for(int index : indices) totSum += (long)index;

            long preSum = 0;

            for(int i = 0; i < indices.size(); i++) {

                int currIndex = indices.get(i);
                long postSum = totSum - preSum - currIndex;

                ans[currIndex] += (currIndex * (long)i);
                ans[currIndex] -= preSum;

                ans[currIndex] += postSum;
                ans[currIndex] -= (currIndex * (long)(indices.size() - i - 1));

                preSum += currIndex; 
            }

        }
        return ans;
    }
}
