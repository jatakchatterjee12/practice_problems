
/*  
    Company Tags                : will update later
    Leetcode Link               : https://leetcode.com/problems/smallest-number-with-all-set-bits
*/


/******************************************************* C++ *******************************************************/
//Approach-1 (Simple looping till we get result)
//T.C : O(result - n), where result = (next power of 2 > n) - 1
//S.C : O(1)
class Solution {
public:
    bool isAllBitsSet(int x) {
        return (x & (x+1)) == 0;
    }
    int smallestNumber(int n) {
        int result = n;

        while(!isAllBitsSet(result)) {
            result++;
        }

        return result;
    }
};



//Approach-2 (Using properties of power of 2)
//T.C : O(log2(n))
//S.C : O(1)
class Solution {
public:
    int smallestNumber(int n) {
        int result = 1;

        while(result < n) {
            result = 2*result + 1;
        }

        return result;
    }
};



//Approach-3 (constant time but using same power of 2 property)
//T.C : O(1)
//S.C : O(1)
class Solution {
public:
    int smallestNumber(int n) {
        int bits = log2(n) + 1;

        return (1 << bits) - 1;
    }
};



/******************************************************* JAVA *******************************************************/
//Approach-1 (Simple looping till we get result)
//T.C : O(result - n), where result = (next power of 2 > n) - 1
//S.C : O(1)
class Solution {
    public boolean isAllBitsSet(int x) {
        return (x & (x + 1)) == 0;
    }

    public int smallestNumber(int n) {
        int result = n;

        while (!isAllBitsSet(result)) {
            result++;
        }

        return result;
    }
}



//Approach-2 (Using properties of power of 2)
//T.C : O(log2(n))
//S.C : O(1)
class Solution {
    public int smallestNumber(int n) {
        int result = 1;

        while (result < n) {
            result = 2 * result + 1;
        }

        return result;
    }
}



//Approach-3 (constant time but using same power of 2 property)
//T.C : O(1)
//S.C : O(1)
class Solution {
    public int smallestNumber(int n) {
        int bits = (int)(Math.log(n) / Math.log(2)) + 1;
        return (1 << bits) - 1;
    }
}


//Approach 4: 
/*
    n & (n+1) == 0 is a classic trick to check if a number is a power of 2 minus one (i.e. a number with all significant bits set to 1 in binary notation), example:
    n=01111
    If we add one:
    n+1=10000
    If we AND these two values:
    n&(n+1)=00000
    The result is zero only if n is a value with all bits set
    So the simplest solution is to keep setting all unset bits until the value becomes a power of 2 minus one
    Adding 1 to a number will ALWAYS set the first unset bit, if we OR with the original number, we are joining together the original number with the next unset bit
    Example for n = 32:
    
    n = 0b100000
    n |= n + 1 = 0b100000 | 0b100001 = 0b100001
    n |= n + 1 = 0b100001 | 0b100010 = 0b100011
    n |= n + 1 = 0b100011 | 0b100100 = 0b100111
    n |= n + 1 = 0b100111 | 0b101000 = 0b101111
    n |= n + 1 = 0b101111 | 0b110000 = 0b111111
    n = 0b111111 = 63
    Complexity
    Time complexity: O(log(n))
    Space complexity: O(1)
*/

class Solution {
    public int smallestNumber(int n) {
        while((n & (n+1)) != 0){
            n |= (n+1);
        }
        return n;

    }
}
