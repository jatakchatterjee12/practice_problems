/*
    Company Tags  :  VMWare, Amazon, Microsoft, MakeMyTrip
    GFG Link      :  https://www.geeksforgeeks.org/problems/maximum-index-1587115620/1
*/

//TC - O(n)
//SC - O(n)

/* Approach : at a point(index) the min coming from left <= the max coming from right will be considering our ansr
              ie. preMin[i] always occuring left of the suffMax[j].. and if(preMin[i] <= suffMax[j]) then this can be our ansr. 
*/  

class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        int[] preMin = new int[n];
        int[] suffMax = new int[n];
        
        preMin[0] = a[0];
        for(int i=1; i<n; i++) {
            preMin[i] = Math.min(preMin[i-1], a[i]);
        }
        
        suffMax[n-1] = a[n-1];
        for(int i=n-2; i>=0; i--) {
            suffMax[i] = Math.max(suffMax[i+1], a[i]);
        }
        
        int i=0;
        int j=0;
        
        int ans = -1;
    
        while(i<n && j<n) {
          
            if(preMin[i] <= suffMax[j]) {
                ans = Math.max(ans, j-i);
                j++;
            }
            else{ // preMin[i] > suffMAx[j]
                i++;
            }
        }
        return ans;
    }
}
