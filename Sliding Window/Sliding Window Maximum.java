/*
  
    Company Tags                     : Media.Net (Directi, 2023 repeated), Google, Zenefits, Microsoft, Zoho, Flipkart, Amazon, Directi, SAP Labs
    Leetcode Link                    : https://leetcode.com/problems/sliding-window-maximum/
    GfG Link                         : Maximum of all subarrays of size k (https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1)
    
    NOTE : Please also see hard version of this question : Leetcode-1425
    
*/ // Approach:

/*

        // step-1 When new elemwnt comes in, make space for it( window size cannot be greater than k)

        // step-2: now, when nums[i] comes ,there is no need to keep small element in the window, pop it from back
        
        // step-3: now push i  in deque -> for nums[i]

        // step-4: if( i >= k-1), then deq.front() is our answer for that window

*/

/*
  why are we deleting from the back ( pop_back() ) instead we can delete from the front also then we can use queue?

  Just do a dry run on this example : 
    [1,3,1,2,0,5], K = 3
    
    queue = {1}
    
    queue = {3} ----> 3 popped element 1 from front because 3 > 1
    
    queue = {3, 1}
    
    queue = {3, 1} -> Now, 2 came and since we can only pop from front in queue, we won't be able to pop 3 because 3 > 2.
    This is the catch, Since we have deque, we can delete 1 which is < 2.
*/

****************************************** C++ ******************************************************
//This is generally known as "Monotonic increasing/decreasing  Queue/Dequeue"
//Approach-1 (Using Deque) Every element is added(pushed) and popped only once,So it is O(n) time complexity.

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size();
        if(n == 0)
            return {};
        deque<int> deq;

        vector<int> result;
        
        for(int i = 0; i<n; i++) {
            //remove the max elements from front which are out of window size
            while(!deq.empty() && deq.front() <= i-k)
                deq.pop_front();
            
            //we maintain the deque in descending order
            while(!deq.empty() && nums[i] > nums[deq.back()])
                deq.pop_back();
            
            deq.push_back(i);

            if(i >= k-1) //Only when the window size first gets equal or greater than k
                result.push_back(nums[deq.front()]); //front will have the max element (dequeue is maintained in descending order)
        }
        return result;
    }
};

//Approach-2 (Using max-heap (priority_queue)) (worst case :O(n*log(n)) when elements are in ascending order)
class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        priority_queue<pair<int, int>> pq;
        vector<int> result;

        int n = nums.size();

        for(int i = 0; i<n; i++) {
            
            //remove the max elements which are out of window size
            while(!pq.empty() && pq.top().second <= i-k)
                pq.pop();
            
            pq.push({nums[i], i}); //we will always find the max element at top

            if(i >= k-1)
                result.push_back(pq.top().first);
        }
        return result;
    }
};



****************************************** JAVA ******************************************************
//This is generally known as "Monotonic increasing/decreasing  Queue/Dequeue"
//Approach-1 (Using Deque) Every element is added(pushed) and popped only once,So it is O(n) time complexity.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        int n = nums.length;

        int[] result = new int[n-k+1];
        int ptr = 0;

        for(int i = 0; i < n; i++) {

          //Step 1:
            while(!deq.isEmpty() && deq.peekFirst() <= i-k){
                deq.pollFirst();
            }

          //Step 2: 
            while(!deq.isEmpty() && nums[i] > nums[deq.peekLast()]){  
                deq.pollLast();   
            }

          //Step 3:
            deq.addLast(i);

          //Step 4:
            if( i >= k-1){
                result[ptr++] = nums[deq.peek()];
            }
        }
        return result;
    }
}
