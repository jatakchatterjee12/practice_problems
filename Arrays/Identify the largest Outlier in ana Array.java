/*
    Company           : Amazon OA
    Leetcode          : https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

*/

// Approach - Array contains -> [special num + sum of special num + outlier]
//            totalSum = 2S+ outlier [ S = sum of special nums]
//            S = (totalSum-outlier)/2 ,, now find if S is present in your array, if it presents then the current num can be our possible outlier
//            but make sure S and outlier can have the same value in that case, freqmap has to have count>1 for the current possible outlier.
//TC- O(n)
//SC - O(n)
class Solution {
    public int getLargestOutlier(int[] nums) {
        long totalSum = 0L;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num  : nums){
            totalSum += num;
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
        }
        

        int maxOutlier = Integer.MIN_VALUE;

        for(int possibleOutlier : nums) {
            long requiredSum = totalSum - possibleOutlier;

            if(requiredSum % 2 != 0) continue;

            long potentialSum = requiredSum/2;

            freqMap.put(possibleOutlier, freqMap.get(possibleOutlier)-1);

            int sumElement = (int) potentialSum;

            int count = freqMap.getOrDefault(sumElement, 0);
            

            if(count > 0) {
                maxOutlier = Math.max(maxOutlier, possibleOutlier);
            }

            freqMap.put(possibleOutlier, freqMap.getOrDefault(possibleOutlier,0)+1);

        }
        return maxOutlier;
    }
}
