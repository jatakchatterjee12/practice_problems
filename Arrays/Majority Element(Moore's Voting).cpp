/*                                    Scroll below to see JAVA code also                                */
/*
    Company Tags                : Amazon, Accolite, D-E-Shaw, FactSet, MakeMyTrip, Microsoft, Samsung
    Leetcode Qn Link            : https://leetcode.com/problems/majority-element/
*/

/********************************************** C++ **********************************************/
//Approach-1
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        int count = 1;
        int candidate = nums[0];

        for(int i=1;i<nums.size();i++){

            if(nums[i] == candidate){
                count++;
            }
            else if(count == 0){
                count = 1;
                candidate = nums[i];
            }
            else{
                count--;
            }
        }
        return candidate;
    }
};

// OR WE CAN CODE LIKE THIS
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int count = 0;
        int maj = NULL;
        
        for(int i = 0; i<n; i++) {
            if(count == 0) {
                count = 1;
                maj = nums[i];
            }
            else if(nums[i] == maj) {
                count++;
            } else {
                count--;
            }
        }
        
        //Since it is gauranteed that majority element exists, so we don't check for freq of "maj" and return
        return maj;
    }
};

//********************************************** JAVA **********************************************//
//Approach-1
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        int candidate = nums[0];
        int count = 1;
        for(int i=1; i<n; i++){
            if(nums[i] == candidate){
                count++;
            }
            else if(count == 0){
                count = 1;
                candidate = nums[i];
            }
            else{
                count--;
            }
        }
        return candidate;
    }
}

//
//Approach-2
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        Integer maj = null;
        
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                maj = nums[i];
            } else if (nums[i] == maj) {
                count++;
            } else {
                count--;
            }
        }
        
        // Since it is guaranteed that the majority element exists, so we don't check for the frequency of "maj" and return
        return maj;
    }
}


//////OR you can also code it like this (Eaxct similar to Majority Element-II)
//Approach-3
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;
        Integer maj = null;

        for (int i = 0; i < n; i++) {
            if (maj != null && nums[i] == maj) {
                count++;
            } else if (count == 0) {
                maj = nums[i];
                count = 1;
            } else {
                count--;
            }
        }

        return maj;
    }
}
