class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        if(n == 0) return new ArrayList<>();

        // 1.Sort the nums
        Arrays.sort(nums);

        // 2. Generating the count dp
        int[] count_dp = new int[n];
        Arrays.fill(count_dp, 1);

        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){

                if(nums[i] % nums[j] == 0){
                    count_dp[i] = Math.max(count_dp[i], count_dp[j]+1);
                }
            }
        }

        // 3. find maxIndex 
        int maxIndex = 0;
        for(int i=1;i<n;i++){
            if(count_dp[i] > count_dp[maxIndex]){
                maxIndex = i;
            }
        }

        // 4. Construct longest subset
        List<Integer> result = new ArrayList<>();
        int tmp = nums[maxIndex];
        int currCount = count_dp[maxIndex];

        for(int i=maxIndex; i>=0; i--){
            if(tmp % nums[i] == 0 && currCount == count_dp[i]){
                result.add(nums[i]);
                tmp = nums[i];
                currCount--;
            }
        }

        return result;
    }
}
