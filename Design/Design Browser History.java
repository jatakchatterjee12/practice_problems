/*
    Company Tags                : META
    Leetcode Link               : https://leetcode.com/problems/design-browser-history/
*/

//***************************************************** C++ *************************************************************//

class BrowserHistory {
public:
    stack<string> past; //back
    stack<string> future; //future
    string curr;
    
    BrowserHistory(string homepage) {
        curr = homepage;
    }
    
    void visit(string url) {
        
        past.push(curr);
        curr = url;
        
        future = stack<string>();
        
    }
    
    string back(int steps) {
        
        while(steps > 0 && !past.empty()) {
            
            future.push(curr);
            curr = past.top();
            past.pop();
            steps--;
            
        }
        
        return curr;
    }
    
    string forward(int steps) {
        
        while(steps > 0 && !future.empty()) {
            
            past.push(curr);
            curr = future.top();
            future.pop();
            steps--;
            
        }
        
        return curr;
        
    }
};

//****************************************************************** JAVA **************************************************************//
//Approach 1: USing Two Stacks
class BrowserHistory {
    Stack<String> past = new Stack<>();
    Stack<String> future = new Stack<>();

    String curr;

    public BrowserHistory(String homepage) {
        curr = homepage;
    }
    
    public void visit(String url) {
        past.push(curr);
        curr = url;

        // clear the future stack
        while(!future.isEmpty()) {
            future.pop();
        }
    }
    
    public String back(int steps) {
        while(steps > 0 && !past.isEmpty()) {

            future.push(curr);
            curr = past.peek();
            past.pop();
            steps--;
        }

        return curr;
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && !future.isEmpty()) {

            past.push(curr);
            curr = future.peek();
            future.pop();
            steps--;
        }
        return curr;
    }
}


//Approach 2: Using String Array String[]
class BrowserHistory {

    String[] history;
    int len;
    int curr;
    public BrowserHistory(String homepage) {
        history = new String[2000];
        history[0] = homepage;
        len = 1;
        curr = 0;
    }
    
    public void visit(String url) {
        curr++;
        history[curr] = url;
        len = curr + 1;
    }
    
    public String back(int steps) {
        curr = Math.max(curr - steps, 0);
        return history[curr];
    }
    
    public String forward(int steps) {
        curr = Math.min(curr + steps, len-1);
        return history[curr];
    }
}
