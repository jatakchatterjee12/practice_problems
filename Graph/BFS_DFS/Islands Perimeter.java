//Approach 1 : (find out total 1s)*4  - (repeating 1s those are connected)*2
//why multiply with 2 : when we consider 2 blocks separately , total edges will be -- 2*4 = 8
// if those 2 blocks connected then the common edge will be eleminated , and total edges that will be counted is --  6 (8 - 2)
// 

public class Solution {
    public int islandPerimeter(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0, neighbours = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                  
                    islands++; // count islands //number of 1s
                    if (i < m-1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours // connected 1s
                    if (j < n-1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours //    "
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}


// Approach 2 : count the edges that adjacent to water
class Solution {
    public int islandPerimeter(int[][] grid) {
        
        //idea is to count the number of edges that adjacent to the water

        int m = grid.length;
        int n = grid[0].length;

        int peri = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1){

                    if(i == 0 || grid[i-1][j] == 0) peri++; // up
                    if(j == 0 || grid[i][j-1] == 0) peri++; // left
                    if(i == m-1 || grid[i+1][j] == 0) peri++; // down
                    if(j == n-1 || grid[i][j+1] == 0) peri++; // right
                }
            }
        }
        return peri;
    }
}
