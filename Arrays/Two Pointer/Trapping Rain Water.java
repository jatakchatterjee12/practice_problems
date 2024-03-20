class Solution {
    int[] getL(int[] height, int n) {

        int[] ans = new int[n];
        ans[0] = height[0];

        for(int i = 1; i < n ; i++) {
            ans[i] = Math.max(ans[i-1], height[i]);
        }
        return ans;
    }

    int[] getR(int[] height, int n) {

        int[] ans = new int[n];
        ans[n-1] = height[n-1];

        for(int i = n-2; i >= 0 ; i--) {
            ans[i] = Math.max(ans[i+1], height[i]);
        }
        return ans;
    }

    public int trap(int[] height) {
        
        int n = height.length;

        int[] leftMax = getL(height, n);
        int[] rightMax = getR(height, n);

        int sum = 0;

        for(int i = 0; i  < n; i++) {

            int h = Math.min(leftMax[i], rightMax[i]) - height[i];

            sum += h;
        }

        return sum;
    }
}
