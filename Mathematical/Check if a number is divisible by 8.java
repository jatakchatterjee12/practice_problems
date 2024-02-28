/*
    GFG LINK    :   https://www.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-83957/1
*/
//Approach : The last 3 digit number should be divisble by 8 (like 4 -->> last 2 digit number for 4)
class Solution{
    int DivisibleByEight(String s){
        
        int n = s.length();
        
        if(n < 3) {
            while(n < 3) {
                s = '0' + s;
                n++;
            }
        }
        
        int number = 0;
        for(int i = n-3; i < n; i++) {
            number = number * 10 + (s.charAt(i) - '0');
        }
        
        if(number % 8 == 0) return 1;
        return -1;
    }
}
