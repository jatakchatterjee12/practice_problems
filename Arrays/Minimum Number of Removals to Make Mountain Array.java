//Approach : Using LIS and LDS concept.

/*
     [ 2,1,1,5,6,2,3,1 ]
     
            6
          /  \
        5     2
      /        \
    1           1

   Left side    [1, 5, 6] ---- LIS
   right side   [6, 2, 1] ---- LDS

    LIS[4] = 3                                                        LDS[4] = 3
    removalLeft = Total element  till i idx - LIS[i]                removalRight = total element on right including i idx - LDS[i]
                = (i+1) - LIS[i]                                                   = (n-i) - LDS[i]

    total miRremoval needs = {(i+1) - LIS[i]} + { (n-i) - LDS[i]}
                            = {n - LIS[i] - LDS[i] + 1 }

*/

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;

        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);

        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);

        //calculate LIS array
        for(int i = 0; i < n; i++){
            for(int j = i-1; j >= 0; j--){

                if(nums[i] > nums[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }

                
            }
        }

        //calculate LDS array
        for(int i = n-1; i >= 0; i--){
            for(int j = i+1; j < n; j++) {
                if(nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1); 
                }
            }
        }


        int minRemoves = n;

        //Treat every index as peak index and find out the minimum removals for each index treating it as peak
        for(int i = 0; i < n ; i++) {

            if(LIS[i] > 1 && LDS[i] > 1) { // tabhi mountain array length >= 3 rehega 
                minRemoves = Math.min(minRemoves, n - LIS[i] - LDS[i] + 1);
            }

            
        }

        return minRemoves;
    }
}
