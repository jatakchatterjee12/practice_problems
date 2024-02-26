/*
      GFG Link   : https://www.geeksforgeeks.org/problems/power-set4302/1
      Company    : Snapdeal
*/

//************************************************** C++ ******************************************************//
//Approach - Take as reference
//TC - O(n * 2^n)
class Solution{
	public:
	    vector<string> ans;
	    void solve(int idx, string s, string &curr) {
	        if(idx == s.length()){
	            if(curr.length() > 0) {
	                ans.push_back(curr);
	            }
	            return;
	        }
	        
	        curr.push_back(s[idx]);
	        solve(idx+1, s, curr);
	        
	        curr.pop_back();
	        solve(idx+1, s, curr);
	    }
		vector<string> AllPossibleStrings(string s){
		    string curr = "";
		    
		   solve(0,s,curr);
		   sort(ans.begin(), ans.end());
		   return ans;
		   
		}
};

//Approach -  Take as non reference
//TC - O(n * 2^n)
class Solution{
	public:
	    vector<string> ans;
	    void solve(int idx, string s, string curr) {
	        if(idx == s.length()){
	            if(curr.length() > 0) {
	                ans.push_back(curr);
	            }
	            return;
	        }
	        
	        curr.push_back(s[idx]);
	        solve(idx+1, s, curr);
	        
	        curr.pop_back();
	        solve(idx+1, s, curr);
	    }
		vector<string> AllPossibleStrings(string s){
		    string curr = "";
		    
		   solve(0,s,"");
		   sort(ans.begin(), ans.end());
		   return ans;
		   
		}
};
//************************************************** JAVA *****************************************************//
//TC - O(n * 2^n)


//User function Template for Java

class Solution
{
    List<String> ans = new ArrayList<>();
    void solve(int idx, String s, String curr) {
        if(idx == s.length()){
            if(curr.length() > 0){
                ans.add(curr);
            }
            return;
        }
        
        curr += s.charAt(idx); // take
        solve(idx+1, s, curr);
        
        //not take
        curr = curr.substring(0,curr.length()-1); //backtrack
        solve(idx+1, s, curr);
        
    }
    public List<String> AllPossibleStrings(String s)
    {
        solve(0,s,"");
        Collections.sort(ans);
        return ans;
    }
}
