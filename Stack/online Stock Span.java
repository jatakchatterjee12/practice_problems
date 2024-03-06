/*
    Company Tags                : Microsoft, Accolite, Amazon, FactSet, Samsung, Adobe, Flipkart
    Leetcode Link               : https://leetcode.com/problems/online-stock-span/
    GfG Link                    : https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
*/

//********************************************* C++ ***********************************************//
class StockSpanner {
public:
    stack<pair<int, int>> st; // {price, span}
    
    StockSpanner() {
        
    }
    
    int next(int price) {
        int span = 1;
        
        while(!st.empty() && st.top().first <= price) {
            span += st.top().second;
            st.pop();
        }
        
        st.push({price, span});
        return span;
    }
};

//****************************************************** JAVA ********************************************************//
class StockSpanner {
    Stack<int[]> st; // {price, span}
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; 
        while(!st.isEmpty() && price >= st.peek()[0]){
            span += st.peek()[1];
            st.pop();
        }
        st.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
