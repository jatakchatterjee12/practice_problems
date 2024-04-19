//**************************************************** JAVA **************************************************************//
//Approach : BFS

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];

        Queue<int[]> que  = new LinkedList<>();
        int[][] result  = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    que.add(new int[] {i, j, 0});
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }


        while(!que.isEmpty()) {

            int[] it = que.poll();
            int row = it[0];
            int col = it[1];
            int steps = it[2];

            result[row][col] = steps;

            int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            for(int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col  + dir[1];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0) {
                    que.add(new int[]{nrow, ncol, steps+1});
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return result;
    }
}


//********************************************************* C++ *************************************************************//
//Approach : BFS
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {

        int n = mat.size();
        int m = mat[0].size();
        vector<vector<int>> vis(n,vector<int> (m,0));
        vector<vector<int>> dist(n,vector<int> (m,0));
        queue<pair<pair<int,int> , int>> que;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(mat[i][j] == 0){

                    vis[i][j] = 1;
                    que.push({{i,j}, 0});
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }

        int directions[4][2] = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!que.empty()){
            int row = que.front().first.first;
            int col = que.front().first.second;
            int steps  =que.front().second;
            que.pop();

            dist[row][col] = steps;

            for(auto dir:directions){
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0){
                    
                    que.push({{nrow,ncol}, steps+1});
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dist;
        
    }
};
