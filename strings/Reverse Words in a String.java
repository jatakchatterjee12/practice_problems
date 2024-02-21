/*
    Company Tags                 : Amazon (With variations), Microsoft, MentorGraphics, MakeMyTrip, Accolite, Adobe, Cisco, Goldman Sachs,Paytm, 
                                   Samsung, SAP Labs
    Leetcode Link                : https://leetcode.com/problems/reverse-words-in-a-string/
*/

//Approach-1 (Perfect use of std::stringstream)
class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string token = "";

        string result = "";
        //By default stringstream tokenizes on ' ' (space character)
        //Know more : https://github.com/MAZHARMIK/Cpp-STL-Quick-Help/blob/main/README.md
        while(ss >> token) {
            result = token + " " + result;
        }

        return result.substr(0, result.length()-1);
    }
};

//Approach-2 (Two Pointer)
class Solution {
public:
    string reverseWords(string s) {
        
        int n = s.length();

        //1 : reverse the whole string
        reverse(s.begin(), s.end());

        //2 : reverse the words and clean extra spaces
        int i = 0;

        // l and r jo reverse karenge words ko
        
        int l = 0;
        int r = 0;

        while(i < n) {
            while(i < n && s[i] != ' ') { // i ko agar char dikha to r ko dega aur i++ r++
                s[r] = s[i];
                r++;
                i++;
            }

            //i ko abhi space mila to word reverse hoga
            if(l < r) {
                reverse(s.begin()+l, s.begin()+r);

                //aur r ek space le lega aur r++ hoga
                s[r] = ' ';
                r++;

                //phir l ko  r ke pash le aana hoga
                l = r;
            }

            i++; // yeh to badhta hi rahega
        }
        s = s.substr(0, r-1);
        return s;
    }
};

//*********************************************************** JAVA ***********************************************************//
//Approach : Two Pointer
class Solution {
    void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        
        int n = s.length();
        char[] arr = s.toCharArray();

        //1 : reverse the whole string
        reverse(arr, 0, n-1);

        //2: traverse and reverse the words and clean up extra space
        int i = 0;
        int l = 0;
        int r = 0;

        while(i < n) {
            while(i < n && arr[i] != ' '){ // i ko char mila to r ko dega aur i++ r++
                arr[r++] = arr[i++]; 
            }

            // i ko  space mila to abhi words reverse hoga
            if(l < r) {
                reverse(arr, l, r-1);

                // r ek space lega aur r badh jayega
                if(r < n) arr[r] = ' ';
                r++;

                // l ko r ke pash lana hoga
                l = r;
            }
            i++; // aur i to badhta rahega har bar
        }
        s = new String(arr);
        s = s.substring(0, r-1);
        return s;
    }
}
