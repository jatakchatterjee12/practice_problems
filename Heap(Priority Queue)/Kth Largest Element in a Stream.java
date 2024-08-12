/*
    Company Tags                : Amazon
    Leetcode Qn Link            : https://leetcode.com/problems/kth-largest-element-in-a-stream/
*/

//************************************************* C++ ****************************************************//
//Approach - (Using min-heap)
class KthLargest {
public:
    priority_queue<int, vector<int>, greater<int>> pq;
    int K;
    
    KthLargest(int k, vector<int>& nums) {
        K = k;
        for(int &x : nums) {
            pq.push(x);
            
            if(pq.size() > k)
                pq.pop();
        }
    }
    
    int add(int val) {
        pq.push(val);
        
        if(pq.size() > K)
            pq.pop();
        
        return pq.top();
    }
};

//************************************************* JAVA *********************************************************//
//Approach - (Using min-heap)
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap
    int K;

    public KthLargest(int k, int[] nums) {
        K = k;
        for(int num : nums){
            pq.add(num);
            if(pq.size() > K){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > K){
            pq.poll();
        }

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
