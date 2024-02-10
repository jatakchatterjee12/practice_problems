/*
    Company Tags  : Amazon, Accolite, Microsoft
    Leetcode Link : https://leetcode.com/problems/palindromic-substrings/
*/

//*************************************************** C++ **********************************************************//

//Approach-1 (DP)
class Solution {
public:
    int t[1001][1001];
    int countSubstrings(string s) {
        int cnt=0;
        memset(t, -1, sizeof t);

        int n = s.length();

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                cnt += solve(s,i,j);
            }
        }
        return cnt;
    }
    int solve(string &s, int i,int j){
        if(i >= j)
            return 1;

        if(t[i][j] != -1)return t[i][j];    

        return t[i][j] = s[i] == s[j] ? solve(s,i+1,j-1) : 0;   
    }
};

//Approach-2 : Expand Around Possible Centers (Fastest solution)
class Solution {
public:
    int count = 0;
    void check(string s, int i, int j) {
        while(i >=0 && j < s.length() && s[i] == s[j]) {
            count++;
            i--; //expanding from center   <---i  j--->
            j++; //expanding from center
        }
    }
    int countSubstrings(string s) {
        int n = s.length();
        count = 0;
        
        /*
            Every single character in the string is a center for possible odd-length palindromes: check(s, i, i);
            Every pair of consecutive characters in the string is a center for possible even-length palindromes: check(s, i, i+1);.
        */
        for(int i = 0; i<n; i++) {
            check(s, i, i);
            check(s, i, i+1);
        }
        return count;
    }
};

//************************************************* JAVA *********************************************************//

// Approach 1: DP
class Solution {
    private int[][] t;
    private int solve(String s, int i, int j){
         
        if(i >= j) return 1;

        if(t[i][j] != -1) return t[i][j];

        if(s.charAt(i) == s.charAt(j)){
            return t[i][j] = solve(s, i+1, j-1);
        }
        return t[i][j] = 0;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        t = new int[n+1][n+1];
        for(int[] row : t){
            Arrays.fill(row, -1);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){

                cnt += solve(s, i, j);
            }
        }
        return cnt;
    }
}

//Approach 2:  Expand Around Possible Centers (Fastest solution)
class Solution {
    int count =1;
    public int countSubstrings(String s) {
        if(s.length()==0) 
            return 0;
        for(int i=0; i<s.length()-1; i++){
            checkPalindrome(s,i,i);     //To check the palindrome of odd length palindromic sub-string
            checkPalindrome(s,i,i+1);   //To check the palindrome of even length palindromic sub-string
        }
        return count;
    }    

    private void checkPalindrome(String s, int i, int j) {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){    //Check for the palindrome string 
            count++;    //Increment the count if palindromin substring found
            i--;    //To trace string in left direction
            j++;    //To trace string in right direction
        }
    }
}
