
/*
    Company Tags                : Amazon, Google
    Leetcode Qn Link            : https://leetcode.com/problems/majority-element-ii/
*/

/**************************************************** C++ ****************************************************/
class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int n = nums.size();
        
        int maj1    = NULL;
        int count1 = 0;

        int maj2    = NULL;
        int count2 = 0;
        int freq = floor(n/3);
        
        for(int i = 0; i<n; i++) {
            if(nums[i] == maj1)
                count1++;
            else if(nums[i] == maj2)
                count2++;
            else if(count1 == 0) {
                maj1 = nums[i];
                count1 = 1;
            } else if(count2 == 0) {
                maj2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        vector<int> result; //because atmost two elements can occur more than ⌊ n/3 ⌋ in an array of length n
        count1 = 0;
        count2 = 0;
        for(int num:nums) {
            if(num == maj1)
                count1++;
            else if(num == maj2)
                count2++;
        }
        if(count1 > floor(n/3))
            result.push_back(maj1);
        if(count2 > floor(n/3))
            result.push_back(maj2);
        return result;


    }
};



/**************************************************** JAVA ****************************************************/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        
        Integer maj1 = null;
        int count1 = 0;

        Integer maj2 = null;
        int count2 = 0;
        
        for (int num : nums) {
            if (maj1 != null && num == maj1) {
                count1++;
            } else if (maj2 != null && num == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (maj1 != null && num == maj1) {
                count1++;
            } else if (maj2 != null && num == maj2) {
                count2++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (count1 > Math.floor(n / 3)) {
            result.add(maj1);
        }
        if (count2 > Math.floor(n / 3)) {
            result.add(maj2);
        }
        
        return result;
    }
}

/////////  Same Code in different Style

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0; // Counters for the potential majority elements
        int candidate1 = 0, candidate2 = 0; // Potential majority element candidates

        // First pass to find potential majority elements.
        for (int i = 0; i < nums.length; i++) {
            // If count1 is 0 and the current number is not equal to candidate2, update candidate1.
            if (count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i];
            } 
            // If count2 is 0 and the current number is not equal to candidate1, update candidate2.
            else if (count2 == 0 && nums[i] != candidate1) {
                count2 = 1;
                candidate2 = nums[i];
            } 
            // Update counts for candidate1 and candidate2.
            else if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } 
            // If the current number is different from both candidates, decrement their counts.
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3; // Threshold for majority element

        // Second pass to count occurrences of the potential majority elements.
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

        // Check if the counts of potential majority elements are greater than n/3 and add them to the result.
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold) {
            result.add(candidate2);
        }

        return result;
    }
}
