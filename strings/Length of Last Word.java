//***************************************** C++ ************************************************//
class Solution {
public:
    int lengthOfLastWord(string s) {
        int n = s.length();

        int i = n-1;
        int len = 0;
        while(i >= 0 && s[i] == ' '){
            i--;
        }
        while(i >= 0 && s[i] != ' '){
            len++;
            i--;        
        }
        return len;
    }
};
//**************************************** JAVA ************************************************//
class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();

        int i = n-1;
        int len = 0;
        while(i >= 0 && s.charAt(i) == ' '){
            i--;
        }
        while(i >= 0 && s.charAt(i) != ' '){
            len++;
            i--;        
        }
        return len;
    }
}
