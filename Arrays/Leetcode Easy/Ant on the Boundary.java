class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int ans = 0;
        int sum = 0;
        
        for(int num : nums){
            sum += num;
            if(sum == 0) ans++;
        }
        return ans;
    }
}
