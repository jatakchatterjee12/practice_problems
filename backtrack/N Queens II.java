// Same as N Queens .. Here we return the count of unique solution instead of returning the actual solution (List<String>)
// Also we dont need to make the board here ..simply call the dfs

class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if (n == 0)
            return 0;

        int startRow = 0;
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diags = new HashSet<>();
        HashSet<Integer> antiDiags = new HashSet<>();
        solve(n, startRow, cols, diags, antiDiags);

        return count;
    }

    private void solve(int n, int row, HashSet<Integer> cols, HashSet<Integer> diags, HashSet<Integer> antiDiags) {
        if (row == n) {
            count++;
            return;
        }

        /*
         * For a square (i, j) : Diagonally (i-j) is constant Anti diagonally (i+j) is
         * constant
         * 
         * We can use this to find which square (i, j) has a risk of being attacked
         * by another queen placed already in 'diagonal', or 'anti-diagonal' or
         * 'column'
         */

        for (int col = 0; col < n; col++) {
            int diagId = row - col;
            int antiDiagId = row + col;

            /*
             * If the col, or diagonal or anti_diagonal are used means one of them has a
             * Queen placed already which can attack, so look for other column
             */
            if (cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId))
                continue;

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);
            

            solve(n, row + 1, cols, diags, antiDiags);

            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            
        }
    }
}
