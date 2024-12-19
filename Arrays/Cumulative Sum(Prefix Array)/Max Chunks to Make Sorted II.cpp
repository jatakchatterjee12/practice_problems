/*
    Company Tags        :  soon
    Leetcode Link       :  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
*/

/**************************************************** C++ *************************************************************//
class Solution {
public:
    int maxChunksToSorted(vector<int>& arr) {
        int n = arr.size();
        vector<int> prefixMax(begin(arr), end(arr));
        vector<int> suffixMin(begin(arr), end(arr));

        for (int i = 1; i < n; i++) {
            prefixMax[i] = max(prefixMax[i - 1], prefixMax[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = min(suffixMin[i + 1], suffixMin[i]);
        }

        int chunksCount = 0;
        for (int i = 0; i < n; i++) {
            int pehleKaMax = i > 0 ? prefixMax[i - 1] : -1;
            int baadKaMin  = suffixMin[i];
            
            if(pehleKaMax <= baadKaMin) {
                chunksCount++;
            }
        }

        return chunksCount;
    }
};


//******************************************************* JAVA ********************************************************//
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = arr[0];
        for(int i= 1; i < n ; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);
        }

        suffixMin[n-1] = arr[n-1];
        for(int i=n-2; i >= 0; i--){
            suffixMin[i] = Math.min(suffixMin[i+1], arr[i]);
        }

        int count =0;
        for(int i = 0 ; i < n ; i++){
            int pehleKaMax = i>0 ? prefixMax[i-1] : -1;
            int baadKaMin  = suffixMin[i];

            if(pehleKaMax <= baadKaMin){
                count++;
            }
        }

        return count;
    }
}
