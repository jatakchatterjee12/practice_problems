/*
    gfg link : https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1
    Company  : Cisco
*/

class Solution {
    
    public boolean countSub(long arr[], long n)
    {
        for(int i=0; i<n; i++){
            int leftChildIndex = 2*i+1;
            int rightChildIndex = 2*i+2;
            
            if(leftChildIndex < n && arr[leftChildIndex] > arr[i])
                return false;
                
            if(rightChildIndex < n && arr[rightChildIndex] > arr[i])
                return false;
        }
        return true;
    }
}
