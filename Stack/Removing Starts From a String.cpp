
/*
    Company Tags                : MICROSOFT
    Leetcode Link               : https://leetcode.com/problems/removing-stars-from-a-string/
*/

//***************************************************** C++  ***************************************************//
//Approach-1 (Using Stack)
class Solution {
public:
    string removeStars(string s) {
        stack<char> st;
        
        for(char &ch : s) {
            
            if(ch == '*') {
                st.pop();
            } else {
                st.push(ch);
            }
            
        }
        
        string result = "";
        
        while(!st.empty()) {
            result.push_back(st.top());
            st.pop();
        }
        
        reverse(begin(result), end(result));
        return result;
    }
};

//Approach-2 (using string as stack)
class Solution {
public:
    string removeStars(string s) {
        string result = "";
        
        for(char &ch : s) {
            
            if(ch == '*') {
                result.pop_back();
            } else {
                result.push_back(ch);
            }
            
        }
        
        return result;
    }
};

//Approach-3 (Using Two pointers)
class Solution {
public:
    string removeStars(string s) {
        vector<char> ch(s.size());
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '*') {
                j--;
            } else {
                ch[j++] = s[i];
            }
        }

        string result = "";
        for (int i = 0; i < j; i++) {
            result.push_back(ch[i]);
        }

        return result;
    }
};


//********************************************** JAVA ******************************************************//
//Approach-1 (Using Stack)
class Solution {
    public String removeStars(String s) {
        
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {

            if(ch == '*') {
                if(!st.isEmpty() ){
                    st.pop();
                }
            }
            else{
                st.push(ch);
            }
        }

        String ans = "";
        while(!st.isEmpty()) {
            ans = st.pop() + ansclass Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        char[] temp = new char[n];

        int j = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '*') {
                j--;
            }
            else{
                temp[j] = s.charAt(i);
                j++;
            }
        }

        String res = "";
        for(int k = 0; k <= j-1; k++) {
            res += temp[k];
        }
        return res;
    }
};
        }

        return ans;
    }
}

//Approach-2 (Using char arr)

