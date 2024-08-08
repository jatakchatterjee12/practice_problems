/*
    Company Tags                : Paytm, Zoho, Morgan Stanley, Accolite, Amazon, Microsoft, Snapdeal, D-E-Shaw, MakeMyTrip, Oracle, MAQ Software, nearbuy, Nagarro, BrowserStack
    Frequency                   : 64%
    Leetcode Qn Link            : https://leetcode.com/problems/spiral-matrix-ii/
*/

//************************************************************ C++ *************************************************//
//TC : O(n^2)
//SC : O(1) excluding the result matrix
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {

        int dir = 0;
        int item = 1;

        vector<vector<int>> matrix(n, vector<int>(n,0));

        int top = 0;
        int down = n-1;

        int left = 0;
        int right = n-1;

        /*
            dir = 0 : left to right 
            dir = 1 : top to bottom
            dir = 2 : right to left;
            dir = 3 : bottom to top
        */

        vector<int> result;

        while(top <= down && left <= right) {

            if(dir == 0) {
                // left to right
                // constant : top

                for(int i = left; i <= right; i++) {
                    matrix[top][i] = item++;
                }
                top++;
            }

            if(dir == 1) {
                // top to bottom
                //constant : right

                for(int i = top; i <= down; i++) {
                    matrix[i][right] = item++;
                } 
                right--;
            }

            if(dir == 2) {
                // right to left;
                //constant : down

                for(int i = right ; i>= left; i--){
                    matrix[down][i] = item++;
                }
                down--;
            }

            if(dir == 3) {
                //bottom to top
                //constant : left
                for(int i = down; i >= top; i--) {
                    matrix[i][left] = item++;
                }
                left++;
            }

            dir++;

            if(dir == 4) dir = 0; // id = (id+1)%4;
        }
        return matrix;
    
    }
};


//***************************************************** JAVA *******************************************************//
//TC : O(n^2)
//SC : O(1) excluding the result matrix
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int item = 1;

        int top = 0;
        int down = n-1;
        int left = 0;
        int right  = n-1;

        int dir = 0;
         /** dir == 0 -> left to right
             dir == 1 -> top to bottom
             dir == 2 -> right to left
             dir == 3 -> bottom to top 
          */

        while(top <= down && left <= right) {
            if(dir == 0) {
                //left to right
                //top constant
                
                for(int i = left; i <= right; i++){
                    matrix[top][i] = item++;
                }
                top++;
            }

            if(dir == 1){
                //top to bottom
                //right constant

                for(int i = top; i <= down; i++){
                    matrix[i][right] = item++;
                }
                right--;
            }

            if(dir == 2){
                //right to left
                //down constant

                for(int i = right; i>= left; i--){
                    matrix[down][i] = item++;
                }
                down--;
            }

            if(dir == 3){
                //bottom to top
                // left constant
                for(int i= down; i >= top; i--){
                    matrix[i][left] = item++;
                }
                left++;
            }

            dir = (dir+1)%4;
        }  
        return matrix;
    }
}
