/*
    Company Tags  : Microsoft, Amazon
    Leetcode Link : https://leetcode.com/problems/word-ladder/
*/


//**************************************************************** C++ ***************************************************************//
class Solution {
public:
    void pushAdjacentWords(unordered_map<string, bool>& mp, queue<string>& que, string curr) {
        int n = curr.length();
        for(int i = 0; i<n; i++) {
            char temp = curr[i];
            //check for all letters at index i
            for(char ch = 'a'; ch<='z'; ch++) {
                curr[i] = ch;
                if(mp.find(curr) != mp.end() && mp[curr] ==  false) {//not visited
                    mp[curr] = true; //mark visited   
                    que.push(curr);
                }
            }
            curr[i] = temp;
        }
    }
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        if(wordList.size() == 0)
            return 0;
        //First add words in a map for easy access
        unordered_map<string, bool> mp;
        
        for(string& word : wordList) {
            mp[word] = false; //means this word is not visited yet
        }
        
        //The endWord should be in the list
        if(mp.find(endWord) == mp.end())
            return 0;
        
        int level = 1; //beginWord is at level 1
        
        queue<string> que;
        que.push(beginWord);
        
        //Just do a BFS traversal
        while(!que.empty()) {
            int n = que.size();
            while(n--) {
                string curr = que.front();
                que.pop();
                if(curr == endWord)
                    return level;
                pushAdjacentWords(mp, que, curr);
            }
            level++;
        }
        
        //we never found the end word
        return 0;
    }
};



//*************************************************************************** JAVA ******************************************************************88//
//Approach 1:
class Solution {
    void fillNeighbors(Queue<String> que, StringBuilder curr, Set<String> st) {

        int n = curr.length(); // n = [1,10]
        for(int i=0; i < n; i++){

            char temp = curr.charAt(i);

            for(char ch = 'a'; ch <= 'z'; ch++) {

                curr.setCharAt(i, ch);
                String currStr = curr.toString();

                if(st.contains(currStr)){
                    que.add(currStr);
                    st.remove(currStr);
                }

            }
            curr.setCharAt(i, temp);
        }

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> st = new HashSet<>();
        for(String word : wordList){
            st.add(word);
        }

        Queue<String> que = new LinkedList<>();

        que.add(beginWord);
         
        int level = 1; // beginWord is at level 1

        while(!que.isEmpty()) {

            int n = que.size();
            while(n-- > 0) {
                String curr = que.poll();

                if(curr.equals(endWord)){
                    return level;
                }

                StringBuilder currSb = new StringBuilder(curr);
                fillNeighbors(que, currSb, st);
            }
            level++;
        } 
        return 0;
    }
}


//Approach 2:

class Solution {
    class Pair{
        String  first;
        int second;
        Pair(String s,int step){
            this.first = s;
            this.second = step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        

        int len = wordList.size();

        Set<String> st = new HashSet<>();
        for(int i = 0; i < len; i++) st.add(wordList.get(i));

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);


        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if(word.equals(endWord)) return steps;

            for(int i = 0; i < word.length(); i++){

                for(char c = 'a'; c <= 'z'; c++){

                    char[] updatedWord = word.toCharArray();
                    updatedWord[i] = c;
                    String updatedWordString = new String(updatedWord);

                    if(st.contains(updatedWordString)){

                        q.add(new Pair(updatedWordString,steps+1));
                        st.remove(updatedWordString);
                    }
                }
            }
        }
        return 0;


    }
}
