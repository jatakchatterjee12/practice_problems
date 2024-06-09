/*
    Leetcode Link     :   https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/

*/

class Solution {
    public int valueAfterKSeconds(int n, int k) {
        
        int M = (int)1e9+7;
        
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        
        for(int i = 0; i < k; i++){
            for(int j = 1; j < n; j++) {
                
                arr[j] = (arr[j-1] + arr[j]) % M ;
            }
        }
        return arr[n-1];
    }
}
