//Approach 1 : Forward Traverse
// TC - O(nlogn)
class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        long res = -1;

        for(int i=0; i<n; i++){
            if(nums[i] < sum) res = sum + nums[i];
            sum += nums[i];
        }
        return res;
    }
}

//Approach 2 : Backward Traverse
// TC - O(nlogn)
class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        for(int num : nums) sum += num;

        for(int i=n-1; i>=2; i--){

           sum -= nums[i];
           if(sum > nums[i]) 
                return sum + nums[i];
        }
        return -1;
    }
}
