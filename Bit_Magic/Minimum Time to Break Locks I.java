/*
    Leetcode link      :  https://leetcode.com/problems/minimum-time-to-break-locks-i/
*/

class Solution {
    int result = Integer.MAX_VALUE;
    private int n;
    private void solve(List<Integer> strength, int mask, int currFactor, int K, int time){
        
        if(mask == ((1 << n) - 1)){
            result = Math.min(result, time);
            return;
        }

        int energy = currFactor;
        int addtime = 0;

        for(int i = 0; i < n; i++) {
            if((mask & (1 << i)) != 0) continue;

            addtime = (strength.get(i) + currFactor - 1)/currFactor; //ceil(strength[i]/currentFactor)
            solve(strength, mask | (1 << i), currFactor + K, K, time+addtime);
        }


    }
    public int findMinimumTime(List<Integer> strength, int K) {
        this.n = strength.size();
        solve(strength, 0, 1, K, 0);
        return result;

    }
}
