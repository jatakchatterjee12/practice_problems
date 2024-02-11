class Solution {
public:
    void LPS(int lps[], int m,vector<int>& pattern){
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while(i < m){
            if(pattern[i] == pattern[len]){
                len++;
                lps[i] = len;
                i++;
            } 
            else{
                if(len > 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    int countMatchingSubarrays(vector<int>& nums, vector<int>& pattern) {
        int n = nums.size();
        for(int i=0; i<n-1; i++){
            if(nums[i+1] > nums[i]) nums[i] = 1;
            else if(nums[i+1] < nums[i]) nums[i] = -1;
            else nums[i] = 0;
        }
        nums[n-1] = 2;
        
        int m = pattern.size();
        int lps[m];
        LPS(lps,m, pattern);
        
        int res = 0;
        
        int i=0, j=0;
        while(n-i >= m-j){
            if(pattern[j] == nums[i]){
                i++;
                j++;
            }
            if(j == m) {
                res++;
                j = lps[j-1];
            }
            else if(i < n && pattern[j] != nums[i]){
                if(j > 0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return res;
        
    }
};
