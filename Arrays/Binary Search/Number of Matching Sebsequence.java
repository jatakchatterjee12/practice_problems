/*
    Company Tags : Google
    Leecode Link : https://leetcode.com/problems/number-of-matching-subsequences/
    
    //Other approach (using hash map) : Link : 
*/

//////////////////////////////////////////////////// C++ ////////////////////////////////////////////////////////////////

//Time : O(s.length() * log(n))
class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        map<char, vector<int>> mp;
        int n = s.length();
        
        for(int i = 0; i<n; i++) {
            mp[s[i]].push_back(i);
        }

        int count = 0;
        for(string &word : words) {
            int prev      = -1;
            bool found = true;

            for(char &ch : word) {
                if(mp.find(ch) == mp.end()) {
                    found = false;
                    break;
                }

                auto it = upper_bound(begin(mp[ch]), end(mp[ch]), prev); //Binary Search (O(log(n))
                
                if(it == mp[ch].end()) {
                    found = false;
                    break;
                }

                prev = *it;
            }
            if(found)
                count++;
        }
        return count;
    }
};

////////////////////////////////////////////// JAVA /////////////////////////////////////////////////////////
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            mp.computeIfAbsent(ch, k-> new ArrayList<>()).add(i);
        }

        int cnt  = 0;

        for(String word : words){

            int prev=-1;
            boolean found = true;

            for(char c : word.toCharArray()){
                if(!mp.containsKey(c)) {
                    found = false;
                    break;
                }

                List<Integer> indices = mp.get(c);

                int idx = Collections.binarySearch(indices, prev+1);

                if(idx < 0){
                    idx = -idx - 1;
                }

                if(idx == indices.size()){
                    found = false;
                    break;
                }

                prev = indices.get(idx);

            }
            if(found == true){
                cnt++;
            }
        }
        return cnt;
    }
}
