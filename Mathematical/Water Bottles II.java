class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        
        int ans = numBottles;
        int full = 0;
        int empty = numBottles;

        while(empty >= numExchange || full > 0) {
            empty -= numExchange; //7 // 3 // 0
            full += 1; // 1 // 2 // 1
            numExchange++; //4 // 5 // 6

            if(empty < numExchange) {
                ans += full; //12 //13
                empty += full; // 5 // 6
                full = 0; // 0 // 0
                 
            }
        }
        return ans;
    }
}
