/*
    Company                     : 
    Leetcode Link               :     https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
*/
/////////////////////////////////////////////// C++ //////////////////////////////////////////////////////////
class Solution {
public:
    int getLucky(string s, int k) {
        string  num ="";

        for(char ch : s){
            num +=to_string(ch - 'a' + 1);
        }

        int sum = 0;
        
        while(k--){
            sum =0;
            for(char ch : num){
                sum += ch -'0';
            }
            num = to_string(sum);
        }
        return sum;
    }
};
/////////////////////////////////////////////// JAVA /////////////////////////////////////////////////////////
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()) {
            int chPos = ch - 'a' + 1;
            sb.append(chPos);
        }

        int sum = 0;

        while(k-- > 0) {
            sum = 0;

            for(char ch : sb.toString().toCharArray()){
                sum += ch - '0';
            }

            sb = new StringBuilder(Integer.toString(sum));

        }

        return sum;
    }
}
