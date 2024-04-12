
/*
  input  -  7,12,1,20
  output - 12,20,20,-1
*/

import java.util.Stack;
public class Solution {
    public static int[] nextGreaterElement(int[] arr, int n) {
        // Write your code here.

        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--) {

            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
