/*
    Company Tags                : Google, Amazon, Microsoft, Meta
    Leetcode Link               : https://leetcode.com/problems/palindrome-partitioning/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1
*/

//Whenever a question asks for "Generating all possible" something, think about Backtracking once

//******************************************** C++ *************************************************//
class Solution {
public:
    int n;
    
    bool isPalindrome(string &s, int l, int r) {
        
        while(l < r) {
            if(s[l] != s[r])
                return false;
            l++;
            r--;
        }
        
        return true;
        
    }
    
    void backtrack(string &s, int idx, vector<string> &curr, vector<vector<string>> &result) {
        
        if(idx == n) {
            result.push_back(curr);
            return;
        }
        
        
        for(int i = idx; i<n; i++) {
            
            if(isPalindrome(s, idx, i)) {
                
                curr.push_back(s.substr(idx, i-idx+1));
                
                backtrack(s, i+1, curr, result);
                
                curr.pop_back();
                
            }
            
        }
        
    }
    
    vector<vector<string>> partition(string s) {
        n = s.length();
        vector<vector<string>> result;
        vector<string> curr;
        
        backtrack(s, 0, curr, result);
        
        return result;
        
    }
};

//**************************************************** JAVA **************************************************//
class Solution {
    int n;
    boolean isPalindrome(int i, int j, String s) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    void solve(int i, String s,  List<String> temp, List<List<String>> ans) {

        if(i == n) {
            // means we reach at end and we get all palindorme substrings
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j = i; j<n; j++) {
            if(isPalindrome(i, j, s)) {
                temp.add(s.substring(i, j+1));

                solve(j+1, s, temp, ans);

                temp.remove(temp.size()-1); // backtrack

            }
        }
    }
    public List<List<String>> partition(String s) {
        n = s.length();
        List<String> temp = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        solve(0, s, temp, ans);
        return ans;
    }
}
