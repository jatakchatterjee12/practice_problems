/*
    Company Tags                : Amazon, Facebook, Microsoft, Twitter, Apple, Google, Paypal, Bloomberg, Adobe, InfoEdge
    Leetcode Link               : https://leetcode.com/problems/integer-to-roman/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/convert-to-roman-no/1
    
*/

class Solution {
    public String intToRoman(int num) {

        String M[] = {"", "M", "MM", "MMM"}; // 0, 1000, 2000, 3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 0, 100, 200, 300, 400, 500, 600, 700, 800, 900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 0, 10, 20, 30, 40, 50, 60, 70, 80 ,90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
