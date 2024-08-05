/*
  Leetcode Link   :   https://leetcode.com/problems/kth-distinct-string-in-an-array/description
*/

//*************************************** C++ **************************************************************//
//Approach 2 : Using unordered_set
//TC - O(n)
//SC - O(n)
class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        unordered_set<string> st;
        unordered_set<string> unique;

        for(string &s : arr) {

            if(st.find(s) != st.end()) {
                continue;
            }

            if(unique.find(s) != unique.end()) {
                unique.erase(s);
                st.insert(s);
            }
            else{
                unique.insert(s);
            }
        }

        int count = 0;
        for(string &s :arr) {
            if(unique.find(s) != unique.end()) {
                count++;
            }
            if(count == k){
                return s;
            }
        }
        return "";
    }
};


//******************************************* JAVA *********************************************************//
//Approach 1 : Brute Force
// TC - O(n^2)
//SC - O(1)
class Solution {
    int freqOfS(String s, String[] arr){
        int count = 0;
        for(String str : arr){
            if(str.equals(s)){
                count++;
            }

            if(count > 1) return count; // return early
        }
        return count;
    }
    public String kthDistinct(String[] arr, int k) {
        
        int n = arr.length;
        int count = 0;
        for(String s : arr){
            if(freqOfS(s, arr) == 1){
                count++;

                if(count == k){
                    return s;
                }
            }
        }
        return "";
    }
}


//Approach 2: Using HashSet
// TC - O(n) 
// Sc - O(n)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        Set<String> st = new HashSet<>();
        Set<String> unique = new HashSet<>();

        for(String s :arr) {

            if(st.contains(s)){
                continue;
            }

            if(unique.contains(s)){
                unique.remove(s);
                st.add(s);
            }
            else{
                unique.add(s);
            }
        }
        int count  = 0;
        for(String s :arr) {
            if(unique.contains(s)){
                count++;

            }
            if(count == k){
                return s;
            }
        }
        return "";
    }
}


//Approach 3: Using LinkedHashMap
//TC - O(n) 
//SC - O(n)
class Solution {
    public String kthDistinct(String[] arr, int k) {
        
        LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
        for(String s : arr){
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for(String s : arr){
            if(mp.get(s) == 1){
                count++;
            }
            if(count == k){
                return s;
            }
        }
        return "";
    }
}
