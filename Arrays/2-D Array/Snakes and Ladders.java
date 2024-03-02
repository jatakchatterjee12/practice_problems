/*
      Company Tags                : Zoho, Flipkart, Amazon, Microsoft, OYO Rooms, MAQ Software, Adobe, Nutanix, Belzabar
      Leetcode Link               : https://leetcode.com/problems/snakes-and-ladders/
*/
//************************************************ C++ *******************************************************
class Solution {
public:
    int n;
    
    pair<int, int> getCoord(int s) {
        int row = n-1-(s-1)/n;
        
        int col = (s-1)%n;
        
        if((n%2==1 && row%2==1)||(n%2==0 && row%2==0))
            col = n-1-col;
        
        return make_pair(row, col);
    }
    
    int snakesAndLadders(vector<vector<int>>& board) {
        n = board.size();
        
        int steps = 0;
        queue<int> que;
        
        vector<vector<bool>> visited(n, vector<bool>(n, false));
        visited[n-1][0] = true;
        
        que.push(1);
        vector<bool> seen(n*n+1,false);
        
        
        while(!que.empty()) {
            
            int N = que.size();
            while(N--) {
            
                int x = que.front();
                que.pop();

                if(x == n*n)
                    return steps;

                for(int k = 1; k<=6; k++) {
                    if(x+k > n*n)
                        break;

                    pair<int, int> coord = getCoord(x+k);
                    int r = coord.first;
                    int c = coord.second;
                    if(visited[r][c] == true)
                        continue;

                    visited[r][c] = true;
                    if(board[r][c] == -1)
                        que.push(k+x);
                    else {
                        que.push(board[r][c]);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
};
//***************************************************** JAVA ********************************************************
class Solution {
    int n;
    int[] getCoord(int num) {
        int rowFromTop = (num-1)/n;
        int rowfromBottom = (n-1) -  rowFromTop;

        int col = (num-1)%n;
        if((n%2==1 && rowfromBottom%2==1) || (n%2==0 && rowfromBottom%2==0)) {
            col = (n-1) - (num-1)%n;
        }
        return new int[] {rowfromBottom, col};
    }
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();

        visited[n-1][0] = true;
        q.add(1);

        int steps = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int x = q.poll();

                if(x == n*n) return steps;

                for(int k = 1; k <= 6; k++) {
                    int val = x + k;
                    if(val > n*n) break;

                    int[] coord = getCoord(val);
                    int r = coord[0];
                    int c = coord[1];
                    
                   
                    if(visited[r][c] == true) continue;
                    

                    visited[r][c] = true;
                    
                    if(board[r][c] == -1){
                        q.add(val);
                    }
                    else{
                        q.add(board[r][c]);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
