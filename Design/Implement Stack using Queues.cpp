/*
    Company Tags                : Bloomberg
    Leetcode Link               : https://leetcode.com/problems/implement-stack-using-queues/
*/

//Approach-1 (Using 2 queues with O(n) pop)
class MyStack {
public:
    /** Initialize your data structure here. */
    queue<int> q1;
    queue<int> q2;
    MyStack() {
        
    }
    
    /** Push element x onto stack. */
    void push(int x) {
        q2.push(x);
        while(!q1.empty()){
            q2.push(q1.front());    q1.pop();
        }
        swap(q1, q2);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int result = q1.top();
        q1.pop();
        return result;
    }
    
    /** Get the top element. */
    int top() {
        return q1.front();
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        return q1.empty();
    }
};

//Approach-2 (Using single queue with O(n) push)
class MyStack {
public:
    queue<int> que;
    /** Initialize your data structure here. */
    MyStack() {
    }
    
    /** Push element x onto stack. */
    void push(int x) {
        que.push(x);
        for(int i = 0; i<que.size()-1; i++) {
            que.push(que.front());
            que.pop();
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int x = que.front();
        que.pop();
        return x;
    }
    
    /** Get the top element. */
    int top() {
        return que.front();
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        return que.empty();
    }
};


//Approach-3 (Using dequeq)
class MyStack {
public:
    deque<int> deq;
    /** Initialize your data structure here. */
    MyStack() {
        deq.clear();
    }
    
    /** Push element x onto stack. */
    void push(int x) {
        return deq.push_back(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    int pop() {
        int top = deq.back();
        deq.pop_back();
        return top;
    }
    
    /** Get the top element. */
    int top() {
        return deq.back();
    }
    
    /** Returns whether the stack is empty. */
    bool empty() {
        return deq.empty();
    }
};

/****************************************************** JAVA ************************************************************//
// Approach -1.(Using 2 queues O(n) pop opeartion)
class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        
       if(q1.isEmpty()){
            q1.offer(x);
        }
        else{
            while(!q1.isEmpty()){
                q2.offer(q1.poll());
            }

            q1.offer(x);

            while(!q2.isEmpty()){
                q1.offer(q2.poll());
            }
        }
    }
    
    public int pop() {
        if(!q1.isEmpty()){

            int res = q1.poll();
            return res;
        }
        return -1;
    }
    
    public int top() {
        
        if(!q1.isEmpty()){

            return q1.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        
        return q1.isEmpty();
    }
}
//Approach-2 (Using single queue with O(n) push)
class MyStack {
    Queue<Integer> q = new LinkedList<>();
    

    public MyStack() {
        
    }
    
    public void push(int x) {
        
       q.offer(x);

       int n = q.size();
       for(int i = 0; i < n-1;i++){
           q.offer(q.poll());
       }
    }
    
    public int pop() {
        if(!q.isEmpty()){

            int res = q.poll();
            return res;
        }
        return -1;
    }
    
    public int top() {
        
        if(!q.isEmpty()){

            return q.peek();
        }
        return -1;
    }
    
    public boolean empty() {
        
        return q.isEmpty();
    }
}

