
//Monotonic Stack -- increasing
//TC - O(n+n)
//Sc - O(n+n+n) considering the ans[] space
class Solution {
    void generateDisc(int[] prices, int[] disc){
        int n = prices.length;
        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){

            while(!st.isEmpty() && prices[st.peek()] > prices[i]){
                st.pop();
            }

            disc[i] = st.isEmpty() ? 0 : prices[st.peek()];
            st.push(i);
        }
    }
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;
        int[] ans = new int[n];
        int[] disc = new int[n];
        generateDisc(prices, disc);

        for(int i = 0; i < n; i++){
            int price = prices[i];
            int discount = disc[i];
            int tot_price = price - discount;
            ans[i] = tot_price;
        }
        return ans;
    }
}
