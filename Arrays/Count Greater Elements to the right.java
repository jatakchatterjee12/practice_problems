public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        // Write your code here.

        int n = arr.length;
        int qSize = query.length;
        int[] res = new int[qSize];

        for(int i = 0; i < qSize; i++) {

            int qIdx = query[i];
            int cnt =0 ;
           
            for(int j = qIdx; j < n; j++) {
                if(arr[j] > arr[qIdx]) cnt++;
            }
            res[i] = cnt;
        }
        return res;
    }
}
