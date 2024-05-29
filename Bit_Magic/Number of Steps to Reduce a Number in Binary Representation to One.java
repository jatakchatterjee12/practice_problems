/*    Both C++ and Java Code are Here    */
/*
    
    Company Tags                : will soon update
    Leetcode Link               : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
*/


/************************************************************************** C++ ********************************************************/
//Approach-1 (Simple simulation - Do what is beinhg asked)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
public:
    void addOne(string &s) {
        int i = s.length()-1;

        while(i >= 0 && s[i] != '0') {
            s[i] = '0';
            i--;
        }

        if(i < 0) {
            s = '1' + s;
        } else {
            s[i] = '1';
        }
    }

    int numSteps(string s) {
        int op = 0;

        while(s.length() > 1) {
            int n = s.length();

            if(s[n-1] == '0') {
                s.pop_back();
            } else {
                addOne(s);
            }

            op++;
        }

        return op;
    }
};


//Approach-2 (Simply calculating for odd and even)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int numSteps(string s) {
        int n = s.length();

        int op = 0;
        int carry = 0;

        for(int i = n-1; i >= 1; i--) {
            if(((s[i] - '0') + carry) % 2 == 1) { //odd
                op += 2;
                carry = 1;
            } else {
                op += 1;
            }
        }

        return op + carry;
    }
};


/************************************************************************** JAVA ********************************************************/
//Approach-1 (Simple simulation - Do what is beinhg asked)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    void addOne(StringBuilder sb) {
        int i = sb.length() - 1;

        while(i >= 0 && sb.charAt(i) != '0') {
            sb.setCharAt(i, '0');
            i--;
        }

        if(i < 0){
            sb.insert(0, '1');
        }
        else{
            sb.setCharAt(i, '1') ;
        }
    }
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int op = 0;

        while(sb.length() > 1) {

            int n = sb.length();

            if(sb.charAt(n-1) == '0'){ //even---> divide by 2 ---> so pop back right most bit
                sb.deleteCharAt(n-1);
            }
            else{                     // odd ---> add 1 ---> right to left mein pehla 0 tak saare bit flip honge
                addOne(sb);
            }
            op++;
        }
        return op;
    }
}




//Approach-2 (Simply calculating for odd and even)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int numSteps(String s) {
        int n = s.length();

       int op = 0;
       int carry = 0;

        for(int i = n-1; i >= 1; i--) {

            if(((s.charAt(i) - '0') + carry) % 2 == 1 ){ // odd
            
                op += 2;
                carry = 1;
            }
            else{ // even
                op += 1;
            }            
        }
        return op + carry;

    }
    
}
