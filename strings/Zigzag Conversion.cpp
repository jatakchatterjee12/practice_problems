//********************************** C++ *************************************//
class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        string res = "";
        int n = s.length();

        for(int row = 0; row < numRows; row++){
            int increment = 2 *(numRows-1);
            for(int i = row; i < n; i += increment){
                res += s[i];         // for first and last row

                if(row > 0 && row < numRows - 1 && (i + increment) - (2*row) < n){     // for middle rows
                    res += s[(i + increment) - (2*row)];
                }
            }
        }
        return res;
    }
};

//********************************** JAVA **********************************//
