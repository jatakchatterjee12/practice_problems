/*   
    Company Tags                : Will update soon
    Leetcode Link               : https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings
*/


/************************************************************ C++ ************************************************/
//Approach (Using simple backtracking)
//T.C : O(n*2^n)
//S.C : O(n)
class Solution {
public:

    void solve(string& s, int idx, unordered_set<string>& st, int currCount, int& maxCount) {
        if(currCount + (s.length() - idx) <= maxCount) { //Pruning for slight improvement
            return;
        }

        if(idx == s.length()) {
            maxCount = max(maxCount, currCount);
        }

        for(int j = idx; j < s.length(); j++) {
            string sub = s.substr(idx, j-idx+1);
            if(st.find(sub) == st.end()) {
                st.insert(sub);
                solve(s, j+1, st, currCount+1, maxCount);
                st.erase(sub);
            }
        }
    }

    int maxUniqueSplit(string s) {
        unordered_set<string> st;
        int maxCount  = 0;
        int currCount = 0;
        solve(s, 0, st, currCount, maxCount);

        return maxCount;
    }
};




/************************************************************ JAVA ************************************************/
//Approach (Using simple backtracking)
//T.C : O(n*2^n)
//S.C : O(n)
class Solution {

    void solve(int i, String s, Set<String> st, int[] maxCount, int currCount, int n){

        if(i >= n){
            maxCount[0] = Math.max(maxCount[0], currCount);
            return;
        }

        //prunning for slight improvement
        if(currCount + (n - i) <= maxCount[0]){
            return;
        }

        for(int j = i; j < n; j++){

            String sub = s.substring(i, j+1);
            if(!st.contains(sub)){
                st.add(sub); // Do
                solve(j+1, s, st, maxCount, currCount+1, n); //EXPLORE
                st.remove(sub); //UNDO
            }
        }
    }
    public int maxUniqueSplit(String s) {
        
        int n = s.length();
        Set<String> st = new HashSet<>();
        int[] maxCount = new int[1]; // pass it by reference
        int currCount = 0;
        int i = 0;

        solve(i, s, st, maxCount, currCount, n);

        return maxCount[0];
    }
}
