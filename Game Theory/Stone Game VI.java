/*
                      LeetCode Qn Link                :  https://leetcode.com/problems/stone-game-vi/description/
*/

/* Approach : 
    Sort stones by their sum value for Alice and Bob.
    If a stone is super valued for Alice, Alice wants to take it.
    If a stone is super valued for Bob, Alice also wants to take it.
    Because she doesn't want Bob to take it.

    Here is more convinced explanation.
    Assume a stone valued [a,b] for Alice and Bod.
    Alice takes it, worth a for Alice,
    Bob takes it, worth b for Bob,
    we can also consider that it worth -b for Alice.
    The difference will be a+b.
    That's the reason why we need to sort based on a+b.
    And Alice and Bob will take one most valued stone each turn.
*/

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        // step 1
        int[][] sumArr = new int[n][2];
        for(int i=0; i<n; i++){
            sumArr[i] = new int[] {(aliceValues[i] + bobValues[i]), i};
        }

        //step 2
        Arrays.sort(sumArr, (a,b)-> b[0] - a[0]);

        int a = 0;
        int b = 0;

        //step 3
        for(int i=0; i<n; i++){
            int j = sumArr[i][1]; // index
            if(i % 2 == 0){ // Alice's turn
                a += aliceValues[j];
            }
            else { // Bob's turn
                b += bobValues[j];
            }
        }
        if(a == b) return 0;
        return a > b ? 1 : -1;

    }
}
