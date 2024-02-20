//***************************************** C++ *********************************************//
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int n = prices.size();
        int min_price = INT_MAX;
        int max_profit = 0;

        for(int i=0; i < n; i++) {
            if(prices[i] < min_price){
                min_price = prices[i];
            }
            else if(prices[i] - min_price > max_profit) {
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;
    }
};
//***************************************** JAVA ***********************************************//
class Solution {
    public int maxProfit(int[] prices) {

        int n= prices.length;
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int i = 0;i<n;i++){
            if(prices[i]< min_price){
                min_price = prices[i];
            }
            else if( prices[i] - min_price > max_profit){
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit ; 
    }
}
