/*  
    Company Tags                : UBER
    Leetcode Link               : https://leetcode.com/problems/replace-words
*/


/*************************************************************************** C++ ******************************************************************************************/
//Using Trie
//T.C : o(n*l + m*l) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l + m*l)
class Solution {
public:
    struct trieNode { 
        trieNode *children[26]; 
        bool isEndOfWord; 
    };
    
    trieNode* getNode() {
        trieNode* newNode = new trieNode();
        newNode->isEndOfWord = false;
        
        for (int i = 0; i < 26; i++) {
			newNode->children[i] = NULL;
		}
        
        return newNode;
    }

            
    trieNode* root;

    /** Inserts a word into the trie. */
    void insert(string word) {
        trieNode *crawler = root; 
        
        for (int i = 0; i < word.length(); i++) { 
            int index = word[i] - 'a'; 
            if (!crawler->children[index]) 
                crawler->children[index] = getNode();
            
            crawler = crawler->children[index]; 
        }
        
        crawler->isEndOfWord = true; 
    }
    
    /** Returns if the word is in the trie. */
    string search(string word) {
        trieNode *crawler = root; 
        
        for (int i = 0; i < word.length(); i++) { 
            int index = word[i] - 'a'; 
            if (!crawler->children[index]) 
                return word; 
            crawler = crawler->children[index];
            if(crawler->isEndOfWord) {
                return word.substr(0, i+1);
            }
        }
        return word;
    }

    string replaceWords(vector<string>& dictionary, string sentence) {

        stringstream ss(sentence);
        string word;
        string result;
        root = getNode();
        for (string word : dictionary) {
            insert(word);
        }

        while(getline(ss, word, ' ')) {
            result += search(word) + " ";
        }

        result.pop_back();
        return result;
    }
};



/*************************************************************************** JAVA ******************************************************************************************/
//Using Trie
//T.C : o(n*l + m*l) , n = number of words in the dictionary, m be the number of words in the sentence, and l be the average length of each word.
//S.C : O(n*l + m*l)
class Solution {
    class trieNode{
        trieNode[] children;
        boolean isEnd;

        trieNode() {
            isEnd = false;
            children = new trieNode[26];
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }

        
    }
    private trieNode root;

    void insert(String word) {
        trieNode crawler = root;

        for(int i = 0; i < word.length(); i++) {

            int idx = word.charAt(i) - 'a';
            if(crawler.children[idx] == null) {
                crawler.children[idx] = new trieNode();
            }

            crawler = crawler.children[idx];
        }
        crawler.isEnd = true;
    }

    String search(String word) {
        trieNode crawler = root;

        for(int i = 0;i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(crawler.children[idx] == null) {
                return word;
            }
            crawler = crawler.children[idx];
            if(crawler.isEnd == true){
                return word.substring(0, i+1); // shortest root  of word
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new trieNode();
        for(String word : dictionary) {
            insert(word);
        }

        String[] sentArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for(String word : sentArr) {
            sb.append(search(word)).append(" ");
        }

        return sb.toString().trim();
    }
}
