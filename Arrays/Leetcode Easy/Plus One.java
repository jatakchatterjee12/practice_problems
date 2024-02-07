/*
    Leetcode Link         :  https://leetcode.com/problems/plus-one/description/
*/

//************************************** C++ *********************************//
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int n = digits.size();

        for(int i=n-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0; /// if digits[i] == 9
        }

        vector<int> newNum(n+1,0);
        newNum[0] = 1;

        return newNum;
    }
};


//************************************** JAVA ********************************//
class Solution {
    public int[] plusOne(int[] digits) {
        
        int n = digits.length;
        for(int i = n-1; i >= 0; i--){
            if(digits[i] < 9) {
               digits[i]++;
               return digits;
            }
            digits[i] = 0; // digits[i] == 9
        }
       int[] newNum = new int[n+1];
       newNum[0] = 1; // all others are zero ex - 1000 for given 999

       return newNum;
    }
}
