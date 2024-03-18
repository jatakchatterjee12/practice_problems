/*
    Company Tags  : Google, Facebook, Microsoft, Salesforce, Amazon
    Leetcode Link : https://leetcode.com/problems/non-overlapping-intervals/
    
    This question also falls under the category of  "Range/Interval Based Questions
*/

/******************************************************* C++ ************************************************************/
//Approach-1
class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(begin(intervals), end(intervals));
        int n = intervals.size(); 
        
        int count = 0;
        int i = 0, j = 1;
        
        while(j < n) {
            vector<int> curr_interval = intervals[i];
            vector<int> next_interval = intervals[j];
            
            int curr_start = curr_interval[0];
            int curr_end   = curr_interval[1];
            
            int next_start = next_interval[0];
            int next_end   = next_interval[1];
            
            if(curr_end <= next_start) { //SAFE
                i = j;
                j++;
            } else if(curr_end <= next_end) {
                /*
                    GREEDY : Remove next interval as it has high chances to
                             overlap with future intervals
                */
                j++;
                count++;
            } else if(curr_end > next_end) {
                /*
                    GREEDY : Remove current interval as it has high chances to
                             overlap with future intervals
                */
                i = j;
                j++;
                count++;
            }
        }

        return count;

    }
};


//Approach-2 (Same as 1st Approach, Just different implementation)
class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(begin(intervals), end(intervals));
        int n = intervals.size(); 
        
        int count = 0;
        int i = 1;
        vector<int> lastInterval = intervals[0];
        while(i < n)  {
            
            int curr_end   = intervals[i][1];
            int curr_start = intervals[i][0];
            
            int last_end = lastInterval[1];
            
            if(curr_start >= last_end) {
                lastInterval = intervals[i]; //safe
            } else if(curr_end >= last_end) {
                count++; //Being Greedy
            } else if(curr_end < last_end) {
                lastInterval = intervals[i]; //Being Greedy
                count++;
            }
            
            i++;
        }

        return count;

    }
};

/******************************************************************* JAVA *****************************************************
  class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[] prev = intervals[0];
        int count = 0;

        int i = 1;

        while(i < n) {

            int curr_start = intervals[i][0];
            int curr_end   = intervals[i][1];

            int prev_end   = prev[1];

            if(curr_start >= prev_end){
                //safe
                prev = intervals[i];
            }
            //overlapping case
            //jiska end time bada hoga usko greedily remove karenge
            else if(curr_end >= prev_end){
                //delete the current
                count++;
            }
            else{ // curr_end < prev_end
                //delete the prev
                prev = intervals[i];
                count++;
            }

            i++;
        }

       return count;
    }
}
