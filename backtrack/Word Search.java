/*
    Company Tags                : Apple, Amazon, Microsoft, Intuit
    Leetcode Link               : https://leetcode.com/problems/word-search/
*/

//********************************************** C++ ***************************************************//
class Solution {
public:
    int l, m, n;
    vector<vector<int>> directions{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    bool find(vector<vector<char>>& board, int i, int j, string &word, int idx) {
        if(idx >= l)
            return true;
        
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word[idx])
            return false;
        
        char temp = board[i][j];
        board[i][j] = '$';
        
        for(auto& dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            
            if(find(board, i_, j_, word, idx+1))
                return true;
        }
        
        board[i][j] = temp;
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        l = word.length();
        if(m*n < l)
            return false;
        
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(board[i][j] == word[0] && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
};

//************************************************** JAVA ********************************************//
class Solution {
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    boolean find(char[][] board, int i, int j, int idx, String word, int m, int n){
        if(idx == word.length()) return true;

        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$')
            return false;

        if(board[i][j] != word.charAt(idx)) 
            return false;

        char temp = board[i][j];
        board[i][j] = '$'; //mark visited

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if(find(board, new_i, new_j, idx+1, word, m, n) == true) {
                return true;
            }
        }

        board[i][j] = temp; // backtrack;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){

                if(board[i][j] == word.charAt(0) && find(board, i, j, 0, word, m, n) == true )
                    return true;
            }
        }
        return false;
    }
}
