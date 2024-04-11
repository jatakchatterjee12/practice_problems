/*      
    Company Tags  : Snapchat, Microsoft, Google, Meta
    Leetcode Link : https://leetcode.com/problems/remove-k-digits/
*/


/********************************************************************* C++ ***********************************************************/
//Using simple Monotonic Nature of Numbers
//T.C : O(n)
//S.C : O(1) - I am ignoring the space taken for result variable
class Solution {
public:
    string removeKdigits(string num, int k) {
        
        string result = ""; //it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            
            while(result.length() > 0 && result.back() > num[i] && k > 0) {
                result.pop_back();
                k--;
            }
            
            if(result.length() > 0 || num[i] != '0') {
                result.push_back(num[i]); //to avoid the case when we have preceeding zeros
            }
            
        }
        
        
        while(result.length() > 0 && k > 0) {
            result.pop_back();
            k--;
        }

        if(result == "") {
            return "0";
        }
        
        return result;
        
    }
};


/////////////////////////          Using Stack
class Solution {
public:
    string removeKdigits(string num, int k) {

        int n = num.length();
        if(k == n) return "0";
        
        stack<char> st;

        for(char &ch : num) {

            while(!st.empty() && st.top() > ch && k > 0){
                st.pop();
                k--;
            }

            if(!st.empty() || ch != '0'){
                st.push(ch); // to avoid the case when we have preceeding zeros
            }
        }

        //"12345" k = 3
        while(!st.empty() && k>0){
            st.pop();
            k--;
        }

        if(st.empty()){
            return "0";
        }

        string res = "";
        while(!st.empty()){
            res.push_back(st.top());
            st.pop();
        }

        reverse(res.begin(), res.end());
        return res;


    }
};


/************************************************************** JAVA ***************************************************/
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(); // it will act like a stack
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            while(result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            
            if(result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); // to avoid the case when we have preceding zeros
            }
        }

        // // "12345" all increasing
        while(result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

         //if result becomes empty
        if(result.length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}


//////////////////////////////   Using Stack 
class Solution {
    public String removeKdigits(String num, int k) {
        
        int n = num.length();
        if(k == n) return "0";

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            } 

            if(!st.isEmpty() || num.charAt(i) != '0'){
                st.push(num.charAt(i));
            }
        }

        // "12345" all increasing
        while(!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }

        //if sb becomes empty
        if(st.isEmpty()){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}



