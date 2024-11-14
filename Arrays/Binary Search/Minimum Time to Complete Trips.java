/*
    Company Tags                : Google, PhonePe
    Leetcode Link               : https://leetcode.com/problems/minimum-time-to-complete-trips/
*/

//Simply check for each time (1, 2, 3...) if that will be able to satisfy totalTrips. This will cause TLE

////////////////////////////////////////// C++ //////////////////////////////////////////////////////

//Using Binary Search - O(n * log(totalTrips * m)) -> where m = minimum time in the given array
class Solution {
public:
    bool possible(vector<int>& time, long long givenTime, int totalTrips) {
        long long actualTrips = 0;
        
        for(int &t : time) {
            actualTrips += givenTime/t;
        }
        
        return actualTrips >= totalTrips;
    }
    
    long long minimumTime(vector<int>& time, int totalTrips) {
        int n = time.size();
        
        long long l = 1;
        long long r = (long long) *min_element(begin(time), end(time)) * totalTrips;
        
        while(l < r) {
            
            long long mid_time = l + (r - l)/2;
            
            if(possible(time, mid_time, totalTrips)) {
                r = mid_time;
            } else {
                l = mid_time + 1;
            }
            
        }
        
        return l;
        
    }
};

//////////////////////////////////////////// JAVA ////////////////////////////////////////////
class Solution {
    boolean possibleHai(long givenTime, int totalTrips, int[] time){

        long actualTrip = 0;
        for(int t :time){
            actualTrip += (givenTime/t);
        }

        return actualTrip >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        //BINARY SEARCH

        int n = time.length;
        int minTime = Integer.MAX_VALUE;

        for(int t : time){
            minTime = Math.min(t, minTime);
        }
        
        long l = 1;
        long r = (long)((long)minTime * (long)totalTrips);
        

        while(l <= r){

            long mid = l + (r-l)/2;

            if(possibleHai(mid, totalTrips, time)){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return l;

    }
}
