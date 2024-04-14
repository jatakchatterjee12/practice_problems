//*********************************************** C++ **************************************************************//
class Solution {
public:
    string findLatestTime(string s) {
        
        for(int i = 0; i < 5; i++) {

            if(i == 0 && s[i] == '?'){
                s[i] = (s[1] == '1' || s[1] == '0' || s[1] == '?')? '1' : '0';
            }
            else if(i == 1 && s[i] == '?'){
                s[i] = (s[0] == '0') ? '9' : '1';
            }
            else if(i == 3  && s[i] == '?'){
                s[i] = '5';
            }
            else if(i==4 && s[i] == '?'){
                s[i] = '9';
            }
        }
        return s;
    }
};




//************************************************* JAVA *****************************************************************//
class Solution {
    public String findLatestTime(String s) {
        StringBuilder nm=new StringBuilder();
        if(s.charAt(0) == '?' && s.charAt(1) == '?')
        {
            nm.append("11");
        }
        else if(s.charAt(0) != '?' && s.charAt(1) == '?')
        {
            nm.append(s.charAt(0));
            if(s.charAt(0) == '1')
            {
                nm.append("1");
            }
            else
            {
                nm.append("9");
            }
        }
        else if(s.charAt(0) == '?' && s.charAt(1) != '?')
        {
            if(s.charAt(1) >= '2' && s.charAt(1) <= '9')
            {
                nm.append("0");
            }
            else
            {
                nm.append("1");
            }
            nm.append(s.charAt(1));
        }
        else
        {
            nm.append(s.charAt(0));
            nm.append(s.charAt(1));
        }
        nm.append(":");
        if(s.charAt(3) == '?' && s.charAt(4) == '?')
        {
            nm.append("59");
        }
        else if(s.charAt(3) != '?' && s.charAt(4) == '?')
        {
            nm.append(s.charAt(3));
            nm.append("9");
        }
        else if(s.charAt(3) == '?' && s.charAt(4) != '?')
        {
            nm.append("5");
            nm.append(s.charAt(4));
        }
        else
        {
            nm.append(s.charAt(3));
            nm.append(s.charAt(4));
        }
        return nm.toString();
    }
}
