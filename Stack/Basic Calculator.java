/*
    Company Tags                : Google, Facebook, Airbnb
    Frequency                   : 66% (As per 2021)
    Leetcode Link               : https://leetcode.com/problems/basic-calculator/
*/

//******************************************** C++ ***************************************************************//
class Solution {
public:
    int calculate(string s) {
        stack<int> st;
        int number = 0;
        int result = 0;
        int sign   = 1;
        
        for(int i = 0; i<s.length(); i++) {
            if(isdigit(s[i])) {
                number  = 10*number + (s[i] - '0');
            } else if(s[i] == '+') {
                result += sign*number;
                number  = 0;
                sign = 1; //For further
            } else if(s[i] == '-') {
                result += sign*number;
                number  = 0;
                sign = -1; //For further
            } else if(s[i] == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if(s[i] == ')') {
                result += sign*number;
                number = 0;
                int top = st.top(); st.pop();
                result *= top;
                top = st.top(); st.pop();
                result += top;
            }
        }
        result += (sign*number);
        return result;
    }
};

//*************************************** JAVA **************************************************//
class Solution {
    public int calculate(String s) {
        
        char[] charAr = s.toCharArray();
        int n = charAr.length;

        Stack<Integer> st = new Stack<>();

        int number = 0;
        int result = 0;
        int sign = 1;

        for(int i=0; i<n; i++) {

            if(isDigit(charAr[i])) {
                number = number*10 + (charAr[i] - '0');
            }
            else if(charAr[i] == '+'){
                //number ban chuka hai
                // result mein add karo
                result += (number * sign);
                number = 0;
                sign = 1;
            }
            else if(charAr[i] == '-'){
                //number ban chuka hai
                // result mein add karo
                result += (number * sign);
                number = 0;
                sign = -1;
            }
            else if(charAr[i] == '(') {
                st.push(result);
                st.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            }
            else if(charAr[i] == ')'){
                result += (number * sign); // bracket ke andar ka solve ho gya
                number = 0;

                int stack_sign = st.pop();
                int last_result = st.pop();

                result = result * stack_sign;
                result = result + last_result;

            }
        }
        result = result + (number * sign);

        return result;

    }
    boolean isDigit(char ch) {
        return (ch == '0'|| ch == '1' || ch == '2' || ch == '3' || ch == '4' || ch == '5' || ch == '6'
                || ch == '7' || ch == '8' || ch == '9');
    }
}
