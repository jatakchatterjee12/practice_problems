/*
    Company Tags                      : Accolite, Adobe, Amazon, D-E-Shaw, MakeMyTrip, Microsoft, Payu
    Leetcode Link                     : https://leetcode.com/problems/trapping-rain-water/
*/


/********************************************************** C++ **********************************************************/
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    vector<int> getLeftMax(vector<int>& height, int n) {
        vector<int> leftMax(n);
        leftMax[0] = height[0];
        for(int i = 1; i<n; i++) {
            leftMax[i] = max(leftMax[i-1], height[i]);
        }
        return leftMax;
    }
    vector<int> getRightMax(vector<int>& height, int n) {
        vector<int> rightMax(n);
        rightMax[n-1] = height[n-1];
        for(int i = n-2; i>=0; i--) {
            rightMax[i] = max(rightMax[i+1], height[i]);
        }
        return rightMax;
    } 
    int trap(vector<int>& height) {
        int n = height.size();
        if(n == 1 || n == 0)
            return 0;
        vector<int> leftMax = getLeftMax(height, n);
        vector<int> rightMax = getRightMax(height, n);
        int sum = 0;
        for(int i = 0; i<n; i++) {
            sum += min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
};

//Approach 2: 
class Solution {
public:
    int trap(vector<int>& height) {
        
        int n = height.size();
        int left = 0;
        int right = n-1;
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while(left <= right){

            if(height[left] <= height[right]){

                if(height[left] >= maxLeft){

                    maxLeft = height[left];
                }
                else{
                    res += maxLeft - height[left];
                }

                left++;

            }
            else{ // height[left] > height[right]

                if(height[right] >= maxRight){

                    maxRight = height[right];
                }
                else {
                    res += maxRight - height[right];
                }

                right--;
            }
        }
        return res;
    }
};



/********************************************************** JAVA **********************************************************/
//T.C : O(n)
//S.C : O(n)
public class Solution {
    public int[] getLeftMax(int[] height, int n) {
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        return leftMax;
    }

    public int[] getRightMax(int[] height, int n) {
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        return rightMax;
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 1 || n == 0)
            return 0;
        
        int[] leftMax = getLeftMax(height, n);
        int[] rightMax = getRightMax(height, n);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }
}

//Approach 2
class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int left = 0;
        int right = n-1;
        int res = 0;
        int maxleft = 0;
        int maxright = 0;

        while(left <= right){

            if(height[left] <= height[right]){

                if(height[left] >= maxleft){
                    maxleft = height[left];
                }
                else {
                    res += maxleft - height[left];
                }

                left++;
            }
            else {

                if(height[right] >= maxright){
                    maxright = height[right];
                }
                else {
                    res += maxright - height[right];
                }
                right--;
            }
        }
        return res;
        
    }
}
