/*
    Youtube  VIDEO ON THIS Qn   :  https://www.youtube.com/watch?v=GLw4WbJdYLw
    Company Tags                :  Amazon, Accolite
    Leetcode Qn Link            :  https://leetcode.com/problems/top-k-frequent-elements/
*/
// ***************************************************** C++ ******************************************//
//Approach-1 (Using min-heap) - TC : O(nlog(n-k))
class Solution {
public:
    typedef pair<int, int> p;
    
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        //min-heap
        priority_queue<p, vector<p>, greater<p>> pq;
        
        //count frequency of each element
        // Worst Case - n distinct elements are stored, so, space O(n)
        unordered_map<int, int> mp;
        for(int i : nums)
            mp[i]++;
        
        //Push in min-heap and maintain size k
        for(auto it:mp) {
            int val = it.first;
            int freq = it.second;
            pq.push({freq, val});
            
            if(pq.size() > k)
                pq.pop();
        }
        
        
        //Pick all top K elements
        vector<int> result;
        while(!pq.empty()) {
            result.push_back(pq.top().second);
            pq.pop();
        }
        return result;
    }
};


//Approach-2 (Using Bucket Sort) - TC : O(n) - We visit all elements of nums only once.
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        int n = nums.size();
        
        unordered_map<int, int> mp;
        
        for(int &num : nums) {
            mp[num]++;
        }
        
        //index = frequency
        //Value will be elements
        //bucket[i] = elements occuring ith time
        vector<vector<int>> bucket(n+1);
        
        for(auto &it : mp) {
            int element = it.first;
            int freq    = it.second;
            
            bucket[freq].push_back(element);
        }
        
        //Pick from right to left to find max frequency elements
        vector<int> result;
        for(int i = n; i >= 0; i--) {
            
            if(bucket[i].size() == 0) continue;
            
            int size = bucket.size();
            while(bucket[i].size() > 0 && k > 0) {
                result.push_back(bucket[i].back());
                bucket[i].pop_back();
                k--;
            }
            
        }
        
        return result;
    }
};

// ******************************************************* JAVA ***************************************//
//Approach-1 (Using min-heap) - TC : O(nlog(n-k))
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }
            else {
                map.put(i,1);
            }
        }

        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey()); // min_heap in order of freq

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            
            int value = entry.getKey();
            int freq = entry.getValue();

            pq.add(new Pair<>(freq,value));

            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){

            list.add(pq.poll().getValue());
        }

        int size = list.size();
        int[] result = new int[size];
        int i = 0;
        for(int it: list){
            result[i++] = it;
        }

        return result;
        
    }
}
//Approach-2 (Using Bucket Sort) - TC : O(n) - We visit all elements of nums only once.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        List<Integer>[]  bucket = new List[n+1];
        for(int i=0; i<=n; i++){
            bucket[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> it : mp.entrySet()){
            int val = it.getKey();
            int freq = it.getValue();
            bucket[freq].add(val);
        }

        int[] result= new int[k];
        int m=0;

        for(int i=n; i>=0; i--){
            if(bucket[i].size() == 0) continue;

            while(bucket[i].size() > 0 && k > 0){
                result[m++] = bucket[i].get(0);
                bucket[i].remove(0);
                k--;
            }
        }
        return result;
    }
}
