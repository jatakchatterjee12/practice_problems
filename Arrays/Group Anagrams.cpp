/*
  Company Tags                : Amazon(mutiple times), Google, Uber, Facebook, Bloomberg, Yahoo, Goldman Sachs, Microsoft, Apple, Walmart Labs, 
                                Twilio, Affirm
  Leetcode Link               : https://leetcode.com/problems/group-anagrams/
  GfG Link                    : https://practice.geeksforgeeks.org/problems/print-anagrams-together/1
*/

/************************************************************** C++ **************************************************************/
//Approach-1 (Using Sorting)
//T.C : O(n*klog(k))  (n = size of input, k = maximum length of a string in the input vector)
//S.C : O(n*k)
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        
        for(auto str:strs) {
            string temp = str;
            sort(temp.begin(), temp.end());
            mp[temp].push_back(str);
        }
        
        vector<vector<string>> result;
        for(auto it : mp) {
            result.push_back(it.second);
        }
        
        return result;
    }
};


//Approach-2
//T.C : O(n*k)  (n = size of input, k = maximum length of a string in the input vector)
//S.C : O(n*k)
class Solution {
public:
    
    string generate(string &s) {
        int count[26] = {0};
        
        for(char &ch : s) {
            count[ch-'a']++;
        }
        
        string new_s;
        
        for(int i = 0; i<26; i++) {
            
            if(count[i] > 0) {
                new_s += string(count[i], i+'a');
            }
        }
        
        return new_s;
    }
    
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;
        
        for(string &s : strs) {
            string new_s = generate(s);
            
            mp[new_s].push_back(s);
        }
        
        vector<vector<string>> result;
        for(auto &it : mp) {
            result.push_back(std::move(it.second));
        }
        
        return result;
        
    }
};

//******************************************************* JAVA ***********************************************************************************//
//Approach-1 (Using Sorting)
//T.C : O(n*klog(k))  (n = size of input, k = maximum length of a string in the input vector)
//S.C : O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

//Approach-2
//T.C : O(n*k)  (n = size of input, k = maximum length of a string in the input vector)
//S.C : O(n*k)
class Solution {
    String generate(String word){
        int arr[] = new int[26];

        for(char ch : word.toCharArray()){
            arr[ch - 'a']++;
        }

        String new_word = "";
        for(int i=0;i<26;i++){
            int freq = arr[i];

            if(freq > 0){
                while(freq > 0){
                    new_word += (i+'a');
                    freq--;
                }
                
            }
        }
        return new_word;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        
        int n = strs.length;

        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            String temp = strs[i];

            String tempStr = generate(temp);

            if(!mp.containsKey(tempStr)){
                mp.put(tempStr, new ArrayList<>());
            }
            
            mp.get(tempStr).add(temp);
        
        }

        for(List<String> it : mp.values()){
            
            res.add(it);
        }
        return res;
    }
}
