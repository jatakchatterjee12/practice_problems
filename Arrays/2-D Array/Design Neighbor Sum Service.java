/*
    Leetcode Link     :     https://leetcode.com/problems/design-neighbor-sum-service/description/
*/

//*********************************************************** JAVA *******************************************//
class neighborSum {
    private int[][] grid;
    private int n;

    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
    }
    
    public int adjacentSum(int value) {
        int[] position = solve(value);
        int sum = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        
        for(int[] dir : dirs){
            int x = position[0] + dir[0];
            int y = position[1] + dir[1];
            if(isValid(x,y)){
                sum += grid[x][y];
            }
        }
        return sum;
    }
    
    public int diagonalSum(int value) {
        int[] pos = solve(value);
        int sum =0;
        int[][] dirs = {{-1,1}, {-1,-1}, {1,1}, {1, -1}};
        for(int[] dir : dirs){
            int x = pos[0] + dir[0];
            int y = pos[1] + dir[1];
            if(isValid(x,y)){
                sum += grid[x][y];
            }
        }
        return sum;
    }
    
    private int[] solve(int value){
        for(int i = 0; i  < n; i++) {
            for(int j = 0 ; j  < n; j++) {
                if(grid[i][j] == value){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    
    private boolean isValid(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n ;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
