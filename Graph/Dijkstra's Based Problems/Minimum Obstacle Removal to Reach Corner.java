/*   
    Company Tags                : Will update soon
    Leetcode Link               : https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner
*/


/************************************************************ C++ ************************************************/
//Approach (Using Dijkstra's Algorothm - Assuming obstacle with edge weight 1 and empty with 0)
//T.C : O(m*n log(m*n))
//S.C : O(m*n)
class Solution {
public:
    #define P pair<int, pair<int, int>>
    vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    int minimumObstacles(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<int>> result(m, vector<int>(n, INT_MAX));
        //result[i][j] = minimum distance/obstacleCount between [0][0] to [i][j]
        result[0][0] = 0;

        priority_queue<P, vector<P>, greater<P>> pq;
        pq.push({0, {0, 0}}); //{wt, {i, j}}
        //O(Elog(V))
        // E = number of edges
        // V = number of vertices
        while(!pq.empty()) {
            auto curr = pq.top();
            pq.pop();

            int d = curr.first;
            int i = curr.second.first;
            int j = curr.second.second;

            for(auto &dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                if(x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }

                int wt = (grid[x][y] == 1) ? 1 : 0;

                if(d + wt < result[x][y]) {
                    result[x][y] = d + wt;
                    pq.push({d+wt, {x, y}});
                }
            }
        }

        return result[m-1][n-1];

    }
};



/************************************************************ JAVA ************************************************/
//Approach (Using Dijkstra's Algorothm - Assuming obstacle with edge weight 1 and empty with 0)
//T.C : O(m*n log(m*n))
//S.C : O(m*n)
class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        result[0][0] = 0;

        // Min-heap to store {obstacleCount, {i, j}}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});  // {obstacleCount, i, j}

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int obstacleCount = current[0];
            int i = current[1];
            int j = current[2];

            for (int[] dir : directions) {
                int x = i + dir[0];
                int y = j + dir[1];

                // Check if (x, y) is within bounds
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int wt = (grid[x][y] == 1) ? 1 : 0;

                    if (obstacleCount + wt < result[x][y]) {
                        result[x][y] = obstacleCount + wt;
                        pq.offer(new int[]{obstacleCount + wt, x, y});
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}

//Approach 2 : Using 0-1 BFS
//TC - O(E+V)
class Solution {

    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];
        for(int[] row : result){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        result[0][0] = 0;

        //PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Deque<int[]> deq = new ArrayDeque<>();

        deq.add(new int[]{0, 0, 0}); // wt, i, j

        while(!deq.isEmpty()){

            int[] curr = deq.pollFirst();

            int d = curr[0];
            int i = curr[1];
            int j = curr[2];

            for(int[] dir : dirs){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || result[new_i][new_j] != Integer.MAX_VALUE){
                    continue;
                }

                if(grid[new_i][new_j] == 1){
                    //obstacle --> push it to last
                    deq.addLast(new int[] {d+1, new_i, new_j});
                    result[new_i][new_j] = d+1;
                }
                else{
                    // bo obsatcle --> push it to front
                    deq.addFirst(new int[] {d, new_i, new_j});
                    result[new_i][new_j] = d;
                }
            }
        }

        return result[m-1][n-1];
    }
}
