/*
            Example:    h = house,  * = heater  M = INT_MAX

                    h   h   h   h   h   h   h   h   h    houses
                    1   2   3   4   5   6   7   8   9    index
                    *           *       *                heaters
                            
                    0   2   1   0   1   0   -   -   -    (distance to nearest RHS heater)
                    0   1   2   0   1   0   1   2   3    (distance to nearest LHS heater)

                    0   1   1   0   1   0   1   2   3    (res = minimum of above two)

            Result is maximum value in res, which is 3.
  */ 


class Solution {
    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int n = houses.length;
        int m = heaters.length;

        //houses = [1,2,3,4,5,6,7,8,9]
        //heaters = [1,4,6];

        int i =0; // house
        int j =0; // heater

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        //calculating dist from nearest RHS heater
        while(i < n && j < m){

            if(houses[i] <= heaters[j]){
                res[i] = heaters[j] - houses[i];
                i++;
            }
            else{
                j++;
            }

        }


        //calculating dist from nearest LHS heater
        i = n-1;
        j = m-1;
        while(i >= 0 && j >= 0){

            if(houses[i] >= heaters[j]){
                int d = houses[i] - heaters[j];
                res[i] = Math.min(res[i], d);
                i--;
            }
            else{
                j--;
            }

        }

        return Arrays.stream(res).max().getAsInt();
    }
}
