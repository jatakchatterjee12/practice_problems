/*
   gfg Qn .
   NOTE:     gives TLE in gfg after 904 test cases
*/


// APPROACH - 1 (using vector and sort it)

class Solution {
  public:
    static bool myComparator(pair<int,int> a, pair<int,int> b){
        if(a.second == b.second) return a.first < b.first;
        return a.second > b.second; // {element, frequency>
    };
    vector<vector<int>> kTop(vector<int>& arr, int N, int K) {
        
        map<int, int> mp;
        
        vector<vector<int>> res;
        
        for(int num : arr){
            if(num == 0) continue;
            mp[num]++;
            
            vector<int> curr;
            vector<pair<int,int>> vec;
            for(auto x : mp){
                vec.push_back(x);
            }
            sort(vec.begin(), vec.end(), myComparator);
            if(vec.size() < K){
                for(int i=0; i < vec.size(); i++){
                    curr.push_back(vec[i].first);
                }
            }else{
                for(int i=0; i <  K; i++){
                    curr.push_back(vec[i].first);
                }
            }
            res.push_back(curr);
        }
        
        return res;
    }
};

//APPROACH -2 : using heap
struct Compare{
    public:
       bool operator()(pair<int,int> below, pair<int,int> above){
            if(below.first == above.first) return below.second < above.second;
            return below.first > above.first; // {freq,val}
        } 
};
class Solution {
  public:
    
     
    vector<vector<int>> kTop(vector<int>& arr, int N, int K) {
        
        unordered_map<int, int> mp;
        
        vector<vector<int>> res;
        priority_queue<pair<int,int> , vector<pair<int,int>>, Compare >pq;
        
        for(int &num : arr){
            //if(num == 0) continue;
            mp[num]++;
            
            vector<int> curr;
            for(auto &x : mp){
                int val = x.first;
                int freq = x.second;
                pq.push({freq,val});
                
                if(pq.size() > K) pq.pop();
            }
            while(!pq.empty()){
                curr.push_back(pq.top().second);
                pq.pop();
            }
            reverse(curr.begin(), curr.end());
            res.push_back(curr);
        }
        
        return res;
    }
};

//**************************************************8 JAVA ****************************************************88//
// accepted in gfg
class Pair{
    int f;
    int s;
    Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        
        Map<Integer, Integer> mp = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.f == b.f) return b.s - a.s;
            return a.f - b.f;
        });
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int num  : arr){
            mp.put(num, mp.getOrDefault(num,0)+1);
            ArrayList<Integer> list = new ArrayList<>();
            
            for(Map.Entry<Integer, Integer> it : mp.entrySet()){
                int val = it.getKey();
                int frq = it.getValue();
                pq.add(new Pair(frq, val));
                
                if(pq.size() > K) pq.poll();
            }
            while(!pq.isEmpty()){
                list.add(pq.poll().s);
            }
            Collections.reverse(list);
            res.add(list);
        }
        return res;
    }
}
        
