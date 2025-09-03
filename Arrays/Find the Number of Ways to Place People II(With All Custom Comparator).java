/*     
    Company Tags                : Will update later
    Leetcode Link               : https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii
    
*/


/************************************************************ C++ *****************************************************/
//Approach (Using Sorting - Approach-2 of Find the Number of Ways to Place People I in my video)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
public:
    int numberOfPairs(vector<vector<int>>& points) {
        int n = points.size();

        // Sort: x ascending, if x same then sort as y descending
        auto lambda = [](vector<int>& point1, vector<int>& point2) {
            if (point1[0] == point2[0]) {
                return point1[1] > point2[1];
            }
            return point1[0] < point2[0];
        };

        sort(points.begin(), points.end(), lambda);

        int result = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];   // upper left

            int bestY = INT_MIN;

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];   // lower right

                // Condition: (x2, y2) must be above (x1, y1)
                if (y2 > y1) { //not lower right
                    continue;
                }

                if (y2 > bestY) {
                    result++;
                    bestY = y2;
                }
            }
        }

        return result;
    }
};




/************************************************************ JAVA *****************************************************/
//Approach (Using Sorting - Approach-2 of Find the Number of Ways to Place People I in my video)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        // Sort: x ascending, if x same then sort as y descending
        Arrays.sort(points, (point1, point2) -> {
            if (point1[0] == point2[0]) {
                return point2[1] - point1[1];
            }
            return point1[0] - point2[0];
        });

        int result = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];   // upper left

            int bestY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];   // lower right

                // Condition: (x2, y2) must be above (x1, y1)
                if (y2 > y1) { //not lower right
                    continue;
                }

                if (y2 > bestY) {
                    result++;
                    bestY = y2;
                }
            }
        }

        return result;
    }
};



// WITH CUSTOM COMPARATOR
class Solution {
    public int numberOfPairs(int[][] points) {
        
        int n = points.length;
        int result  = 0;

        Arrays.sort(points, new Comparator<int[]>() {
                public int compare(int[] p1, int[] p2){
                    if(p1[0] == p2[0]){
                        return Integer.compare(p2[1], p1[1]);
                    }
                    return Integer.compare(p1[0], p2[0]);
                }
            }
        );

        for(int i = 0; i < n; i++){

            //set A, upper left
            int x1 = points[i][0];
            int y1 = points[i][1];

            //set B, lower right
            int maxY = Integer.MIN_VALUE;

            for(int j = i+1; j < n; j++){

                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y2 > y1) continue;

                if(y2 > maxY){
                    result++;
                    maxY = y2;
                }
                
            }
        }
        return result;
    }
}


// with more detailed custom comparator
class Solution {
    public int numberOfPairs(int[][] points) {
        
        int n = points.length;
        int result  = 0;

        Arrays.sort(points, new Comparator<int[]>() {
                public int compare(int[] p1, int[] p2){
                    if(p1[0] == p2[0]){
                        if(p1[1] >= p2[1])return -1;
                        return 1;
                    }
                    if(p1[0] < p2[0]){
                        return -1;
                    }
                    else return 1;
                    
                }
            }
        );

        for(int[] x : points){
            System.out.println("$" + x[0] + "_" + x[1]);
        }

        for(int i = 0; i < n; i++){

            //set A, upper left
            int x1 = points[i][0];
            int y1 = points[i][1];

            //set B, lower right
            int maxY = Integer.MIN_VALUE;

            for(int j = i+1; j < n; j++){

                int x2 = points[j][0];
                int y2 = points[j][1];

                if(y2 > y1) continue;

                if(y2 > maxY){
                    result++;
                    maxY = y2;
                }
                
            }
        }
        return result;
    }
}
