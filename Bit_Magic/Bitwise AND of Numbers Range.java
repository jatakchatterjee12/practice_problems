/*
    Company Tags                : will update soon 
    Leetcode Link               : https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/

/************************************************************ C++ ************************************************************/
//Approach-1 (Using shift)
//T.C : O(log(n)), where n is the maximum number of bits needed to represent the given input integers left and right.
//S.C : O(1)
class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;
        
        while(left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        
        return left << shiftCount;
    }
};


//Approach-2 (Using AND property)
//T.C : O(log(n)), where n is the maximum number of bits needed to represent the given input integers left and right.
//S.C : O(1)
class Solution {
public:
    int rangeBitwiseAnd(int left, int right) {
        while(right > left) {
            right = right & (right-1);
        }
        
        return right;
    }
};



/************************************************************ JAVA ************************************************************/
// Approach-1 (Using shift)
// T.C: O(log(n)), where n is the maximum number of bits needed to represent the given input integers left and right.
// S.C: O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shiftCount = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }

        return left << shiftCount;
    }
}

// Approach-2 (Using AND property)
// T.C: O(log(n)), where n is the maximum number of bits needed to represent the given input integers left and right.
// S.C: O(1)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }

        return right;
    }
}
