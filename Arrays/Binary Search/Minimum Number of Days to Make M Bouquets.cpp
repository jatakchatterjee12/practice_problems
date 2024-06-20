/* 
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
*/

/*************************************************************** C++ ***************************************************************/
//Approach - Using "Binary Search on Answer"
//T.C : O(n * log(max_d)), n is the number of flowers and max_d is the highest value in the array bloomDay.
//S.C : O(1)
class Solution {
public:
    int getNumOfBouquets(vector<int>& bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int consecutive_count = 0;
        
        //Find count of consecutive flowers you can pick at mid day.
        for (int i = 0; i < bloomDay.size(); i++) {
            if (bloomDay[i] <= mid) {
                consecutive_count++;
            } else {
                consecutive_count = 0;
            }
            if (consecutive_count == k) {
                numOfBouquets++;
                consecutive_count = 0;
            }
        }
        return numOfBouquets;
    }

    int minDays(vector<int>& bloomDay, int m, int k) {
        int start_day = 0;
        int end_day   = *max_element(begin(bloomDay), end(bloomDay));

        int minDays = -1;

        while (start_day <= end_day) {
            int mid = start_day + (end_day - start_day)/2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end_day = mid - 1;
            } else {
                start_day = mid + 1;
            }
        }

        return minDays;
    }
};



/*************************************************************** JAVA ***************************************************************/
//Approach - Using "Binary Search on Answer"
//T.C : O(n * log(max_d)), n is the number of flowers and max_d is the highest value in the array bloomDay.
//S.C : O(1)
class Solution {
    boolean Possible(int[] bloomDay,int day, int m, int k){

        int cnt = 0;
        int noOfBouq = 0;

        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                cnt++;
            }
            else {
                noOfBouq += cnt/k;
                cnt = 0;
            }
        }
        noOfBouq += cnt/k;

        return noOfBouq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;
        
        long val = (long)m*k;

        if(n < val) return -1; // impossible case

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ;i<n; i++){
            mini = Math.min(mini,bloomDay[i]);
            maxi = Math.max(maxi , bloomDay[i]);
        }
        int low = mini;
        int high = maxi;

        while(low <= high){
            int mid = low + (high - low)/ 2;

            if(Possible(bloomDay,mid,m,k)){
                high = mid-1;
            }
            else {
                low = mid + 1;
            }

        }
        return low;
        
    
    }
}
