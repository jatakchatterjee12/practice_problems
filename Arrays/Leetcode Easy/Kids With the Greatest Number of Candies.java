class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;

        List<Boolean> ans = new ArrayList<>();

        int maxi = Integer.MIN_VALUE;
        for(int num : candies) {
            if(num > maxi) maxi = num;
        }

        for(int i=0; i<n; i++) {
            if(candies[i] + extraCandies >= maxi){
                ans.add(true);
            }
            else ans.add(false);
        }
        return ans;
    }
}
