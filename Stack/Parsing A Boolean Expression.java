/*   
    Company Tags                : will update later
    Leetcode Link               : https://leetcode.com/problems/parsing-a-boolean-expression
*/


/********************************************************************** C++ **********************************************************************/
//Approach (Using stack)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    char solveOp(char op, vector<char>& values) {
        if (op == '!') 
            return values[0] == 't' ? 'f' : 't';
    
        if (op == '&') 
            return any_of(values.begin(), values.end(), [](char ch) { return ch == 'f'; }) ? 'f' : 't';
    
        if (op == '|') 
            return any_of(values.begin(), values.end(), [](char ch) { return ch == 't'; }) ? 't' : 'f';
    
        return 't'; // Unreachable
    }

    bool parseBoolExpr(string s) {
        int n = s.size();
        stack<char> st;
        for (int i = 0; i < n; i++) {
            if (s[i] == ',') continue;

            if (s[i] == ')') {
                vector<char> values;
                // Gather all values inside the parentheses
                while (st.top() != '(') {
                    values.push_back(st.top());
                    st.pop();
                }
                st.pop();  // Remove '('
                char op = st.top();
                st.pop();  // Remove the operator
                st.push(solveOp(op, values));
            } else {
                st.push(s[i]);
            }
        }
        return (st.top() == 't');
    }
};



/********************************************************************** C++ **********************************************************************/
//Approach (Using stack)
//T.C : O(n)
//S.C : O(n)
class Solution {
    private char solveOp(char op, List<Character> values) {
        if (op == '!') 
            return values.get(0) == 't' ? 'f' : 't';

        if (op == '&') 
            return values.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';

        if (op == '|') 
            return values.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';

        return 't'; // Unreachable
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        int n = expression.length();
        
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ',') continue;

            if (c == ')') {
                List<Character> values = new ArrayList<>();
                // Gather all values inside the parentheses
                while (stack.peek() != '(') {
                    values.add(stack.pop());
                }
                stack.pop();  // Remove '('
                char op = stack.pop();  // Get the operator
                stack.push(solveOp(op, values));  // Push the result back
            } else {
                stack.push(c);  // Push the character onto the stack
            }
        }
        return stack.peek() == 't';
    }
}




//////////////////////////////
class Solution {
    private char solve(List<Character> vals, char op){

        if(op == '!'){
            return vals.get(0) == 't' ? 'f' : 't';
        }

        if(op == '&'){
            for(int i = 0; i < vals.size(); i++){
                if(vals.get(i) == 'f'){
                    return 'f';
                }
            }
            return 't';
        }

        if(op == '|'){
            for(int i = 0; i < vals.size(); i++){
                if(vals.get(i) == 't'){
                    return 't';
                }
            }
            return 'f';

        }

        return 't'; // never reaches here
    }

    public boolean parseBoolExpr(String s) {
        
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++){

            if(s.charAt(i) == ','){
                continue;
            }
            else if(s.charAt(i) == ')'){
                List<Character> vals = new ArrayList<>();

                while(st.peek() != '('){
                    vals.add(st.pop());
                }

                st.pop(); // popping out the '(' char

                char operator = st.pop(); // there is always a operator before a brackets starts

                st.push(solve(vals, operator));
            }
            else{
                st.push(s.charAt(i));
            }
        }

        return st.peek() == 't'? true : false;
    }
}
