class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length; // bottoms.length

        int[] countTop    = new int[7]; // nums range [1,6]
        int[] countBottom = new int[7];
        int[] countSame   = new int[7];

        for(int i = 0; i < n; i++) {

            int a = tops[i];
            int b = bottoms[i];

            countTop[a]++;
            countBottom[b]++;

            if(a == b) 
              countSame[a]++;
        }

        int ans = n;
        for(int v = 1; v <= 6; v++) {

            if(countTop[v] + countBottom[v] - countSame[v] == n) {

                int minRotation = Math.min(countTop[v], countBottom[v]) - countSame[v];
                ans             = Math.min(ans, minRotation);
            }
        }
        return ans == n ? -1 : ans;
    }
}
