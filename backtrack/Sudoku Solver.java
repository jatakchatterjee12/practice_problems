/*
    Company Tags  : Uber, Snapchat, Microsoft, Qualcomm
    Frequency     : 66%
    Leetcode Link : https://leetcode.com/problems/sudoku-solver/
*/

//************************************************* JAVA ************************************************************//
class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){

                if(board[i][j] == '.'){ // empty cell found

                    for(char ch = '1' ; ch <= '9'; ch++){
                        if(isValid(board,i,j,ch)){
                            board[i][j] = ch;

                            if(solve(board) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.'; // backtrack
                            }
                        }
                    }
                    return false; //after trying 1 to 9 no valid path found ie return false
                }
            }
        }
        return true; // returning true as no '.' found(solved every empty cells)
    }

    boolean isValid(char[][] board, int row, int col, char ch){
        for(int i=0; i<9; i++){

            if(board[row][i] == ch) return false; // check row
            if(board[i][col] == ch) return false; // check col

            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == ch) return false; //check 3x3 sub
        }
        return true;
    }
}


////////////////////
//Approach (Khandani Backtracking template and all possible options)
//T.C : O(1), fixed frid size
//S.C : O(1), fixed grid size
class Solution {
    
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d;

                            if (solve(board)) {
                                return true;
                            }

                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // sudoku solved
    }

    private boolean isValid(char[][] board, int row, int col, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == d) return false; // check column
            if (board[row][i] == d) return false; // check row
        }

          //validate current box
        /*
            If you want to get the start index ([start_i][start_j] i.e. top left) of a box
            given i and j
            start_i = i/3 * 3;
            start_j = j/3 * 3;
            
            Now, you can check current box
        */

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[startRow + k][startCol + l] == d) {
                    return false; // check 3x3 box
                }
            }
        }

        return true;
    }
}

//******************************************* C++ ******************************************************//
class Solution {
public:
    
    bool isValid(vector<vector<char>>& board, int i, int j, char& ch) {
        //validate current row
        for(int col = 0; col<9; col++) {
            if(board[i][col] == ch) return false;
        }
        
        //validate current column
        for(int row = 0; row<9; row++) {
            if(board[row][j] == ch) return false;
        }
        
        //validate current box
        /*
            If you want to get the start index ([start_i][start_j] i.e. top left) of a box
            given i and j
            start_i = i/3 * 3;
            start_j = j/3 * 3;
            
            Now, you can check current box
        */
        
        int start_i = i/3 * 3;
        int start_j = j/3 * 3;
        for(int k = 0; k<3; k++) {
            for(int l = 0; l<3; l++) {
                if(board[start_i + k][start_j + l] == ch) return false;
            }
        }
        
        
        return true;
    }
    
    bool backtrack(vector<vector<char>>& board, int i, int j) { // solve
        //all rows checked
        if(i == 9)
            return true;
        
        //current row over, go to next row starting from 0th column
        if(j == 9)
            return backtrack(board, i+1, 0);
        
        //if it's filled go for next column
        if(board[i][j] != '.')
            return backtrack(board, i, j+1);
        
        //else try putting '1' to '9' and see if you find the result in any
        for(char ch = '1'; ch<='9'; ch++) {
            if(isValid(board, i, j, ch)) {
                board[i][j] = ch;
                if(backtrack(board, i, j+1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    
    void solveSudoku(vector<vector<char>>& board) {
        backtrack(board, 0, 0);
    }
};
