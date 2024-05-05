//************************************************** C++ *******************************************************//
class Solution {
public:
    bool isValid(string s) {
        int n = s.size();
        if(n<3)
            return false;
        int v = 0, c =0 ;
        for(auto i:s) {
            if(isalpha(i)) {
                if(i=='a' || i=='e' || i=='i' || i=='o' || i=='u')
                    v++;
                else if(i=='A' || i=='E' || i=='I' || i=='O' || i=='U')
                    v++;
                else
                    c++;
            }
            if(! (isalpha(i) || isdigit(i)))
                return 0;
        }
        if(v>=1 && c>=1)
            return 1;
        return 0;
    }
};



//******************************************************** JAVA **************************************************//
public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n < 3) {
            return false;
        }

        int vowels = 0;
        int consonants = 0;

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                // Check for vowels (case-insensitive)
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (!Character.isDigit(c)) {
                return false; // Invalid character if not a letter or digit
            }
        }

        return vowels >= 1 && consonants >= 1;
    }
}
