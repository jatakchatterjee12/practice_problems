class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> que = new LinkedList<>();
        que.add(entrance);

        //mark entrance visited
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        int[][] dirs = {{-1,0}, {0,1}, {1, 0}, {0, -1}};

        while(!que.isEmpty()) {

            steps++;

            int size = que.size();

            while(size-- > 0) {

                int[] curr = que.poll();

                int r = curr[0];
                int c = curr[1];

                

                for(int[] dir : dirs) {
                    int r_ = r + dir[0];
                    int c_ = c + dir[1];

                    if(r_ < 0 || r_ >= m || c_ < 0 || c_ >= n || maze[r_][c_] == '+' ) continue;

                    if(r_ == 0 || c_ == 0 || r_ == m-1 || c_ == n-1) return steps;

                    maze[r_][c_] = '+';
                    que.add(new int[]{r_, c_});

                }
            }
            
        }
        return -1;

    }
}
