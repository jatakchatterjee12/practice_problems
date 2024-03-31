
/* 
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/count-alternating-subarrays
*/


/******************************************************************** C++ *************************************************************/
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    long long countAlternatingSubarrays(vector<int>& nums) {
        long long count = 0;
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            int j = i;

            while (j + 1 < n && nums[j] != nums[j + 1]) {
                ++j;
            }

            int len = j - i + 1;
            count += (long long)len * (len + 1) / 2;
            i = j;
        }

        return count;
    }
};


/******************************************************************** JAVA *************************************************************/
//Brute Force
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        
        int n = nums.length;
        long ans = n;
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {

                if(nums[j] != nums[j-1]){
                    ans++;
                }
                else break;

            }
            
        }
        return ans;
    }
}



//T.C : O(n)
//S.C : O(1)
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int j = i;

            while (j + 1 < n && nums[j] != nums[j + 1]) {
                ++j;
            }

            int len = j - i + 1;
            count += (long) len * (len + 1) / 2;
            i = j;
        }

        return count;
    }
}
