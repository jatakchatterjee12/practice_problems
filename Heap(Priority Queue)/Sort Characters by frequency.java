/*
    Company Tags                             : Amazon, Google, Oracle, Zoho, Zycus
    Leetcode Link                            : https://leetcode.com/problems/sort-characters-by-frequency/
*/

//***************************************** C++ *****************************************************//
//Approach-1 (Using Simple vector of pair and sorting it -  O(nlogn)
class Solution {
public:
    typedef pair<char, int> P;
    
    string frequencySort(string s) {
        vector<P> vec(123);
        
        for(char &ch : s) {
            int freq = vec[ch].second;
            vec[ch] = {ch, freq+1};
        }
        
        auto comp = [&](P &p1, P &p2) {
            return p1.second > p2.second;
        };
        
        sort(begin(vec), end(vec), comp);
        
        string result = "";
        
        for(int i = 0; i <= 122; i++) {
            result += string(vec[i].second, vec[i].first);
        }
        return result;
    }
};



//Approach-2 (Using Priority Queue) - O(nlong)
class Solution {
public:
    typedef pair<char, int> P;
    struct comp {
        bool operator()(P &p1, P &p2) {
            return p1.second<p2.second; //max-heap
        }
    };
    
    string frequencySort(string s) {
        priority_queue<P, vector<P>, comp> pq;
        
        unordered_map<char, int> mp;
        for(char &ch : s) {
            mp[ch]++;
        }
        
        for(auto &it : mp) {
            pq.push({it.first, it.second});
        }
        
        string result = "";
        
        while(!pq.empty()) {
            P temp = pq.top();
            pq.pop();
            
            result += string(temp.second, temp.first);
        }
        return result;
    }
};

// Without comparator -> directly pushing {freq, char} to the pq and make a max heap;
// max-heap heapify in order of freq as freq is the first one to go in the pair
class Solution {
public:
    typedef pair<int, char> P;

    string frequencySort(string s) {
        priority_queue<P> pq; // max-heap
        
        unordered_map<char, int> mp;
        for(char &ch : s) {
            mp[ch]++;
        }
        
        for(auto &it : mp) {
            pq.push({it.second, it.first}); // {freq, char}
        }
        
        string result = "";
        
        while(!pq.empty()) {
            P temp = pq.top();
            pq.pop();
            
            result += string(temp.first, temp.second);
        }
        return result;
    }
};



//*********************************************** JAVA ************************************************//
//Approach-1 (Using Bucket Sort) - TC-O(n)
class Solution { 
    public String frequencySort(String s) {
        // Using Bucket Sort
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()){
            mp.put(ch, mp.getOrDefault(ch,0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for(char key : mp.keySet()){
            int freq = mp.get(key);

            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char ch : bucket[i]){
                    for(int times = 0; times < i; times++){
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}

//Approach-2 (Using Priority Queue) - O(nlong)
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // max-heap frequency wise
        pq.addAll(map.entrySet());
				
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) 
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
