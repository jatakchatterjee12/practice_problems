class Solution {

    boolean isValid(int[] nums, int mid, int k){
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= mid){
                cnt++;
                i++;
            }
        }
        return cnt >= k;
    }
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();

        int result = 0;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(isValid(nums, mid, k)){
                result = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }

        }
        return result;
    }
}
