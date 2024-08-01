/*
    Leetcode Link    :   https://leetcode.com/problems/number-of-senior-citizens/description
*/

class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0 ;
        for(String it : details) {
            
            int secondDigit = it.charAt(11) - '0';
            int firstDigit = it.charAt(12) - '0';

            int age = secondDigit*10 + firstDigit;
            if(age  > 60){
                cnt++;
            }
        }
        return cnt;
    }
}
