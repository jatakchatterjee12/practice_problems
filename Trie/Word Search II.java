/*
    Company Tags                : Google, Amazon, Facebook (Meta), Microsoft, Salesforce, Directi, MakeMyTrip, Nvidia, Yahoo
    Leetcode Qn Link            : https://leetcode.com/problems/word-search-ii/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/72cf44eabd18006810efad06fbb623a0682acee2/1   
*/

//*************************************************** C++ ***********************************************************//
class Solution {
public:
    vector<string> result;
    int m, n;

    struct trieNode{
        bool endOfWord;
        string word;
        trieNode* children[26];
    };

    trieNode* getNode() {
        trieNode* newNode = new trieNode();
        newNode->endOfWord = false;
        newNode->word = "";

        for(int i = 0; i < 26; i++) {
            newNode->children[i] = NULL;
        }
        return newNode;
    }
    
   

    void insert(trieNode* root, string word) {

        trieNode* crawler = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word[i] - 'a';
            if(crawler->children[idx] == NULL) {
                crawler->children[idx] = getNode();
            }
            crawler = crawler->children[idx];
        }

        crawler->endOfWord = true;
        crawler->word = word;
    }

    vector<vector<int>> directions{{1,0},{-1,0},{0,1}, {0,-1}};

    void find(vector<vector<char>>& board, int i, int j, trieNode* root) {

        if( i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if(board[i][j] == '$' || root->children[board[i][j] - 'a'] == NULL){
            return;
        }


        root = root->children[board[i][j]-'a'];
        if(root->endOfWord == true){
            result.push_back(root->word);
            root->endOfWord = false;
        }

        char temp = board[i][j];
        board[i][j] = '$'; // marked visited

        for(vector<int> & dir : directions) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            find(board, new_i, new_j, root);
        }

        board[i][j] = temp; // backtrack, marking unvisited

    }

    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        m = board.size();
        n = board[0].size();

         trieNode* root = getNode(); 

        //insert words 
        for(string &word : words){
            insert(root, word);
        }

        for(int i= 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                char ch = board[i][j];

                if(root->children[ch-'a'] != NULL) {
                    find(board, i, j, root);
                }
            }
        }
        return result;
    }
};



//*************************************************** JAVA ***********************************************************//
class Solution {
    List<String> result = new ArrayList<>();
    int m, n;


    class TrieNode {
        boolean endOfWord;
        String word;
        TrieNode[] children;

        TrieNode() {
            endOfWord = false;
            word = "";
            children = new TrieNode[26];
        }
    }

    void insert(TrieNode root, String word) {

        TrieNode crawler = root;
        for(int i = 0; i < word.length(); i++) {
            int idx  = word.charAt(i) - 'a';
            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.endOfWord = true;
        crawler.word = word;
    }

    int[][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};

    void find(char[][] board, int i, int j, TrieNode root) {

        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if(board[i][j] == '$' || root.children[board[i][j] - 'a'] == null){
            return;
        }

        root = root.children[board[i][j] -'a'];

        if(root.endOfWord == true) {
            result.add(root.word);
            root.endOfWord = false;
        }

        char temp = board[i][j];
        
        board[i][j] = '$'; // mark visited

        for(int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            find(board, new_i, new_j, root);

        }

        board[i][j] = temp;

    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;

        TrieNode root = new TrieNode();

        //inserting each word to TRIE 
        for(String word : words) {
            insert(root, word);
        } 

        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {

                char ch = board[i][j];

                if(root.children[ch-'a'] != null){
                    find(board, i, j, root);
                }
            }
        }
        return result;


    }
}
