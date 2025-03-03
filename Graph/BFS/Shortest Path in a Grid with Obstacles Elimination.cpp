/*
   
    Company Tags               : Google
    Leetcode Link              : https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
*/

//**************************************************** C++ ***********************************************************//

//Approach-1 - BFS
class Solution {
public:
    vector<vector<int>> directions{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int shortestPath(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        
        queue<vector<int>> que;
        
        int i = 0, j = 0;
        que.push({i, j, k});
        
        bool visited[41][41][1601];
        //vector<vector<vector<bool>>> visited(m, vector<vector<bool>>(n, vector<bool>(k)));
        memset(visited, false, sizeof(visited));
        
        int steps = 0;
        while(!que.empty()) {
            int size = que.size();
            while(size--) {
                vector<int> temp = que.front();
                que.pop();
                int curr_i   = temp[0];
                int curr_j   = temp[1];
                int obs = temp[2];
                
                if(curr_i == m-1 && curr_j == n-1)
                    return steps;
                
                for(vector<int> &dir : directions) {
                    
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];
                    
                    if(new_i < 0 || new_i >= m || new_j < 0 || new_j >= n)
                        continue;
                    
                    if(grid[new_i][new_j] == 0 && !visited[new_i][new_j][obs]) {
                        que.push({new_i, new_j, obs});
                        visited[new_i][new_j][obs] = true;
                    } else if(grid[new_i][new_j] == 1 && obs > 0 && !visited[new_i][new_j][obs-1]) {
                        que.push({new_i, new_j, obs-1});
                        visited[new_i][new_j][obs-1] = true;
                    }
                }
                
            }
            steps++;
        }
        
        return -1;
    }
};


//Approach-2 - BFS : (little simplified)
class Solution {
public:
    vector<vector<int>> dirs{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    int shortestPath(vector<vector<int>>& grid, int k) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> obs(m, vector<int>(n, INT_MAX));
        
        queue<vector<int>> que;
        que.push({0, 0, 0});
        
        obs[0][0] = 0; //Number of obstacles faced till this index (i, j)
        
        int steps = 0;
        while(!que.empty()) {
            int N = que.size();
            
            while(N--) {
                auto curr = que.front(); que.pop();
                int x = curr[0];
                int y = curr[1];
                
                if(x == m-1 && y == n-1) return steps;
                
                for(auto &dir : dirs) {
                    int new_x = x + dir[0];
                    int new_y = y + dir[1];
                    
                    if(new_x >= 0 && new_x < m && new_y >= 0 && new_y < n) {
                        int currObstacle = curr[2] + grid[new_x][new_y];
                        if(currObstacle >= obs[new_x][new_y] || currObstacle > k) continue;
                        
                        obs[new_x][new_y] = currObstacle;
                        que.push({new_x, new_y, currObstacle});
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
};


//***************************************************** JAVA ***************************************************//
class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();

        int i = 0;
        int j = 0;

        que.add(new int[] {0,0,k}); // starting point

        boolean[][][] visited = new boolean[41][41][1601]; // visited karne ke liye.{i,j,k}

        int steps = 0;

        while(!que.isEmpty()) {
            int size = que.size();

            while(size-- > 0){
                int[] temp = que.poll();

                int curr_i = temp[0];
                int curr_j = temp[1];
                int curr_k = temp[2];

                if(curr_i == m-1 && curr_j == n-1){ // reached the target
                    return steps;
                }

                for(int[] dir :dirs){
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if(new_i >= m || new_i < 0 || new_j >= n || new_j < 0){
                        continue;
                    }

                    if(grid[new_i][new_j] == 0 && !visited[new_i][new_j][curr_k]){ // no obstacles path, obstacles count remains same
                        que.add(new int[]{new_i, new_j, curr_k});
                        visited[new_i][new_j][curr_k] = true;
                    }
                    else if(grid[new_i][new_j] == 1 && curr_k > 0 && !visited[new_i][new_j][curr_k-1]) { // obstacle path, can only go if we have obstacle count > 0
                        que.add(new int[]{ new_i, new_j, curr_k-1});
                        visited[new_i][new_j][curr_k-1] = true;
                    }
                }

                
            }

            steps++;
        }

        return -1;

    }
}
