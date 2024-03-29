/*
    Company Tags  : Amazon, Flipkart, OYO Rooms, Snapdeal, Samsung, Zoho
    Leetcode Link : https://leetcode.com/problems/next-greater-element-ii/
    ALERT : In this, you have to find next greater element in Circular Array

    Monotonic Decreasing Order of the Stack (Top to Bottom Increasing Order)
*/

//Approach-1 [Time : O(n^2)]
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& input) {
        int n = input.size();
	    vector<int> output(n);
	    
        for(int i = 0; i<n; i++) {
            int j = (i+1)%n;
            while(j != i) {
                if(input[j] > input[i]) {
                    output[i] = input[j];
                    break;
                }
                j = (j+1)%n;
            }
            if(j == i)
                output[i] = -1;
    	}
        return output;
    }
};

//Approach-2 (Using stack : Two traversal)
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& input) {
        int n = input.size();
	    vector<int> output(n);
	    stack<int> st;
        for(int i = n-1; i>=0; i--) {
            if(st.empty()) {
                output[i] = -1;
            } else {
                while(!st.empty() && st.top() <= input[i])
                    st.pop();
                if(st.empty()) {
                    output[i] = -1;
                } else {
                    output[i] = st.top();
                }
            }
            st.push(input[i]);
    	}
        
      //Do it once more and you'll get the correct answer for circular array
      for(int i = n-1; i>=0; i--) {
          if(st.empty()) {
              output[i] = -1;
          } else {
              while(!st.empty() && st.top() <= input[i])
                  st.pop();
              if(st.empty()) {
                  output[i] = -1;
              } else {
                  output[i] = st.top();
              }
          }
          st.push(input[i]);
    	}
        
        return output;
    }
};

//Approach-3 (Using stack : Single looking traversal)
class Solution {
public:
    vector<int> nextGreaterElements(vector<int> &nums) {
        int n = nums.size();
        vector<int> result(n);
        stack<int> st;

        for(int i = 2*n-1; i>=0; i--) {
            int idx = i%n;

            if(st.empty()) {
                result[idx] = -1;
            } else {
                while(!st.empty() && st.top() <= nums[idx]) {
                    st.pop();
                }
                result[idx] = st.empty() ? -1 : st.top();
            }
            st.push(nums[idx]);
        }

        return result;
    }
};

//************************************************* JAVA *****************************************************//
// Approach-3(most optimal)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 2*n-1; i>=0; i--){
            int idx = i%n;
          
            while(!st.empty() && st.peek() <= nums[idx]){
                st.pop();
            }
            result[idx] = (st.empty() ? -1 : st.peek());
            st.push(nums[idx]);
        }
        return result;
    }
}
