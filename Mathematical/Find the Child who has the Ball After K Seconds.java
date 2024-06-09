/*
    Leetcode Link     :    https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
*/

class Solution {
    public int numberOfChild(int n, int k) {
        
        if(k < n) return k;
        
        int x = k/(n-1);
        int re = k%(n-1);
        
       if(x%2 == 0){
           return re;
       }
        else{
            return (n-re-1);
        }
    }
}
