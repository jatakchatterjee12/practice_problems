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


//************************************************ JAVA *******************************************//
// Approach -2 (TC - NlogN + O(N))
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

            if(curr_start <= prev_end){
                prev_end = Math.max(prev_end, curr_end);
            }
            else{
                res.add(new int[] {prev_start, prev_end});
                prev_start = curr_start;
                prev_end   = curr_end;
            }

        }
        res.add(new int[] { prev_start, prev_end}); // last one
        return res.toArray(new int[0][]);
        
    }
}
