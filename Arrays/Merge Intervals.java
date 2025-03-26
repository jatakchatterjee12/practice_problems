/*
    Company Tags     : Amazon, Google, Nutanix
    Leetcode Qn Link : https://leetcode.com/problems/merge-intervals/
*/
//*********************************************** C++ ************************************************//
//Approach-1 (Brute Force) O(n^2) : TLE on Leetcode (1 test case gives TLE)
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int i = 0;
        while(i < intervals.size()-1) {
            int i_start = intervals[i][0];
            int i_end  = intervals[i][1];
            bool merge = false;
            for(int j = i+1; j<intervals.size(); j++) {

                int j_start = intervals[j][0];
                int j_end  = intervals[j][1];

                if(!(i_end < j_start || i_start > j_end)) {
                    //overlap. Merge them
                    intervals[i][0] = min(i_start, j_start);
                    intervals[i][1] = max(i_end, j_end);
                    //erase j
                    intervals.erase(intervals.begin()+j);
                    merge = true;
                    break;
                }

            }        
            if(!merge) {
                i++;
            }
        }
        return intervals;
    }
};
//Approach 2 : TC - nlogn + O(n)
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n = intervals.size();
        vector<vector<int>> result;

        if(n == 0) return result;

        sort(intervals.begin(), intervals.end());

        vector<int> prev_pair = intervals[0];
        
        for(auto it : intervals){
            int curr_start = it[0];
            int curr_end = it[1];

            if(curr_start <= prev_pair[1]){
                prev_pair[1] = max(prev_pair[1], curr_end);
            }
            else{
                result.push_back(prev_pair);
                prev_pair = it;
            }
        }
        result.push_back(prev_pair);
        return result;
    }
};


//************************************************ JAVA *******************************************//
// Approach-1 (Brute Force)
// T.C : O(n^2)
// S.C : O(1)
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int i = 0;
        while (i < intervals.length - 1) {
            int i_start = intervals[i][0];
            int i_end = intervals[i][1];
            boolean merge = false;
            
            for (int j = i + 1; j < intervals.length; j++) {
                int j_start = intervals[j][0];
                int j_end = intervals[j][1];
                
                if (!(i_end < j_start || i_start > j_end)) {
                    // Overlap. Merge them
                    intervals[i][0] = Math.min(i_start, j_start);
                    intervals[i][1] = Math.max(i_end, j_end);
                    
                    // Erase j by shifting elements
                    for (int k = j; k < intervals.length - 1; k++) {
                        intervals[k] = intervals[k + 1];
                    }
                    
                    intervals = Arrays.copyOf(intervals, intervals.length - 1);
                    merge = true;
                    break;
                }
            }
            
            if (!merge) {
                i++;
            }
        }
        return intervals;
    }
}


// Approach-2 (Using Sorting)
// T.C : O(n log n)
// S.C : O(n)
class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort based on start point
        
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];
            
            // If no overlap
            if (curr_start > result.get(result.size() - 1)[1]) {
                result.add(intervals[i]);
            } else {
                // There is an overlap
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], curr_end);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}


// Approach -2 Another way (TC - NlogN + O(N))
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 0 || intervals == null) return new int[0][];

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // basis on start points

        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];

        for(int[] it : intervals){
            int curr_start = it[0];
            int curr_end   = it[1];

            if(curr_start <= prev_end){ // overlapping
                prev_end = Math.max(prev_end, curr_end);
            }
            else{ // non-overlpping
                res.add(new int[] {prev_start, prev_end});
                prev_start = curr_start;
                prev_end   = curr_end;
            }

        }
        res.add(new int[] { prev_start, prev_end}); // added the last one
        return res.toArray(new int[0][]);
        
    }
}
