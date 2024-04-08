/*
    Company Tags     : Amazon, Goldman Sachs
    Leetcode Qn Link : https://leetcode.com/problems/minimum-cost-to-connect-sticks/
*/

//************************************************** C++ **************************************************************88//
class Solution {
public:
    int MinimumCost(vector<int> &sticks) {
        priority_queue<int, vector<int>, greater<int>> pq(sticks.begin(), sticks.end()); //min heap
        
        int cost = 0;
        while(pq.size() > 1) {
            int first = pq.top();
            pq.pop();
            int second = pq.top();
            pq.pop();
            
            cost += first+second;
            pq.push(first+second);
        }
        return cost;
    }
};

//********************************************** JAVA ******************************************************************//
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long it : arr){
            pq.offer(it);
        }
        
        long ans = 0L;
        
        while(pq.size() > 1) {
            
            long first = pq.poll();
            long second = pq.poll();
            
            ans += (first + second);
            
            pq.offer(first + second);
            
        }
        
        return ans;
    }
