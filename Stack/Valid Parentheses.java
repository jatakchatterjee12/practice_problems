//************************************************ JAVA **********************************************************//
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for( char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty())
                    return false;
                else{
                    char pop = st.peek();
                    if(ch==')' && pop =='(' || ch=='}' && pop=='{' || ch==']' && pop=='['){
                        st.pop();
                    }
                    else{
                        return false;
                    }
                }    
            }
        }
        return st.isEmpty();
        
    }
}



//*************************************************** C++ ********************************************************//
class Solution {
public:
    bool isValid(string s) {

        stack<char> st;

        for(char &ch : s){

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else {

                if(st.empty()){
                    return false;
                }
                else{
                    char pop = st.top();
                    if(ch == ')' && pop == '(' || ch == '}' && pop == '{' || ch == ']' && pop == '['){

                        st.pop();

                    } else {
                        return false;
                    }
                }
            }
        }

        return st.empty();
        
    }
};
