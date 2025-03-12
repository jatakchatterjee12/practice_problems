//****************************************************** C++ *************************************************************
//Brute Force
class Solution {
public:
    int numberOfSubstrings(string s) {
        int cnt = 0;

        for(int i = 0; i < s.length(); i++) {
            int hash[3]={0};
            for(int j = i; j < s.length(); j++) {
                hash[s[j]-'a'] = 1;

                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt++;
                }
            }
        }
        return cnt;
    }
};



//Slightly optimized the Brute Force
class Solution {
public:
    int numberOfSubstrings(string s) {
        int cnt = 0;
        int n = s.length();

        for(int i = 0; i < s.length(); i++) {
            int hash[3]={0};
            for(int j = i; j < s.length(); j++) {
                hash[s[j]-'a'] = 1;

                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt += (n-j);
                    break;
                }
            }
        }
        return cnt;
    }
};


// Most Optimal : Using Sliding Window
class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.length();
        int cnt = 0;
        
        int lastSeen[3] = {-1, -1, -1};

        for(int i = 0; i  <n; i++) {

            lastSeen[s[i] - 'a'] = i;

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {

                cnt += (1 + min(lastSeen[0], min(lastSeen[1], lastSeen[2])));
            }
        }
        return cnt;

    }
};


//Approach - with every character, there is a substring taht ends. we are summing up all the substrings that ends at a certain index
// "bbacba" --> minimum window size with all three charcter ends at 'b'(index=4) is 3 and it starts at index 2 (minIndex{a,b,c})
// now adding up all the other substrings with that which ends at b(index=4) == "bacb" & "bbacb" .. so total 3 substring "acb",
//"bacb", "bbacb" 

// how to find the index where the min window with all three characters starts ? 

// min of a index, b index and c index stored in lastSeen[] array



// Without even using the condition the code will run 
// Reason : as we initialize the lastSeen[3] with all (-1), the min of those three will come as (-1) so 
// (cnt ==> 1 + (-1) ==> cnt = 0 

class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.length();
        int cnt = 0;

        int lastSeen[3] = {-1, -1, -1};

        for(int i = 0; i  < n; i++) {

            lastSeen[s[i] - 'a'] = i;

            cnt += (1 + min(lastSeen[0], min(lastSeen[1], lastSeen[2])));

        }
        return cnt;

    }
};




//**************************************************** JAVA *************************************************************//
//Approach - with every character, there is a substring taht ends. we are summing up all the substrings that ends at a certain index
// "bbacba" --> minimum window size with all three charcter ends at 'b'(index=4) is 3 and it starts at index 2 (minIndex{a,b,c})
// now adding up all the other substrings with that which ends at b(index=4) == "bacb" & "bbacb" .. so total 3 substring "acb",
//"bacb", "bbacb" 

// how to find the index where the min window with all three characters starts ? 

// min of a index, b index and c index stored in lastSeen[] array

//Most Optimal Without the condition statement
//Reason : Mentioned above 
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int cnt = 0;

        int[] lastSeen = {-1, -1, -1};

        for(int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            cnt += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
        }

        return cnt;
    }
}
