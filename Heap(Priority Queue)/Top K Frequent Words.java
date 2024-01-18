class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();

        for(String word : words){
            mp.put(word, mp.getOrDefault(word,0) + 1);
        }
        // min heap .. jiska freq kam woh pehle pop hoga..freq equal hua to jo lexicographical bada hoga woh upar ayega(pehle pop hoga) 
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a,b)-> 
        a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : 
        a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry : mp.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            result.add(0, pq.poll().getKey());
        }
        return result;
    }
}

/***************************************** C++ ***************************************/
#define psi pair<int, string>
class myComparator{
    public:
        bool operator() (const psi &p1 , const psi &p2) {
            if(p1.first == p2.first) return p1.second < p2.second;
            return p1.first > p2.first; 
        }
};
class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        int n = words.size();

        unordered_map<string, int> mp;
        for(string word : words){
            mp[word]++;
        }
        priority_queue<psi, vector<psi> , myComparator> pq;

        for(auto it : mp){
            pq.push({it.second, it.first});

            if(pq.size() > k){
                pq.pop();
            }
        }

        vector<string> res(k);
        int p = k-1;

        while(pq.size() > 0){
            res[p--] = pq.top().second;
            pq.pop();
        } 
        return res;
    }
};
