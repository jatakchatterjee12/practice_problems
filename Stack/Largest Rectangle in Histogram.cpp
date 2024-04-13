/*
    Company Tags  : Amazon, MAQ Software, Paytm, Snapdeal
    Leetcode Link : https://leetcode.com/problems/largest-rectangle-in-histogram/
*/

//Approach-1 (Using NSL, NSR concept)
class Solution {
public:
    //NSR = Next smaller to right
    vector<int> NSR(vector<int>& heights,int n) {
        vector<int> result(n);
        stack<int> st;

        for(int i=n-1;i>=0;i--){
            
            while(!st.empty() && heights[st.top()] > heights[i]){
                st.pop();
            }
            result[i] = st.empty() ? n : st.top();

            st.push(i);
        }
        return result;
    }
    
    //NSL = Next smaller to left
    vector<int> NSL(vector<int>& heights,int n) {
        vector<int> result(n);
        stack<int> st;

        for(int i=0;i<n;i++){
            
            while(!st.empty() && heights[st.top()] >= heights[i]){
                st.pop();
            }
            result[i] = st.empty() ? -1 : st.top();

            st.push(i);
        }
        return result;
    }
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        vector<int> left  = NSL(heights, n);
        vector<int> right = NSR(heights, n);
        
        int sum = 0;
        
        for(int x:left)
            cout << x << " ";
        cout << endl;
        for(int x:right)
            cout << x << " ";
        
        for(int i = 0; i<n; i++) {
            int area_i = heights[i]*(right[i]-left[i]-1);
            sum = max(sum, area_i);
        }
        
        return sum;
        
    }
};


//Approach-2 (Simplified version of Approach-1)
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        stack<int> st;
        int i = 0;
        int n = heights.size();
        
        int maxArea = 0;
        int area    = 0;
        while(i < n) {
            if(st.empty() || heights[i] >= heights[st.top()])
                st.push(i++);
            else {
                int index = st.top();
                st.pop();
                if(st.empty()) {
                    area = heights[index] * i;
                } else {
                    area = heights[index] * (i - st.top() - 1);
                }
                maxArea = max(maxArea, area);
            }
        }
        
        while(!st.empty()) {
            int index = st.top();
            st.pop();

            if(st.empty()) {
                area = heights[index] * i;
            } else {
                area = heights[index] * (i - st.top() - 1);
            }
            maxArea = max(maxArea, area);
        }
        
        return maxArea;
    }
};


//************************************************************** JAVA **********************************************************//
// Approach 1.
class Solution {
    // next smaller element on the left
    int[] getNSL(int[] h, int n){

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }
    // next smaller element on the right
    int[] getNSR(int[] h, int n){

        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && h[st.peek()] >= h[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] h) {
        int n = h.length;

        int[] left = getNSL(h,n);
        int[] right = getNSR(h,n);

        int maxArea = 0;

        for(int i=0;i<n;i++){

            int area_i = h[i]*(right[i] - left[i] - 1);
            maxArea = Math.max(maxArea, area_i);
        }
        return maxArea;
    }
}


//Aapproach : One Pass
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;

        for(int i = 0; i <= n; i++) {

            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])){

                int height = heights[st.peek()];
                st.pop();

                int width = 0;

                if(st.isEmpty()) width = i;
                else width = (i - st.peek() - 1); // rightsmaller - leftSmaller - 1

                int area = height * width;
                maxArea  = Math.max(maxArea, area); 
            }
            st.push(i);
        }
        return maxArea;
    }
}
