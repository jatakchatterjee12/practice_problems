/*

    Company Tags             :    will update soon
    Leetcode Link            :    https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
*/

// Brute Force - Bit by Bit check
// TC - O(1)
//SC - O(1)

class Solution {
    public int minBitFlips(int start, int goal) {
        // bit by bit check

        int count = 0;

        while(start > 0 || goal > 0){

            // check the right most bit for both start and goal if they are same or not
            if((start & 1) != (goal & 1)){
                count++;
            }

            // right shift start and goal as we rule out the right most bit
            start = start >> 1;
            goal = goal >> 1;
        }

        return count;
    }
}


// Using XOR concept
//TC - O(1)
//SC - O(1)
class Solution {
    public int minBitFlips(int start, int goal) {
        
        int XOR = start ^ goal;
        int count = 0;

        //now xor contains 1 bit set in positions where both bits were different in start and goal

        while(XOR > 0){

            // check the right most bit
            count += (XOR & 1);

            // shift right to rule out the right most bit
            XOR = XOR >> 1;
        } 
        return count;
    }
}


// Using Brian Kernighan's Law
//TC - O(1)
//SC - O(1)
class Solution {
    public int minBitFlips(int start, int goal) {
        
        int XOR = start ^ goal;
        int count = 0;

        //now xor contains 1 bit set in positions where both bits were different in start and goal

        while(XOR > 0){

            //count those set bits using Brian Kernighan's Law

            XOR = XOR & (XOR - 1);
            count++;
        } 
        return count;
    }
}
