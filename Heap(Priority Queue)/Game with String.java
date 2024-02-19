/*
    Company   : Amazon
    GFG Link  : https://www.geeksforgeeks.org/problems/game-with-string4100/1
*/
/* TC ->   O(n+klog(p))  where n is the length of string and p is number of
            distinct alphabets and k number of alphabets to be removed. 

   SC ->   O(n)        
*/
//************************************** C++ ************************************************//

class Solution{
public:
    int minValue(string s, int k){
       
       unordered_map<char, int> mp;
       for(char &ch : s){
           mp[ch]++;
       }
       
       priority_queue<int> pq; // max-heap
       for(auto it : mp){
           pq.push(it.second);
       }
       
       while(k--){
           
           int top = pq.top();
           top--;
           
           pq.pop();
           if(top > 0){
               pq.push(top);
           }
       }
       
       int res = 0;
       while(!pq.empty()){
           res += pq.top()*pq.top();
           pq.pop();
       }
       return res;
    }
};

//******************************************** JAVA ******************************************************//

class Solution{
    static int minValue(String s, int k){
        
        Map<Character, Integer> mp = new HashMap<>();
        for(char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : mp.values()){
            pq.add(val);
        }
        
        while(k-- > 0){
            int top = pq.poll();
            top--;
            
            if(top > 0){
                pq.add(top);
            }
        }
        
        int res = 0;
        while(!pq.isEmpty()) {
            res += pq.peek()*pq.peek();
            pq.poll();
        }
        
        return res;
    }
}
