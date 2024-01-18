class Solution {
    int m,n;
    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    void dfs(char[][] board, int i, int j){
        if(i < 0 || i == m || j < 0 || j == n || board[i][j] != 'X') return;

        board[i][j] = '$'; // chaning 'X' to any dummy char
        for(int[] dir : dirs){
            int x = dir[0];
            int y = dir[1];
            dfs(board, i+x, j+y);
        }
    }
    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int battleships = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(board[i][j] == 'X'){
                    battleships++;
                    dfs(board, i, j);
                }
            }
        }
        return battleships;
    }
}
