
// TC - O(nlogk)
// SC - O(n)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int i=0; i<n; i++){
            pq.add(new int[]{nums[i], i});

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<Integer> indices_list = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            indices_list.add(top[1]);
        }

        Collections.sort(indices_list);
        int[] res = new int[k];

        int p=0;

        for(int it : indices_list){
            res[p++] = nums[it];
        }
        return res;


    }
}

// Instead of taking a list for storing the indices taking a set and then traverse the nums array to find the right indices
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        for(int i=0; i<n; i++){
            pq.add(new int[]{nums[i], i});

            if(pq.size() > k){
                pq.poll();
            }
        }

        Set<Integer> indices = new HashSet<>();
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            indices.add(top[1]);
        }

        int[] res = new int[k];
        int p=0;

        for(int i=0; i<n; i++){
            if(indices.contains(i)){
                res[p] = nums[i];
                p++;
            }
        }
        return res;
    }
}
/******************************************************* C++ ***********************************************************************/
class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        int n = nums.size();
        priority_queue<pair<int,int>, vector<pair<int,int>> , greater<pair<int,int>>> pq; // min heap

        for(int i=0;i<n;i++){
            pq.push({nums[i], i});
            if(pq.size() > k){
                pq.pop();
            }
        }

        set<int> st;
        while(!pq.empty()){
            auto [element, index] = pq.top();
            pq.pop();

            st.insert(index);
        }
        

        vector<int> result;
        for(int i=0;i<n;i++){

            if(st.find(i) != st.end()){
                result.push_back(nums[i]);
            }
        }
        return result;
    }
};
