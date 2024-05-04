/*
    Company Tags                : Amazon, Google(with some variation)
    Leetcode Link               : https://leetcode.com/problems/break-a-palindrome/
*/


//****************************************************** C++ *********************************************//
class Solution {
public:
    string breakPalindrome(string pal) {
        int n = pal.length();
        if(n == 1) return "";
        
        for(int i = 0; i<n/2; i++) {
            if(pal[i] != 'a') {
                pal[i] = 'a';
                return pal;
            }
        }
        
        pal[n-1] = 'b';
        return pal;
    }
};


//************************************************ JAVA **************************************//
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        char[] s = palindrome.toCharArray();

        if(n == 1) return "";

        for(int i = 0; i < n/2; i++){
            if(s[i] != 'a'){
                s[i] = 'a';
                return new String(s);
            }
        }

        s[n-1] = 'b';
        return new String(s);
    }
}
