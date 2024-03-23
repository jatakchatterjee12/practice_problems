

class Solution {

    int[] Series(int n) {
        
        int[] ans = new int[n+1];
        
        int mod = (int)1e9+7;
        
        int prev_prev = 0;
        int prev  = 1;
        
        for(int i = 0; i<=n; i++) {
            
            int curr = (prev + prev_prev)%mod;
            
            ans[i] = prev_prev;
            
            prev_prev = prev;
            prev      = curr;
        }
        
        return ans;
        
    }
}
