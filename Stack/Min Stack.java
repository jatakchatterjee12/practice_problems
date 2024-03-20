//************************************************************ C++ **********************************************************//
//TC - O(1)
//SC - O(N)
class MinStack {
    stack<long long> st;
    long long mini;
public:
    MinStack() {
        while(!st.empty()) st.pop(); //clear the stack
        mini = INT_MAX;
    }
    
    void push(int value) {
        
        long long val = value;
        if(st.empty()) {
            st.push(val);
            mini = val;
        }
        else{
            if(val < mini){
                st.push(2*val * 1LL - mini);
                mini = val;
            }
            else{
                st.push(val);
            }
        }
    }
    
    void pop() {
        
        if(st.empty()) return;

        long long el =  st.top();
        st.pop();

        if(el < mini){
            mini = (2 * mini - el);
        }
    }
    
    int top() {
        if(st.empty()) return -1;

        long long el = st.top();

        if(el < mini) {
            return mini; // mini should be the val that actually went last to the stack
        }
        return el;
    }
    
    int getMin() {
        return mini;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */


//************************************************************* JAVA *************************************************************//
//TC - O(1)
//SC - O(N)
class MinStack {

    Stack<Long> st = new Stack<>();
    Long mini;

    public MinStack() {
        while(!st.isEmpty()) st.pop(); // clear the stack
        mini = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        Long val = Long.valueOf(value);
        if(st.isEmpty()) {
            mini = val;
            st.push(val);
        }
        else{
            if(val < mini){
                st.push(2 * val - mini);
                mini = val;
            }
            else{
                st.push(val);
            }
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;

        Long el = st.pop();

        if(el < mini){
            mini = (2*mini - el);
        }
    
    }
    
    public int top() {
        
        if(st.isEmpty()) return -1;

        Long el = st.peek();
        if(el < mini){
            return mini.intValue(); // current mini is the last guy went to the stack if it was < prev top element
        }
        return el.intValue();
    }
    
    public int getMin() {
        return mini.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
