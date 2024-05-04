// LeetCode Link   :    https://leetcode.com/problems/right-triangles/

class Solution {
public:
    long long numberOfRightTriangles(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<int> row_one_counts(m,0);
        vector<int> col_one_counts(n, 0);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1){
                    row_one_counts[i]++;
                    col_one_counts[j]++;
                }
            }
        }

        long long triangles = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {

                    triangles += (row_one_counts[i] - 1) * (col_one_counts[j] - 1);
                }
            }
        }

        return triangles;
    }
};
