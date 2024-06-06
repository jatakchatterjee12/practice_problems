/*
      GFG Link          :   https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
      Company Tags      :   Paytm, Amazon, Microsoft, D-E-Shaw, Hike, Walmart, Adobe, Google, Boomerang Commerce, Zillious, Atlassian
*/

// TC -> O(2(nlogn + n)
// SC -> O(1) 

//Approach : Sort the arrival and departure array and  whenever arrival[i] <= departure[j] (means a train comes before another departure) cnt++(need a new platform) & i++
//           and whenever dep[j] < arr[i] (means aage departure hoga to wohi platform use ho jayega) cnt--(woh platform khali ho gaya abhi isiliye cnt--) & j++
//           

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i = 0; // arrival
        int j = 0; // departure
        
        int cnt = 0;
        int maxCnt = 0;
        
        while(i < n) {
            
            if(arr[i] <= dep[j]) {
                cnt++;
                i++;
            }
            else{
                cnt--;
                j++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
    
       
}
