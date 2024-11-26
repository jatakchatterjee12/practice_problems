/*
    Leetcode Link      :   https://leetcode.com/problems/find-champion-i/description
*/

//Approach 1: 2 Pass 

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int champ = -1;

        for(int i = 0; i < n; i++){
            boolean isChamp  = true;

            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(grid[i][j] != 1) {
                    isChamp = false;  
                    break;  
                }
            }

            if(isChamp) champ = i;
        }

        return champ;
    }
}


// Approach 2: Single Pass

/*   Assume that team 0 is the champions and do a single loop from [0,0] to [0,n] to verify. If team j has beaten team 0, 
     then that means team j must have also beaten teams 0->j, so j is the new possible winner. We can continue our loop from 
     [j,j] to [j,n]. We can repeat this for any teams that our current possible champion team.

*/

class Solution {
    public int findChampion(int[][] grid) {
        
        int n = grid.length;

        int champ = 0;
        for(int opponent = 0; opponent < n; opponent++){

            if(champ == opponent) continue;

            if(grid[champ][opponent] != 1){ // if current champ is our winner then grid[[champ][opponent] must be 1
                champ = opponent;
            }
        }
        return champ;
    }
}
