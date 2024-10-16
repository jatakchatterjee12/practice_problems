/*  
    Company Tags                : Google, Amazon
    Leetcode Link               : https://leetcode.com/problems/maximum-width-ramp
*/


/********************************************************************** C++ **********************************************************************/
//Approach-1 (Using brute force) - Passes 95/101 test cases
//T.C : O(n^2)
//S.C : O(1)
class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n = nums.size();
        int ramp = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] <= nums[j]) {
                    ramp = max(ramp, j - i);
                }
            }
        }
        return ramp;
    }
};


//Approach-2 (early termination) - Passes 97/101 test cases
//T.C : O(n^2) in worst case
//S.C : O(1)
class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n = nums.size();

        int ramp = 0;

        for(int i = 0; i < n; i++) {
            for(int j = n-1; j > i; j--) {
                if(nums[i] <= nums[j]) {
                    ramp = max(ramp, j-i);
                    break;
                }
            }
        }
        return ramp;
    }
};


//Approach-3 : Two Pointer (Making use of hint from Approach-2, storing max to the right) - ACCEPTED
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    int maxWidthRamp(vector<int>& nums) {
        int n = nums.size();
        vector<int> maxRight(n);
        maxRight[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            maxRight[i] = max(maxRight[i+1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        while(j < n) {
            while(i < j && nums[i] > maxRight[j]) {
                i++;
            }

            ramp = max(ramp, j-i);
            j++;
        }

        return ramp;
    }
};



/********************************************************************** JAVA **********************************************************************/
//Approach-1 (Using brute force) (Pass 95/101 testcases)
//T.C : O(n^2)
//S.C : O(1)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int ramp = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                }
            }
        }
        return ramp;
    }
}


//Approach-2 (early termination) - Passes 100/101 test cases
//T.C : O(n^2) in worst case
//S.C : O(1)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int ramp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] <= nums[j]) {
                    ramp = Math.max(ramp, j - i);
                    break; // Exit inner loop early when a valid ramp is found
                }
            }
        }
        return ramp;
    }
}


//Approach-3 : Two Pointer (Making use of hint from Approach-2, storing max to the right) - ACCEPTED
//T.C : O(n)
//S.C : O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;

        // Create an array to store the maximum values from the right
        int[] maxRight = new int[n];
        maxRight[n - 1] = nums[n - 1];
        
        // Fill the maxRight array
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        // Find the maximum width ramp
        while (j < n) {
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }

        return ramp;
    }
}

// Approach 4 : Using Monotonic Decreasing Stack
//TC : O(n)
//SC : O(n)

/*
    [6, 0, 8, 2, 1, 5]

    stack contains -- [6, 0]    //no need to push 8 cz for any possible ramp for 8 that could not be the max width ramp as 0 & 6 are already there in the left of 8
                                // so any fit number(ex: 8,9,10,....) for 8 can make ramp with 0 and 6 too and make the max width ramp

    then we traverse from back and check the stack top index if it can make ramp and continuosly updating MaxRamp;                            
*/

class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>(); // store the indices // decreasing monotonic stack

        for(int i = 0; i < n ; i++){
            if(st.isEmpty() || nums[i] < nums[st.peek()]){
                st.push(i);
            }
        }

        int ramp = 0;

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && nums[i] >= nums[st.peek()]){
                ramp = Math.max(ramp, i - st.peek());
                st.pop();
            }
        }
        
        return ramp;
    }
}
