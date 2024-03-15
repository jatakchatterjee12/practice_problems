//**************************************** C++ **********************************************//
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<int>> vis(n, vector<int> (m, 0));
        queue<pair<int, pair<int, int>> > q; // i , j, time

        int cntFresh = 0;

        for(int i= 0; i < n; i++) {
            for(int j= 0; j < m; j++) {

                if(grid[i][j] == 2){
                    q.push({i, {j, 0}});
                    vis[i][j] = 2;
                }
                else{
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int time = 0;
        int cnt = 0;

        int dirs[4][2] = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        while(!q.empty()) {
            auto pop = q.front();
            q.pop();

            int r = pop.first;
            int c = pop.second.first;
            int t = pop.second.second;

            time = max(t, time);

            for(auto dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >=0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == 1){
                    q.push({nr, {nc,t+1}});
                    vis[nr][nc] = 2;
                    cnt++;
                }
            } 
        }

        return cnt == cntFresh ? time : -1;


    }
};

//***************************************************** JAVA *************************************************8//
class Solution {
    public int orangesRotting(int[][] grid) {

       int n = grid.length;
       int m = grid[0].length;
       
       Queue<int[]> que = new LinkedList<>();
       int[][] vis = new int[n][m];
       int cntFresh = 0;
       
       for(int i = 0; i <n; i++){
           
           for(int j= 0; j <m; j++){
               
               if(grid[i][j] == 2){
                   que.offer(new int[]{i,j,0});
                   vis[i][j] = 2;
               }
               else{
                   vis[i][j] = 0;
               }
               if(grid[i][j] == 1)
                    cntFresh++;
           }
       }
       
       int tm = 0;
       int cnt = 0;
       int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
       
       while(!que.isEmpty()){
           
           int[] node = que.poll();
           int r = node[0];
           int c = node[1];
           int t = node[2];
           
           tm = Math.max(t,tm);
           
           for(int[] dir :directions){
               
               int nr = r + dir[0];
               int nc = c + dir[1];
               
               if(nr >= 0 && nr <n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                   
                   que.offer(new int[] {nr,nc,t+1});
                   vis[nr][nc] = 2;
                   cnt++;
               }
           }
           
         
       }
        if(cnt != cntFresh) return -1;
        return tm;
        
    }
}
