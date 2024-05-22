/*
  Company Tags     :
  GFG Link         : https://www.geeksforgeeks.org/problems/shortest-job-first/1
*/

class Solution {
    static int solve(int bt[] ) {
    // code here
    Arrays.sort(bt);
    int time = 0;
    int waiting_time = 0;
    
    for(int t : bt) {
        
        
        waiting_time += time;
        time += t;
    }
    
    return waiting_time / bt.length;

  }
}
